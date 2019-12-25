package com.leicx.consumer.controller;

import com.leicx.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 部门服务消费者的controller
 * @author daxiong
 * @date 2019-12-17 15:10
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

//    private static final String URL_PREFIX = "http://localhost:8001";
    private static final String URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return restTemplate.getForObject(URL_PREFIX + "/dept/list", List.class);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(URL_PREFIX + "/dept/discovery", Object.class);
    }
}
