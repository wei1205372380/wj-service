package com.linbowen.wj.service.impl;

import com.linbowen.wj.mapper.UserMapper;
import com.linbowen.wj.pojo.User;
import com.linbowen.wj.service.UserService;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<String> isCorrect(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (Objects.nonNull(user) && StringUtils.equals(user.getPassword(), password)) {
            List<String> userInfo = new ArrayList<>(2);
            userInfo.add(user.getToken());
            userInfo.add(String.valueOf(user.getId()));

            return userInfo;
        }

        return null;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean isExistByUsername(String username) {
        return userMapper.selectByUsername(username) == null ? false : true;
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }


}
