package com.wmm.controller;

import com.wmm.anno.Log;
import com.wmm.pojo.*;
import com.wmm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * 员工控制器
 */
@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查询所有员工数据
     */
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page
//            , @RequestParam(defaultValue = "10") Integer pageSize
//            , String name
//            , Integer  gender
//            ,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin
//            ,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
//                       ){
//        log.info("查询所有员工数据，page={}, pageSize={}, name={}, gender={}, begin={}, end={}", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("查询所有员工数据，{}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 添加员工数据
     */
    @Log("新增员工")
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("添加员工数据：{}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 批量删除员工数据
     */
    @Log("删除员工")
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工数据：{}", ids);
        empService.delete(ids);

        return Result.success();
    }

    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询员工数据：{}", id);
        //Emp emp = empService.findById(id);
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    /**
     * 更新员工数据
     */
    @Log("更新员工")
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工数据：{}", emp);
        empService.update(emp);
        return Result.success();
    }


    @GetMapping("/list")
    public Result list(){
        log.info("查询所有员工数据");
        List<Emp> list = empService.list();
        return Result.success(list);
    }
}
