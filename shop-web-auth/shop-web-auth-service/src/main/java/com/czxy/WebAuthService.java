package com.czxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by 音老怪 on 2018/12/13.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebAuthService {
    public static void main(String[] args) {
        SpringApplication.run(WebAuthService.class,args);
    }
}
