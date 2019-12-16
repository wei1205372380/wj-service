package com.linbowen.wj.service;

import com.linbowen.wj.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 验证登录信息是否正确，并返回当前用户id和token
     * @param username
     * @param password
     * @return
     */
    public List<String> isCorrect(String username, String password);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public User getUserById(int id);

    /**
     * 根据用户名判断用户是否存在
     * @param username
     * @return
     */
    public boolean isExistByUsername(String username);

    /**
     * 插入单个用户
     * @param user
     */
    public void insert(User user);

}
