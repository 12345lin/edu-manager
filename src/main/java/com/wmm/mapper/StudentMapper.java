package com.wmm.mapper;

import com.wmm.pojo.Student;
import com.wmm.pojo.StudentCountOption;
import com.wmm.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam);

    /**
     * 添加学生数据
     * @param student
     */
    void insert(Student student);

    /**
     * 根据ID删除学生数据
     * @param id
     */
    void deleteById(Integer id);

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

    /**
     * 统计学生学历数据
     * @return
     */
    List<Map> countStudentDegreeData();

    /**
     * 统计班级人数数据
     * @return
     */
    List<Map<String, Object>> countStudentCountData();
}
