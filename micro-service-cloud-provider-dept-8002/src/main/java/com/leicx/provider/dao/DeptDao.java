package com.leicx.provider.dao;

import com.leicx.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门dao
 * @author daxiong
 * @date 2019-12-17 08:29
 */
//@Mapper
@Repository
public interface DeptDao {
    /**
     * 新增部门
     * @author daxiong
     * @date 2019-12-17 08:28
     * @param dept
     * @return boolean
     */
    boolean addDept(Dept dept);

    /**
     * 根据部门id获取部门
     * @author daxiong
     * @date 2019-12-17 08:28
     * @param id
     * @return com.leicx.entity.Dept
     */
    Dept findById(Long id);

    /**
     * 获取所有的部门
     * @author daxiong
     * @date 2019-12-17 08:28
     * @param
     * @return java.util.List<com.leicx.entity.Dept>
     */
    List<Dept> findAll();
}