package com.wmm.service;


import com.wmm.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门数据
     */
    List<Dept> findAll();

    /**
     * 根据id删除部门数据
     * @param id
     */
    void deleteById(Integer id);
    /**
     * 添加部门数据
     * @param dept
     */
    void addDept(Dept dept);
    /**
     * 更新部门数据
     * @param dept
     */
    void updateDept(Dept dept);
    /**
     * 根据id查询部门数据
     * @param id
     * @return
     */
    Dept findById(Integer id);
}
