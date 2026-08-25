package com.wmm.service;

import com.wmm.pojo.JobOption;
import com.wmm.pojo.StudentCountOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    /**
     * 统计员工性别信息
     */
    List<Map> getEmpGenderData();



    /**
     * 统计学生学历信息
     * @return
     *
     */
    List<Map> getStudentDegreeData();

    /**
     * 统计学生班级人数信息
     * @return
     */
    StudentCountOption getStudentCountData();
}
