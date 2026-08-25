package com.wmm.service;

import com.wmm.pojo.*;

import java.util.List;

public interface ClazzsService {
    /**
     * 分页查询班级数据
     * @param clazzsQueryParam
     * @return
     */
    PageResult<Clazz> page(ClazzsQueryParam clazzsQueryParam);

    /**
     * 添加班级数据
     * @param clazz
     */
    void addClazz(Clazz clazz);

    /**
     * 查询所有班主任数据
     * @return
     */
    List<String> listMasters();

    /**
     * 根据ID查询班级数据
     * @param id
     * @return
     */
    Clazz findById(Integer id);

    /**
     * 更新班级数据
     * @param clazz
     */
    void updateClazz(Clazz clazz);

    /**
     * 根据ID删除班级数据
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询所有班级数据
     * @return
     */
    List<Clazz> list();
}