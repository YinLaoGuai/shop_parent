package com.czxy.service;

import com.czxy.dao.CartsMapper;
import com.czxy.dao.GoodsMapper;
import com.czxy.pojo.Carts;
import com.czxy.pojo.Goods;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 音老怪 on 2019/3/2.
 */
@Service
@Transactional
public class CartsService {
    @Resource
    private CartsMapper cartsMapper;
    @Resource
    private GoodsMapper goodsMapper;

    public List<Carts> findAll(){
    List<Carts> carts = cartsMapper.selectAll();
        return  carts;
    }

    public void delete(Integer cid){
        Example example = new Example(Carts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid",cid);
        //2查询
       Carts carts = this.cartsMapper.selectOneByExample(example);

       if(carts!=null){
           cartsMapper.deleteByPrimaryKey(carts);

       }
    }

    //数量修改    更新操作
    public Carts findById(Integer cid,Integer quantity ){
        Example example = new Example(Carts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid",cid);
        Carts carts = cartsMapper.selectOneByExample(example);
        carts.setQuantity(quantity);
        cartsMapper.updateByPrimaryKey(carts);

        return  carts;
    }

    //添加购物车
    public Goods add(Integer gid){
        Example example = new Example(Carts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("gid",gid);
        Goods good= goodsMapper.selectOneByExample(example);

        return  good;
    }
}
