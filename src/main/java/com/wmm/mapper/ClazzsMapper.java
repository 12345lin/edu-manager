package com.wmm.mapper;

import com.wmm.pojo.Clazz;
import com.wmm.pojo.ClazzsQueryParam;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ClazzsMapper {
    /**
     * 查询班级数据
     * @param clazzsQueryParam
     * @return
     */
    List<Clazz> list(ClazzsQueryParam clazzsQueryParam);
   @Insert("insert into clazz(name,room,begin_date,end_date,master_id,subject,create_time,update_time) " +
           "values(#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime})")
    void insert(Clazz clazz);

   @Select("select emp.name from emp left join clazz on emp.id = clazz.master_id")
    /**
     * 查询所有班主任数据
     * @return
     */
    List<String> listMasters();

    /**
     * 根据ID查询班级
     * @param id
     * @return
     */
    Clazz findById(Integer id);

    /**
     * 更新班级数据
     * @param clazz
     */
    void update(Clazz clazz);

    /**
     * 根据ID删除班级数据
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询所有班级数据
     * @return
     */
    List<Clazz> listAll();

    /**
     * 根据班级名称查询ID
     * @param name 班级名称
     * @return 班级ID
     */
    Integer findIdByName(String name);
}