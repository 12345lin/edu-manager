package com.wmm.service.impl;

import com.wmm.mapper.DeptMapper;
import com.wmm.pojo.Dept;
import com.wmm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有部门数据
     * @return
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    /**
     * 根据id删除部门数据
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 添加部门数据
     * @param dept
     */
    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    /**
     * 更新部门数据
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }

    /**
     * 根据id查询部门数据
     * @param id
     * @return
     */
    @Override
    public Dept findById(Integer id) {
        return deptMapper.selectById(id);
    }
}
