package com.alonelyleaf.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.activation.DataSource;

/**
 * Spring-Security
 *
 * https://potoyang.gitbook.io/spring-in-action-v4/untitled-3
 *
 * @author bijl
 * @date 2020/12/25 下午4:24
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    // configure(WebSecurity) 通过重载，配置 Spring Security 的 Filter 链
    //configure(HttpSecurity) 通过重载，配置如何通过拦截器保护请求
    //configure(AuthenticationManagerBuilder) 通过重载，配置 user-detail 服务

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/spitters/me").authenticated()
            .antMatchers(HttpMethod.POST, "/spittles").authenticated()
            .anyRequest().permitAll();

        // 1 使用 Spring 表达式进行安全保护
        //.antMatchers("/spitter/me")
        //    .access("hasRole('ROLE_SPITTER') and hasIpAddress('192.168.1.2')");

        // 2 为选定的 URL 强制使用 HTTPS
//        .requeresChannel()
//            .antMatchers("/spitter/form").requiresSecure();

        // 3 禁止跨域
//        http
//            .csrf()
//            .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 1 配置内存保存用户信息
//        auth
//            .inMemoryAuthentication()
//            .withUser("user").password("password").authorities("ROLE_USER")
//            .and()
//            .withUser("admin").password("password").authorities("ROLE_USER", "ROLE_ADMIN");


        // 2 配置数据库保存用户信息，并自定义查询语句
        // 将默认的 SQL 查询替换为自定义的设计时，很重要的一点就是要遵循查询的基本协议。所有查询都将用户名作为唯一的参数。认证查询会选取用户名、
        // 密码以及启用状态信息。权限查询会选取零行或多行包含该用户名及其权限信息的数据。群组权限查询会选取零行或多行数据，每行数据中都会包含群组 ID、群组名称以及权限。
//        auth
//            .jdbcAuthentication()
//            .dataSource(dataSource)
//            .usersByUsernameQuery(
//                "select username, password, true " +
//                    "from Spitter where username=?")
//            .authoritiesByUsernameQuery(
//                "select username, 'ROLE_USER' from Spitter where username=?")
//            .passwordEncoder(new StandardPasswordEnconder("123456"));

        // 3 基于LDAP进行认证
//        auth
//            .ldapAuthentication()
//            .userSearchBase("ou=people")
//            .userSearchFilter("{uid={0}}")
//            .groupSearchBase("ou=groups")
//            .groupSearchFilter("member={0}")
//            .passwordCompare()
//            .passwordEncoder(new Md5PasswordEncoder())
//            .passwordAttribute("passcode") // 设置密码属性
//            .contextSource() // 配置远程服务器
//            .url("ldap://habuma.com:389/dc=habuma,dc=com");

        // 4 配置自定义的用户服务
        auth
            .userDetailsService(new SpitterUserService());
    }
}
