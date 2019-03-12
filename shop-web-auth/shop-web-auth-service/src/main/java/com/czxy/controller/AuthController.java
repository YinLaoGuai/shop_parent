package com.czxy.controller;


import com.czxy.auth.entity.UserInfo;
import com.czxy.auth.util.JwtUtils;
import com.czxy.config.JwtProperties;
import com.czxy.pojo.User;
import com.czxy.service.AuthService;
import com.czxy.vo.BaseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 音老怪 on 2018/12/13.
 */
@RestController
@RequestMapping
public class AuthController {
    @Resource
    private AuthService authService;

    @Resource
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public ResponseEntity<BaseResult> login(@RequestBody User user) throws Exception {
        //登录  获得token
        User user1 = this.authService.login(user.getName(), user.getPassword());
        String token= JwtUtils.generateToken(new UserInfo( user1.getId() ,user1.getName() ) , jwtProperties.getPrivateKey() ,  jwtProperties.getExpire() );
          //有token  返回
        if(StringUtils.isNotBlank( token)){
            BaseResult baseResult = new BaseResult(0 , "登录成功").append("token", token).append("name",user1.getName());
            return ResponseEntity.ok( baseResult );
        }
        //3 没有token，失败
        return ResponseEntity.ok( new BaseResult(1 , "登录失败"));
    }

}
