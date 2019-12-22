package com.york.boot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BootAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAsyncApplication.class, args);
    }

}
