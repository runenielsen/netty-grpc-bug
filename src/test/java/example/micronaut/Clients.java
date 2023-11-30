package example.micronaut;

import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import io.micronaut.grpc.server.GrpcServerChannel;

@Factory
public class Clients {

    @Bean
    public NettyGrpcBugServiceGrpc.NettyGrpcBugServiceBlockingStub serviceGrpc(
            @GrpcChannel(GrpcServerChannel.NAME) ManagedChannel channel
    ) {
        return NettyGrpcBugServiceGrpc.newBlockingStub(channel);
    }

}
