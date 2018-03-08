package com.sam.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:30 2018/2/28
 * @Description: 自定义用户获取逻辑
 */
@Component
public class MyUserDetailsService implements UserDetailsService,SocialUserDetailsService {
//    @Autowired
//    private Mapper...

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     加密解密密码
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名：" + username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交登录用户Id：" + userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
        //根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结等状态
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是："+password);
        /**
         返回spring security核心的user对象需要用户名，密码，授权===>用spring security的权限
         AuthorityUtils.commaSeparatedStringToAuthorityList定义权限集合
         实际都从数据库中读取
         根据查找到的用户信息判断用户是否被冻结
         真正开发的时候从数据库读取数据，利用domain映射数据库的实体类来实现UserDetail即可，实现后重写用户校验逻辑即可
         passwordEncoder.encode("123456")这个动作在注册的时候做
         *
         */
        return new SocialUser(userId, password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList(
                        "ROLE_USER"
                ));
    }
}
