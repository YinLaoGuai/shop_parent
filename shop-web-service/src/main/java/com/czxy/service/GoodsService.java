package com.czxy.service;

import com.czxy.dao.GoodsMapper;
import com.czxy.pojo.Goods;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 音老怪 on 2019/2/28.
 */
@Service
@Transactional
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    public List<Goods> findAll(){
        List<Goods> goods = goodsMapper.selectAll();
        System.out.println(goods);
        return  goods;
    }

    //根据id查找商品
    public Goods findById(Integer id){
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return  goods;
    }

}
