## GO GRPC
* https://docs.microsoft.com/en-us/aspnet/core/grpc/aspnetcore?view=aspnetcore-3.1&tabs=visual-studio	
* protoc --proto_path=proto --proto_path=third_party --go_out=plugins=grpc:proto service.proto
* protoc --go_out=. *.proto
* protoc --go_out=. pb/*.proto
* protoc --proto_path=src --go_out=build/gen --go_opt=paths=source_relative src/foo.proto src/bar/baz.proto
* protoc -I pb/ pb/person.proto --go_out=plugins=grpc:person
* go get -u -v github.com/gogo/protobuf/proto
* go get -u -v github.com/gogo/protobuf/protoc-gen-gogo
* go get -u -v github.com/gogo/protobuf/gogoproto
* go get -u -v google.golang.org/grpc
* go get -u -v github.com/golang/protobuf/protoc-gen-go
* go get github.com/golang/protobuf/protoc-gen-go
* protoc -I pb/ pb/person.proto --go_out=plugins=grpc:person
* protoc -I pb/ pb/person.proto --go_out=plugins=grpc:pb
* https://www.youtube.com/watch?v=uaMyiOFXs5U