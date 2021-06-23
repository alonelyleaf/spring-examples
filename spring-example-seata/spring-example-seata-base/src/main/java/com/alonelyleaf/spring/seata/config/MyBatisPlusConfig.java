package com.alonelyleaf.spring.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * MyBatisPlus 配置
 *
 * @author bijl
 * @date 2021/3/22 下午9:09
 */
@Configuration
@PropertySource("classpath:/mybatis-plus.yml")
@MapperScan({"com.alonelyleaf.spring.seata.**.mapper.**"})
public class MyBatisPlusConfig {

}
