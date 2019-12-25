package com.leicx.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon负载均衡自定义配置类
 * @author daxiong
 * @date 2019-12-24 16:29
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRule() {
        return new RandomRule_LCX();
    }
}
