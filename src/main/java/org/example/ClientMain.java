package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.proto.GreeterGrpc;
import org.example.proto.Helloworld;
import org.example.service.GreeterImpl;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8999).usePlaintext().build();

        GreeterGrpc.GreeterBlockingStub bookStub = GreeterGrpc.newBlockingStub(channel);

        Helloworld.HelloReply reply = bookStub.sayHello(Helloworld.HelloRequest.newBuilder().setName("gRPC").build());
        System.out.println(reply.getMessage());

        channel.shutdown();
    }
}
