package com.czxy.service;

import com.czxy.dao.UserMapper;
import com.czxy.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * Created by 音老怪 on 2019/2/26.
 */
@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper userMapper;
    //添加对象
    public void saveUser(User user){
        userMapper.insert(user);
    }

    //根据用户的姓名查询
    public User findByName(String name){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",name);
        //2查询
        return  this.userMapper.selectOneByExample( example );

    }
    //修改密码
    public User findName(String name,Integer password){

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",name);
        //2查询
        User user = this.userMapper.selectOneByExample(example);
        if(user!=null) {
            user.setPassword(password);
            user.setPassword2(password);
            userMapper.updateByPrimaryKey(user);
            System.out.println(user.getPassword());
        }
        return user;
    }

}
