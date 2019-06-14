package com.cheer.service;

import com.cheer.demo.Emp;
import com.cheer.demo.User;

import java.util.List;

public interface Service {
     List<Emp> getEmpList();

     Emp getEmp(Integer empno);

     int delete(Integer empno);

     int insert(Emp e);

     int update(Emp e);

     User checkUserLoginService(String uname, String pwd);
}
