package com.wmm.controller;

import com.wmm.pojo.JobOption;
import com.wmm.pojo.Result;
import com.wmm.pojo.StudentCountOption;
import com.wmm.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位数据");
        JobOption jobOption =reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计学生学历信息
     * @return
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeDate(){
        List<Map> degreeList = reportService.getStudentDegreeData();
        log.info("统计学生学历信息");
        return Result.success(degreeList);
    }
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计学生学历信息");
        StudentCountOption studentCountOption  = reportService.getStudentCountData();
        return Result.success(studentCountOption);
    }
}
