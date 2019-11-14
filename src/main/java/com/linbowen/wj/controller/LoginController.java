package com.linbowen.wj.controller;

import com.linbowen.wj.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public RuntimeException login(@RequestBody User user) {
        return new RuntimeException("服务器异常");
//        String username = user.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//
//        if (Objects.equals("123", username) && Objects.equals("456", user.getPassword())) {
//            return BaseResponse.buildSuccess("登陆成功!");
//        } else {
//            return BaseResponse.buildFail("用户名或密码不正确!");
//        }
    }

}
