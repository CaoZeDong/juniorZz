package com.junior.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableFeignClients(
        {
                "com.junior.service.account.client.feign",
                "com.junior.service.customer.client.feign",

        })
public class webApplication {

    public static void main(String[] args) {
        SpringApplication.run(webApplication.class, args);
    }

}
