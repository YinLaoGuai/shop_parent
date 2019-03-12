package com.czxy.controller;

import com.czxy.pojo.Goods;
import com.czxy.service.GoodsService;
import com.czxy.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 音老怪 on 2019/2/28.
 */
@RestController
@RequestMapping
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/goods")
      public ResponseEntity<BaseResult> findAll(){
          List<Goods> goods = this.goodsService.findAll();
          System.out.println(goods);
          return ResponseEntity.ok(new BaseResult(0,"成功").append("data",goods));
      }

      //根据id查找对应的商品
      @GetMapping("/details/{gid}")
    public ResponseEntity<BaseResult> findById(@PathVariable("gid")Integer gid){
          Goods byId = goodsService.findById(gid);
          return ResponseEntity.ok(new BaseResult(0,"成功").append("data",byId));


      }
}
