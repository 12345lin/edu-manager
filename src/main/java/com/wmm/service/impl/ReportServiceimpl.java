package com.wmm.service.impl;

import com.wmm.mapper.EmpMapper;
import com.wmm.mapper.StudentMapper;
import com.wmm.pojo.JobOption;
import com.wmm.pojo.StudentCountOption;
import com.wmm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ReportServiceimpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public JobOption getEmpJobData() {
            //1.调用Mapper获取数据
            List<Map<String, Object>> list = empMapper.countEmpJobData();
            //2.组装数据并返回
        List<Object> job = list.stream().map(dataMap -> dataMap.get("job")).toList();
        List<Object> data = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(job, data);
    }

    /**
     * 统计员工性别信息
     * @return
     */
    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    /**
     * 统计学生学历信息
     * @return
     */
    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    /**
     * 统计学生班级人数信息
     * @return
     */
    @Override
    public StudentCountOption getStudentCountData() {
        //1.调用Mapper获取数据
        List<Map<String,Object>> list = studentMapper.countStudentCountData();

        //2.组装数据并返回
        List<Object> nameList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("value")).toList();
        return new StudentCountOption(nameList, dataList);
    }
}
