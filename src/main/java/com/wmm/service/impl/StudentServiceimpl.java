package com.wmm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wmm.mapper.ClazzsMapper;
import com.wmm.mapper.StudentMapper;
import com.wmm.pojo.Clazz;
import com.wmm.pojo.PageResult;
import com.wmm.pojo.Student;
import com.wmm.pojo.StudentQueryParam;
import com.wmm.service.ClazzsService;
import com.wmm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClazzsService clazzsService;
    @Autowired
    private ClazzsMapper clazzsMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        //2.执行查询
        List<Student> rows = studentMapper.list(studentQueryParam);
        //3.封装结果并返回
        Page<Student> p = (Page<Student>) rows;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 添加学生数据
     * @param student
     */
    @Override
    public void insert(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    /**
     * 批量删除学生数据
     * @param ids
     */
    @Override
    public void deleteById(Integer[] ids) {
        for (Integer id : ids) {
            studentMapper.deleteById(id);
        }
    }

    /**
     * 根据ID查询学生数据
     * @param id
     * @return
     */
    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    /**
     * 更新学生数据
     * @param student
     */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());

        // 如果clazzId为null但clazzName有值，需要根据班级名称查询班级ID
        if (student.getClazzId() == null && student.getClazzName() != null && !student.getClazzName().isEmpty()) {
            Integer clazzId = clazzsMapper.findIdByName(student.getClazzName());
            if (clazzId != null) {
                student.setClazzId(clazzId);
            }
        }
        studentMapper.update(student);
    }

    /**
     * 更新学生违纪数据
     * @param id
     * @param score
     */
    @Override
    public void updateViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
}
