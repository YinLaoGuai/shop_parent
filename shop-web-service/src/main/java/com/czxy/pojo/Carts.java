package com.czxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 音老怪 on 2019/3/2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="cart")
public class Carts {
    @Id
    private Integer cid;
    private Integer gid;
    private String Product;
    private Integer price;
    private Integer quantity;
    private Integer Total;
    private Goods goods;
}
