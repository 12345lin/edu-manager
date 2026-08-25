package com.wmm.mapper;

import com.wmm.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 员工表映射接口
 */
@Mapper
public interface EmpMapper {
    //原始分页查询的方式
//    /**
//     * 查询所有员工数据的数量
//     * @return
//     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//    /**
//     * 查询所有员工数据
//     * @return
//     */
//    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);

    //引入PageHelper分页插件的方式
//    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id  " +
//            "where e.entry_date between #{begin} and #{end} and order by e.update_time desc")

    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 添加员工数据
     * @param emp
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into   emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
        " values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insertEmp(Emp emp);


    /**
     * 批量删除员工数据
     * @param ids
     */
    void delete(List<Integer> ids);
//    /**
//     * 根据ID查询员工数据
//     * @param id
//     * @return
//     */
//    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id where e.id = #{id}")
//    Emp findById(Integer id);
//    /**
//     * 查询工作经历数据
//     */
//    @Select("select * from emp_expr where emp_id = #{empId}")
//    List<EmpExpr> findExprByEmpId(Integer empId);
    /**
     * 修改员工数据
     * @param emp
     */
    void update(Emp emp);

    /**
     * 查询回显
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 统计员工职位 数据
     * @return
     */
    List<Map<String,Object>> countEmpJobData();

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map> countEmpGenderData();

    /**
     * 查询所有员工
     * @return
     */
    @Select("select * from emp")
    List<Emp> emplist();

    /**
     * 登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
