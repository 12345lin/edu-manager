package com.wmm.controller;

import com.wmm.anno.Log;
import com.wmm.pojo.PageResult;
import com.wmm.pojo.Result;
import com.wmm.pojo.Student;
import com.wmm.pojo.StudentQueryParam;
import com.wmm.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 分页查询所有学生数据
     * @param studentQueryParam
     * @return
     */
    @GetMapping
    public Result list(StudentQueryParam studentQueryParam){
        log.info("分页查询所有学生数据,{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加学生数据
     */
    @Log("新增学生")
    @PostMapping
    public Result insert(@RequestBody Student student){
        log.info("添加学生数据：{}", student);
        studentService.insert(student);
        return Result.success();
    }

    /**
     * 批量删除学生数据
     */
    @Log("删除学生")
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer[] ids){
        log.info("删除'id为" + ids + "的'学生数据");
        studentService.deleteById(ids);
        return Result.success();
    }

    /**
     * 根据ID查询学生数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询学生数据：{}", id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    /**
     * 更新学生数据
     */
    @Log("更新学生")
    @PutMapping()
    public Result update(@RequestBody Student student){
        log.info("更新学生数据：{}", student);
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id,@PathVariable Integer score){
        log.info("更新学生数据：{}", id,score);
        studentService.updateViolation(id,score);
        return Result.success();
    }
}
