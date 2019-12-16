package com.linbowen.wj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.linbowen.wj.mapper")
@SpringBootApplication(scanBasePackages = {"com.linbowen.wj"})
public class WjServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjServiceApplication.class, args);
    }

}
