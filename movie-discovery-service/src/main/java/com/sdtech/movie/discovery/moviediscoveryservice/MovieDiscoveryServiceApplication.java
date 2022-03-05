package com.sdtech.movie.discovery.moviediscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MovieDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDiscoveryServiceApplication.class, args);
	}

}
