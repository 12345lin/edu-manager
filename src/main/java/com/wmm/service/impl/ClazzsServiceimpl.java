package com.wmm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wmm.mapper.ClazzsMapper;
import com.wmm.pojo.*;
import com.wmm.service.ClazzsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzsServiceimpl implements ClazzsService {
    @Autowired
    private ClazzsMapper clazzsMapper;
    @Override
    public PageResult<Clazz> page(ClazzsQueryParam clazzsQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(clazzsQueryParam.getPage(), clazzsQueryParam.getPageSize());
        //2.执行查询
        List<Clazz> rows = clazzsMapper.list(clazzsQueryParam);
        //3.封装班级状态
        LocalDate now = LocalDate.now();
        rows.forEach(clazz -> {
            if (clazz.getBeginDate().isAfter(now)) {
                clazz.setStatus("未开班");
            } else if (clazz.getEndDate().isBefore(now)) {
                clazz.setStatus("已结课");
            } else {
                clazz.setStatus("在读");
            }
        });
        //4.封装结果并返回
        Page<Clazz> p = (Page<Clazz>) rows;

        return new PageResult<>(p.getTotal(), p.getResult());
    }



    /**
     * 添加班级数据
     * @param clazz
     */
    @Override
    public void addClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setCreateTime(LocalDateTime.now());
        clazzsMapper.insert(clazz);
    }

    /**
     * 查询所有班主任数据
     * @return
     */
    @Override
    public List<String> listMasters() {
        return clazzsMapper.listMasters();
    }

    /**
     * 根据ID查询班级数据
     * @param id
     * @return
     */
    @Override
    public Clazz findById(Integer id) {
        return clazzsMapper.findById(id);
    }

    /**
     * 更新班级数据
     * @param clazz
     */

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzsMapper.update(clazz);
    }

    /**
     * 根据ID删除班级数据
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        clazzsMapper.deleteById(id);
    }

    @Override
    public List<Clazz> list() {
        return clazzsMapper.listAll();
    }

}