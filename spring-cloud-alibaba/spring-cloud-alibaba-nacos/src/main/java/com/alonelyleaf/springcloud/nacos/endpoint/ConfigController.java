package com.alonelyleaf.springcloud.nacos.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的描述
 *
 * @author bijl
 * @date 2021/1/27 下午8:16
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @RequestMapping("/get")
    public boolean get() {

        return useLocalCache;
    }
}
