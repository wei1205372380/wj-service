package com.linbowen.wj.controller;

import com.linbowen.wj.annotation.PassToken;
import com.linbowen.wj.pojo.User;
import com.linbowen.wj.result.BaseResponse;
import com.linbowen.wj.service.TagService;
import com.linbowen.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @PassToken
    @PostMapping("/login")
    public BaseResponse login(@RequestBody User user) {
        List<String> userInfo = userService.isCorrect(user.getUsername(), user.getPassword());
        return Objects.nonNull(userInfo) ? BaseResponse.buildSuccess("登录成功", userInfo) : BaseResponse.buildFail("用户名或密码错误");
    }

    @GetMapping("/test")
    @PassToken
    public BaseResponse test() {
        return BaseResponse.buildSuccess("OKKKKKKKK");
    }

}
