package com.wmm.mapper;

import com.wmm.pojo.Emp;
import com.wmm.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工经验表映射接口
 */
@Mapper
public interface EmpExpMapper {

    void insertBatch(@Param("emprList") List<EmpExpr> emprList);


    void delete(List<Integer> ids);

    void deleteById(Integer id);
}
