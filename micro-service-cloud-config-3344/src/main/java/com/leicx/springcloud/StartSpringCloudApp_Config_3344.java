package com.leicx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author daxiong
 * @date 2019-12-27 10:16
 */
@SpringBootApplication
@EnableConfigServer
public class StartSpringCloudApp_Config_3344 {
    public static void main(String[] args) {
        SpringApplication.run(StartSpringCloudApp_Config_3344.class, args);
    }
}
