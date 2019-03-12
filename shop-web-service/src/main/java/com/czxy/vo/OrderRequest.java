package com.czxy.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * Created by 音老怪 on 2019/1/2.
 */
@Data
public class OrderRequest {
    //收货人地址ID
    @JsonProperty("address_id")
    private Integer addressId;

    //送货方式
    @JsonProperty("post_method")
    private Integer postMethod;

    //支付方式
    @JsonProperty("pay_method")
    private Integer payMethod;

    //发票
    private Map<Object,Object> invoice;

}
