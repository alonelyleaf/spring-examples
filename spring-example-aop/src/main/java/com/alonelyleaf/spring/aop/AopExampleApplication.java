package com.alonelyleaf.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

//@EnableRetry // 开启 Retryable 注解
@SpringBootApplication
//@EnableAspectJAutoProxy // 开启切面自动代理支持
public class AopExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }

}
