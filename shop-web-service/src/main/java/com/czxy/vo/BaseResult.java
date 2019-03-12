package com.czxy.vo;

import lombok.Data;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by 音老怪 on 2018/12/12.
 */
@Data
public class BaseResult {
    private Map<String,Object> data = new HashMap<String, Object>();
    public BaseResult(Integer errno,String errmsg){
        data.put("errno",errno);
        data.put("errmsg",errmsg);
    }

    public BaseResult append(String key,Object msg){
        data.put(key,msg);
        return  this;
    }

}
