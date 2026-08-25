package com.wmm.controller;

import com.wmm.anno.Log;
import com.wmm.pojo.Dept;
import com.wmm.pojo.Result;
import com.wmm.service.DeptService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);
@Autowired
    private DeptService deptService;

//@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门数据
     */
    @Log("删除部门")
    @DeleteMapping
//    如果前端传递的参数名称和形参名称一致，那么@RequestParam可以省略
    //@RequestParam("id")
    public Result deleteById( Integer id){
        log.info("删除'id为" + id + "的'部门数据");
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 添加部门数据
     */
    @Log("新增部门")
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门数据：" + dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /*
    * 根据ID查询部门数据
     */
    @GetMapping("/{id}")
//    ("id") 如果前端传递的参数名称和形参名称一致，那么("id")可以省略
//    public Result findById(@PathVariable("id") Integer id) {
    public Result findById(@PathVariable Integer id) {
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }
   /**
    * 更新部门数据
    */
    @Log("更新部门")
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门数据" + dept);
        deptService.updateDept(dept);
        return Result.success();
    }

}
