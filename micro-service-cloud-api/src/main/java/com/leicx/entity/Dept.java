package com.leicx.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门实体
 * @author daxiong
 * @date 2019-12-16 16:40
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    // 主键
    private Long deptno;
    // 部门名称
    private String dname;
    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String db_source;

    public Dept(String dname) {
        super();
        this.dname = dname;
    }
}
