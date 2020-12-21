package com.alonelyleaf.spring.aop.controller;

import com.alonelyleaf.spring.aop.service.RetryDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bijl
 * @date 2020/12/21 下午3:37
 */
@RestController
@RequestMapping("/retry")
public class RetryDemoController {

    @Autowired
    private RetryDemoService retryDemoService;

    @GetMapping("/do")
    public boolean retry(@RequestParam("s") String s) {

        return retryDemoService.retry(s);
    }
}
