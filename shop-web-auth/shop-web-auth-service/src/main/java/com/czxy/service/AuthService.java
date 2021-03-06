package com.czxy.service;


import com.czxy.client.UserClient;
import com.czxy.config.JwtProperties;

import com.czxy.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 音老怪 on 2018/12/13.
 */
@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {

    @Resource
    private UserClient userClient;
    /**
     * 登录操作
     * @param name  姓名
     * @param password 密码
     * @return  token值
     */
    public User login(String name , Integer password){
        try {
            //1 登录--查询
            User user = userClient.queryUser( name ,password ).getBody();
            //2 如果不为空，生产token
            if(user != null){
                return user ;
            }
            //3 如果为空
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;        //没有登录成功
    }

}
