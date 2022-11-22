package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.service.GreeterImpl;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) {
        try {
            // 서버 listen
            Server server = ServerBuilder.forPort(8999).addService(new GreeterImpl()).build();

            // 서버 구동
            server.start();
            // 서버 구동 로깅
            System.out.println("Server started at " + server.getPort());

            // 서버 대기
            server.awaitTermination();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}