package com.czxy.client;

import com.czxy.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 音老怪 on 2018/12/13.
 */
@FeignClient(value = "web-service")
public interface UserClient {

    @GetMapping("/query")
    public ResponseEntity<User> queryUser(@RequestParam("mobile") String mobile, @RequestParam("password") Integer password);
}
