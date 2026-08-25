package com.wmm.service;

import com.wmm.pojo.*;


public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 添加学生数据
     * @param student
     */
    void insert(Student student);

    /**
     * 根据ID删除学生数据
     * @param ids
     */
    void deleteById(Integer[] ids);

    /**
     * 根据ID查询学生数据
     * @param id
     * @return
     */
    Student findById(Integer id);

    /**
     * 更新学生数据
     * @param student
     */
    void update(Student student);

    /**
     * 更新学生违纪数据
     * @param id
     * @param score
     */
    void updateViolation(Integer id, Integer score);
}
