package org.example.service;

import io.grpc.stub.StreamObserver;
import org.example.proto.GreeterGrpc;
import org.example.proto.Helloworld;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    /* 프로그램에 대한 정보. 이 기능을 자동 생성할 수 있습니다. Intellij에서는 단축키 ctrl + O를 사용하여 다음을 수행할 수 있습니다. */
    @Override
    public void sayHello(Helloworld.HelloRequest request, StreamObserver<Helloworld.HelloResponse> responseObserver) {
        // gRPC protobuf 를 이용한 요청 및 결과 처리
        Helloworld.HelloResponse reply = Helloworld.HelloResponse.newBuilder().setMessage("Hello " + request.getName()).build();

        // StreamObserver 를 이용하여 스텁에 전달
        // 응답이 여러 개인 경우 onNext 함수를 여러 번 호출할 수 있습니다. 다음 커밋에서
        responseObserver.onNext(reply);
        // 응답 옵저버의 onCompleted 메서드를 사용하여 RPC 처리를 완료했음을 지정합니다.
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(Helloworld.HelloRequest request, StreamObserver<Helloworld.HelloResponse> responseObserver) {
        Helloworld.HelloResponse reply = Helloworld.HelloResponse.newBuilder().setMessage("Hello again " + request.getName()).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}