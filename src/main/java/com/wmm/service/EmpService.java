package com.wmm.service;

import com.wmm.pojo.*;

import java.util.List;

public interface EmpService {

//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
     PageResult<Emp> page(EmpQueryParam  empQueryParam);

    /**
     *  添加员工数据
     * @param emp
     */

    void save(Emp emp);
    /**
     * 根据ID删除员工信息
     * @param ids
     */
    void delete(List<Integer> ids);

//    /**
//     * 根据ID查询员工信息
//     * @param id
//     * @return
//     */
//    Emp findById(Integer id);
    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 查询回显
     * @param id
     * @return
     */
    Emp findById(Integer id);

    /**
     * 查询所有员工数据
     * @return
     */
    List<Emp> list();

    /**
     * 登录
     * @param emp
     * @return
     */
    LoginInfo login(Emp emp);
}
