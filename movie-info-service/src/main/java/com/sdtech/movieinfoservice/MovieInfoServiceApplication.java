package com.sdtech.movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieInfoServiceApplication
{

    @Bean
    public RestTemplate getSomething()
    {
        return new RestTemplate();
    }

    public static void main( String[] args )
    {
        SpringApplication.run( MovieInfoServiceApplication.class, args );
    }

}
