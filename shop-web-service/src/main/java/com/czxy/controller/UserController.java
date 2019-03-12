package com.czxy.controller;

import com.czxy.pojo.User;
import com.czxy.service.UserService;
import com.czxy.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 音老怪 on 2019/2/26.
 */
@RestController
@RequestMapping
public class UserController {
    @Resource
    private UserService userService;
//注册
    @PostMapping("/regist")
    public ResponseEntity<BaseResult> regist(@RequestBody User user) {
        System.out.println("注册方法启动");
        try {
            //调用service方法 将传递过来的user添加到数据库
            userService.saveUser(user);
            //给出添加成功的提示
            return ResponseEntity.ok(new BaseResult(0, "注册成功"));
        } catch (Exception e) {
            e.printStackTrace();
            //给出添加失败的提示
            return ResponseEntity.ok(new BaseResult(1, "注册失败"));
        }


    }
     //通过姓名密码   进行查询
    @GetMapping("/login")
    public ResponseEntity<BaseResult> queryUser(@RequestParam("name") String name , @RequestParam("password") String password){
        System.out.println("登录方法启动了");
        System.out.println(name);
        User user = this.userService.findByName( name );
        System.out.println(user);
        //2.判断密码是否正确
        if(user == null || !user.getPassword().equals(password)){
            //密码不对
            return ResponseEntity.ok(new BaseResult(0,"登录失败"));
        }
        //3.正确
            return ResponseEntity.ok(new BaseResult(1,"登录成功"));
    }

    //修改密码
    @GetMapping("/update")
    public ResponseEntity<BaseResult> update(@RequestParam("name") String name ,@RequestParam("password") Integer password){
        System.out.println("修改密码方法执行了");
        User user = this.userService.findName(name,password);
        System.out.println(user);
        if(user!=null){


            return ResponseEntity.ok(new BaseResult(0,"修改成功"));
        }
        return ResponseEntity.ok(new BaseResult(0,"修改失败"));
    }

     //购物车


}