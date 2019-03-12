package com.czxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 音老怪 on 2019/2/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="goods")
public class Goods {
    @Id
    private Integer Gid;
    private String gname;
    private Integer price;
    private String pic;
    private Integer num;
    private Integer id;
    private String size;
    private Carts carts;
}