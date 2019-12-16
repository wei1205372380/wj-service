package com.linbowen.wj.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.linbowen.wj.annotation.PassToken;
import com.linbowen.wj.pojo.User;
import com.linbowen.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 身份验证拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    // 未登录
    private final static int NOT_LOGGED_IN = 401;

    // 登录过期
    private final static int EXPIRED = 403;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        // 如果不是映射到方法，则直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 方法是否有PassToken注解，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        if (token == null) {
            response.setStatus(NOT_LOGGED_IN);
            return false;
        } else {
            String userId = JWT.decode(token).getAudience().get(0);
            if (!isNumber(userId)) {
                response.setStatus(EXPIRED);
                return false;
            }
            User user = userService.getUserById(Integer.valueOf(userId));
            if (Objects.isNull(user)) {
                response.setStatus(EXPIRED);
                return false;
            }
            // 验证token
            JWTVerifier jwtVerfier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try {
                jwtVerfier.verify(token);
            } catch (Exception e) {
                response.setStatus(EXPIRED);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 判断一个字符串是否为自然数
     * @param str
     * @return
     */
    private boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
