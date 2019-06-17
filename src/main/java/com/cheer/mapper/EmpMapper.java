package com.cheer.mapper;

import com.cheer.demo.Emp;
import com.cheer.demo.User;
import com.cheer.demo.User2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    List<Emp> getList();

    Emp getEmp(Integer empno);

    int insert(Emp e);

    int update(Emp e);

    int delete(Integer empno);

    /**
     *
     * @param emps
     */
    public void addEmps(@Param("emps") List<Emp> emps);

    /**
     * 根据用户名和密码查询用户信息
     * @param uname 用户名
     * @param pwd	密码
     * @return 返回查询到的用户信息
     */
    User checkUserLoginDao(@Param("uname") String uname, @Param("pwd") String pwd);


    int insert1(User2 user);

    User2 find2(@Param("username") String username);

    List<User2> getUserList();
}
