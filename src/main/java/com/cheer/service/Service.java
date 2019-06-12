package com.cheer.service;

import com.cheer.demo.Emp;

import java.util.List;

public interface Service {
     List<Emp> getEmpList();

     int delete(Integer empno);

     int insert(Emp e);
}
