package main

import (
	"context"
	"github.com/golang/protobuf/proto"
	"fmt"
	"log"
	"net"
	"google.golang.org/grpc"
	"google.golang.org/grpc/reflection"
	"github.com/denjos/demo/pb"
)

func main(){
	person:=&pb.Person{
		Name:"javier",
		Age:18,
	}
	data,err:=proto.Marshal(person)
	if err != nil {
		log.Fatal("Marshalling error: ",err)
	}
	fmt.Println(data)

	newPerson:=&pb.Person{}
	err=proto.Unmarshal(data,newPerson)
	if err!=nil {
		log.Fatal("unmarshalling error: ",err)
	}
	fmt.Println(newPerson)
	fmt.Println("test 1")

	listener,err:=net.Listen("tcp",":4040")
	if err!=nil{
		panic(err)
	}
	srv:=grpc.NewServer()
	pb.RegisterAddServiceServer(srv,&server{})
	reflection.Register(srv)

	if e:=srv.Serve(listener); e!=nil{
		panic(e)
	}

}

type server struct{}

func (s *server) Add(ctx context.Context, request *pb.Request) (*pb.Response,error){
	a,b:=request.GetA(),request.GetB()
	result:=a+b
	return &pb.Response{Result: result},nil
}
func (s *server) Multiply(ctx context.Context, request *pb.Request) (*pb.Response,error){
	a,b:=request.GetA(),request.GetB()
	result:=a*b
	return &pb.Response{Result: result},nil
}