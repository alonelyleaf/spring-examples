package com.alonelyleaf.spring.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

/**
 * 自定义 UserDetailsService
 *
 * @author bijl
 * @date 2020/12/25 下午4:41
 */
public class SpitterUserService implements UserDetailsService {

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 定义获取用户信息方式及拓展用户信息

        return new MyUserDetails("", "", "", AuthorityUtils.commaSeparatedStringToAuthorityList(" "));
    }


    public static class MyUserDetails extends User {

        private String nickName;

        public MyUserDetails(String nickName, String username, String password, Collection<? extends GrantedAuthority> authorities) {
            super(username, password, authorities);
            this.nickName = nickName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}
