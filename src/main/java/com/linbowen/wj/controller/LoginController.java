package com.linbowen.wj.controller;

import com.linbowen.wj.pojo.User;
import com.linbowen.wj.result.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class LoginController {

    @PostMapping("/login")
    public BaseResponse login(@RequestBody User user) {
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (Objects.equals("123", username) && Objects.equals("456", user.getPassword())) {
            return BaseResponse.buildSuccess("登陆成功!");
        } else {
            return BaseResponse.buildFail("用户名或密码不正确!");
        }
    }

}
