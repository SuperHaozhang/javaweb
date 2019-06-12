package com.cheer.mapper;

import com.cheer.demo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    List<Emp> getList();

    int insert(Emp e);

    int update(Emp e);

    int delete(Integer empno);

    /**
     *
     * @param emps
     */
    public void addEmps(@Param("emps") List<Emp> emps);
}
