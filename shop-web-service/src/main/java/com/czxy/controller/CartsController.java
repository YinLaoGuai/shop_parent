package com.czxy.controller;

import com.czxy.dao.CartsMapper;
import com.czxy.dao.GoodsMapper;
import com.czxy.pojo.Carts;
import com.czxy.pojo.Goods;
import com.czxy.service.CartsService;
import com.czxy.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 音老怪 on 2019/3/2.
 */
@RestController
@RequestMapping
public class CartsController {
    @Resource
    private CartsService cartsService;
    @Resource
    private CartsMapper cartsMapper;
    @Resource
    private GoodsMapper goodsMapper;

    @GetMapping("/carts")
    public ResponseEntity<BaseResult> findAll(){
        List<Carts> carts = this.cartsService.findAll();
        System.out.println(carts.toString());
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",carts));
    }

    //删除
    @GetMapping("/del/{cid}")
    public  ResponseEntity<BaseResult> delete(@PathVariable("cid") Integer cid){
        Example example = new Example(Carts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid",cid);
        Carts carts = this.cartsMapper.selectOneByExample(example);
        if(carts!=null){
            cartsService.delete(cid);
            return ResponseEntity.ok(new BaseResult(0,"删除成功"));
        }
            return ResponseEntity.ok(new BaseResult(0,"删除失败"));
    }
    //页面数量修改 更新操作
    @GetMapping("/updateNum/{cid}")
    public ResponseEntity<BaseResult> updateNum(@PathVariable("cid") Integer cid,@RequestParam("quantity")Integer quantity ){
        Carts carts1 = cartsService.findById(cid,quantity);
        System.out.println(carts1);
        if(carts1!=null){
            return ResponseEntity.ok(new BaseResult(    1,"修改成功"));
    }
            return ResponseEntity.ok(new BaseResult(0,"修改失败"));
    }
    //添加购物车     新
    @PostMapping("/add/{gid}")
    public  ResponseEntity<BaseResult> add(@PathVariable("gid") Integer gid){
        Goods goods= cartsService.add(gid);
        System.out.println(goods);
        List<Goods> goodsList = goodsMapper.selectAll();
        goodsList.add(goods);
        System.out.println("添加方法执行了");
        System.out.println(goodsList);
        return ResponseEntity.ok(new BaseResult(0,"成功").append("data",goodsList));
        }
        }