package com.wmm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wmm.mapper.EmpExpMapper;
import com.wmm.mapper.EmpMapper;
import com.wmm.pojo.*;
import com.wmm.service.EmpLogService;
import com.wmm.service.EmpService;
import com.wmm.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 员工服务实现类
 */
@Service
public class EmpServiceimpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExpMapper empExpMapper;
    @Autowired
    private EmpLogService empLogService;


    //原始分页查询的方式
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//        return new PageResult<>(total, rows);
    //优化分页查询的方式
    //注意事项
    //1.查询语句不能带;
    //2.只对第一个查询语句有分页效果
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        //2.执行查询
        List<Emp> rows = empMapper.list(empQueryParam);
        //3.封装结果并返回
        Page<Emp> p = (Page<Emp>) rows;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 添加员工数据
     * @param emp
     */
    @Transactional (rollbackFor = Exception.class)//事务控制----------默认出现运行时异常才会回滚RunTimeException
    @Override
    public void save(Emp emp) {
        try {
            //1.保存员工数据
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insertEmp(emp);
            //2.保存员工对应工作经历数据
            List<EmpExpr> emprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(emprList)){
                //遍历集合
                emprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExpMapper.insertBatch(emprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "添加员工数据：" + emp);
            empLogService.insertLog(empLog);
        }

    }
    /**
     * 根据ID删除员工数据
     * @param ids
     */
    @Transactional (rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
            //1.删除员工数据
            empMapper.delete(ids);
            //2.删除员工对应的工作经历数据
            empExpMapper.delete(ids);
    }

//    /**
//     * 根据ID查询员工数据
//     * @param id
//     * @return
//     */
//    @Override
//    public Emp findById(Integer id) {
//        Emp emp = empMapper.findById(id);
//        List<EmpExpr> expr = empMapper.findExprByEmpId(id);
//        emp.setExprList(expr);
//        return emp;
//    }
    /**
     * 根据ID查询员工数据
     * @param id
     * @return
     */
    @Override
    public Emp findById(Integer id) {
//        Emp emp = empMapper.findById(id);
//        List<EmpExpr> expr = empMapper.findExprByEmpId(id);
//        emp.setExprList(expr);
        return empMapper.getById(id);
    }

    @Override
    public List<Emp> list() {
        return empMapper.emplist();
    }

    /**
     * 登录员工
     * @param emp
     * @return
     */
    @Override
    public LoginInfo login(Emp emp) {

        //1.先获取数据
        Emp e = empMapper.login(emp);
        //2.判断是否登录成功
        if(e == null){
            return null;
        }
        //3.返回登录信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", e.getId());
        claims.put("username", e.getUsername());
        claims.put("password", e.getName());
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(e.getId());
        loginInfo.setUsername(e.getUsername());
        loginInfo.setName(e.getName());
        loginInfo.setToken(JwtUtils.generateJwt(claims));
        return loginInfo;
    }


    /**
     * 修改员工数据
     * @param emp
     */
    @Override
    public void update(Emp emp) {
        //1.删除工作经历的旧数据
        empExpMapper.delete(Arrays.asList(emp.getId()));
        //2.保存新的工作信息数据
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        //3.保存新的员工工作经历数据
        List<EmpExpr> emprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(emprList)){
            //遍历集合
            emprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExpMapper.insertBatch(emprList);
        }
    }
}
