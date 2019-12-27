package com.leicx.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务端
 * @author daxiong
 * @date 2019-12-17 16:53
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaBootApplication_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaBootApplication_7001.class, args);
    }
}
