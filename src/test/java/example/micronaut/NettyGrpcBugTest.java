package example.micronaut;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class NettyGrpcBugTest {

    private final NettyGrpcBugServiceGrpc.NettyGrpcBugServiceBlockingStub stub;

    public NettyGrpcBugTest(NettyGrpcBugServiceGrpc.NettyGrpcBugServiceBlockingStub stub) {
        this.stub = stub;
    }

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testCallStub() {
        NettyGrpcBugReply reply = stub.send(NettyGrpcBugRequest.newBuilder().setName("John").build());
        Assertions.assertEquals(reply.getMessage(), "Hello");
    }
}
