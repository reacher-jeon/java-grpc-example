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
        // gRPC 서버 채널 연결
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8999).usePlaintext().build();

        // gRPC 서버 채널에 대한 스텁 생성
        GreeterGrpc.GreeterBlockingStub bookStub = GreeterGrpc.newBlockingStub(channel);

        // gRPC protobuf 를 이용한 요청 및 결과 처리
        Helloworld.HelloResponse reply = bookStub.sayHello(Helloworld.HelloRequest.newBuilder().setName("gRPC").build());

        // 응답에 대한 메시지 출력
        System.out.println(reply.getMessage());

        // 채널 연결 해제
        channel.shutdown();
    }
}
