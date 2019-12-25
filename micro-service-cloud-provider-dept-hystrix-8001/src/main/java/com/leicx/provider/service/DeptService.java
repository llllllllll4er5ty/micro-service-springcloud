package com.leicx.provider.service;

import com.leicx.entity.Dept;

import java.util.List;

/**
 * @author daxiong
 * @date 2019-12-16 17:21
 */
public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
