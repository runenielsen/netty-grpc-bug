package example.micronaut;

import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;

@Singleton
public class NettyGrpcBugService extends NettyGrpcBugServiceGrpc.NettyGrpcBugServiceImplBase {

    @Override
    public void send(NettyGrpcBugRequest request, StreamObserver<NettyGrpcBugReply> responseObserver) {
        NettyGrpcBugReply reply = NettyGrpcBugReply.newBuilder().setMessage("Hello").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
