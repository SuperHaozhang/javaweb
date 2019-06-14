package com.cheer.service;

import com.cheer.demo.User;
import com.cheer.demo.User2;

public interface UserService {
    void insert(User2 user) throws Exception;

    boolean checkLogin(String username, String password);

    User2 find(String username);
}
