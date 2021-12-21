package com.client.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.MyServiceGrpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ClientApplication.class, args);
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
				.usePlaintext()
				.build();
		MyServiceGrpc.MyServiceBlockingStub myServiceStub = MyServiceGrpc.newBlockingStub(channel);
		HelloRequest request = HelloRequest.newBuilder()
				.setName("kartikeya")
				.build();
		System.out.println(myServiceStub.sayHello(request).getMessage());
		channel.shutdown();
	}

}
