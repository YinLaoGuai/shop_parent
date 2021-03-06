package com.czxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 音老怪 on 2018/12/12.
 */
@SpringBootApplication
@EnableEurekaServer

public class WebRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebRegistryApplication.class,args);
    }
}
