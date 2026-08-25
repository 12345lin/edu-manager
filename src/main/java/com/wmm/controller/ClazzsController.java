package com.wmm.controller;

import com.wmm.anno.Log;
import com.wmm.pojo.*;
import com.wmm.service.ClazzsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzsController {
    @Autowired
    private ClazzsService clazzsService;

    /**
     * 分页查询班级数据
     * @param clazzsQueryParam
     * @return
     */
    @GetMapping
    public Result page(ClazzsQueryParam clazzsQueryParam){
        log.info("查询所有班级数据，{}", clazzsQueryParam);
        PageResult<Clazz> pageResult = clazzsService.page(clazzsQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 查询所有班主任数据
     * @return
     */
    @GetMapping("/listMasters")
    public Result listMasters(){
        log.info("查询所有班主任数据");
        List<String> masters = clazzsService.listMasters();
        return Result.success(masters);
    }

    /**
     * 添加班级数据
     */
    @Log("新增班级")
    @PostMapping()
    public Result addClazz(@RequestBody Clazz clazz){
        log.info("添加班级，{}", clazz);
        clazzsService.addClazz(clazz);
        return Result.success();
    }

    /**
     * 根据ID查询班级数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据ID查询班级数据，{}", id);
        Clazz clazz = clazzsService.findById(id);
        log.info("查询结果：{}", clazz);
        return Result.success(clazz);
    }

    /**
    /**
     * 更新班级数据
     */
    @Log("更新班级")
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz){
        log.info("更新班级数据，{}", clazz);
        clazzsService.updateClazz(clazz);
        return Result.success();
    }

    /**
     * 根据ID删除班级数据
     */
    @Log("删除班级")
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("删除'id为" + id + "的'班级数据");
        clazzsService.deleteById(id);
        return Result.success();
    }

    /**
     * 查询所有班级数据
     * @return
     */
    @GetMapping("/list")
    public Result list(){
        List<Clazz> clazzs = clazzsService.list();
        return Result.success(clazzs);
    }
}