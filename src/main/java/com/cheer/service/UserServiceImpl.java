package com.cheer.service;

import com.cheer.demo.User;
import com.cheer.demo.User2;
import com.cheer.mapper.EmpMapper;
import com.cheer.util.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    @Override
    public void insert(User2 user) throws Exception{
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
            i=empMapper.insert1(user);
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
        if (i != 1) {
            throw new Exception("插入失败！");
        }
    }

    @Override
    public boolean checkLogin(String username, String password) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        User2 user = null;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            user=empMapper.find2(username);

            if(user==null){
                return false;
            }
            LOGGER.info(user);

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
        // 比较密码是否相同
        if (StringUtils.encrypt(password).equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public User2 find(String username) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        User2 user = null;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            user=empMapper.find2(username);
            session.commit();
            LOGGER.info(user);

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
        return user;
    }
}
