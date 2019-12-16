package com.linbowen.wj.mapper;

import com.linbowen.wj.pojo.User;

public interface UserMapper {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 插入单个用户
     * @param user
     */
    void insert(User user);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User selectById(int id);

}
