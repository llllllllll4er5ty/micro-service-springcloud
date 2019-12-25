package com.leicx.consumer.controller;

import com.leicx.entity.Dept;
import com.leicx.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门服务消费者的controller
 * @author daxiong
 * @date 2019-12-17 15:10
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/add")
    public Boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptClientService.list();
    }

    @GetMapping("/discovery")
    public Object discovery() {
        return deptClientService.discovery();
    }
}
