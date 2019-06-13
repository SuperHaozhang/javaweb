package com.cheer.service;

import com.cheer.Filter.FirstFilter;
import com.cheer.demo.Emp;
import com.cheer.mapper.EmpMapper;
import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceImp implements Service {
    private static final Logger LOGGER = LogManager.getLogger(ServiceImp.class);

    public static void main(String[] args) {
        Service s = new ServiceImp();
        s.getEmpList();
    }

    @Override
    public List<Emp> getEmpList() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        List<Emp> list =null;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            list = empMapper.getList();
            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int delete(Integer empno){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        int i=0;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            i=empMapper.delete(empno);
            session.commit();
            LOGGER.info(i);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override
    public int insert(Emp emp) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        int i=0;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            i=empMapper.insert(emp);
            session.commit();
            LOGGER.info(i);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override
    public int update(Emp emp) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        int i=0;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            i=empMapper.update(emp);
            session.commit();
            LOGGER.info(emp);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

}
