package com.denjos.app;

import io.grpc.stub.StreamObserver;

public class AddService extends AddServiceGrpc.AddServiceImplBase {

    @Override
    public void add(User.Request request, StreamObserver<User.Response> responseObserver) {
        User.Response.Builder response = User.Response.newBuilder();
        response.setResult(request.getA()+request.getB());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void multiply(User.Request request, StreamObserver<User.Response> responseObserver) {
        User.Response.Builder response=User.Response.newBuilder();
        response.setResult(request.getA()*request.getB());

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
