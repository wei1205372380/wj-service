package com.linbowen.wj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.linbowen.wj"})
public class WjServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjServiceApplication.class, args);
    }

}
