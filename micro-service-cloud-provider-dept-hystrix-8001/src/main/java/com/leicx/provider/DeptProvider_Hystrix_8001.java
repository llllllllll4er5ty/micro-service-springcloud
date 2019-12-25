package com.leicx.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author daxiong
 * @date 2019-12-16 17:29
 */
@SpringBootApplication
@MapperScan("com.leicx.provider.dao")
@EnableEurekaClient
@EnableCircuitBreaker
public class DeptProvider_Hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_Hystrix_8001.class, args);
    }
}
