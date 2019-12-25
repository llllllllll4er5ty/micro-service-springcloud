package com.leicx.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 消费者启动类
 *
 * @author daxiong
 * @date 2019-12-17 15:09
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.leicx.service"})
@ComponentScan(basePackages = {"com.leicx"})
public class DeptConsumer_feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign.class, args);
    }
}
