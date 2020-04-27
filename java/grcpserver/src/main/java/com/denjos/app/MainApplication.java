package com.denjos.app;


import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MainApplication {
    public static void main(String args[]) throws IOException, InterruptedException {
            Server server= ServerBuilder.forPort(9090).addService(new AddService()).build();
            server.start();
            server.awaitTermination();
    }
}
