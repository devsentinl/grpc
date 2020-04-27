package com.denjos.app;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MainApplication {
    public static void main(String args[]){
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",4040)
                .usePlaintext().build();
        AddServiceGrpc.AddServiceBlockingStub stub= AddServiceGrpc.newBlockingStub(channel);
         User.Request request= User.Request.newBuilder().setA(2).setB(3).build();
        User.Response response=stub.multiply(request);
        System.out.println(response.getResult());
    }
}
