package com.alonelyleaf.spring.aop.service;

import com.alonelyleaf.spring.aop.annotation.ExceptionReTry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * 重试注解 Demo
 *
 * @author bijl
 * @date 2020/12/21 下午3:25
 */
@Slf4j
@Service
public class RetryDemoService {

    /**
     * 方法重试，重试后返回重试的值，而不是首次的异常
     *
     * @param
     * @return
     */
    //@Retryable(include = {RuntimeException.class}, maxAttempts = 2)
    @ExceptionReTry(value = RuntimeException.class)
    public boolean retry(String s) {

        int value = (int) (Math.random() * 10);

        if (value > 3) {
            log.error("抛出异常, value: {}", value);
            throw new RuntimeException("抛出异常" + value);
        }

        log.info("返回，value: {}", value);

        return true;
    }
}
