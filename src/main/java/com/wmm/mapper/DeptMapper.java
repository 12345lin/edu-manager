package com.wmm.mapper;

import com.wmm.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {

     // 查询所有部门
      //@return

 //查询所有部门数据
 //式一：动结果映射
 //aResults({
 //aResult(column = "create_time", property = "createTime"),aResult(column = "update_time", property = "updateTime")
 //})
 //方式二：起别名
//    @Select("select id, name, create_time as createTime, update_time as updateTime  from dept order by update_time desc")

 /**
  * 查询所有部门数据
  * @return
  */
 @Select("select id, name, create_time, update_time  from dept order by update_time desc")
    List<Dept> findAll();

    /**
     * 根据id删除部门数据
     * @param id
     */
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    /**
     * 添加部门数据
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);
  /**
  * 修改部门数据
  * @param dept
   */
  @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void updateDept(Dept dept);

    /**
     * 根据id查询部门数据
     * @param id
     * @return
     */
    @Select("select id, name, create_time, update_time  from dept where id=#{id}")
    Dept selectById(Integer id);
}
