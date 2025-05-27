package com.hmall.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
@FeignClient("cart-service")//可以去nacos拉去负载列表
//下面就是通过HTTP请求获取数据

public interface CartClient {
    @DeleteMapping("/carts")
     void deleteCartItemByIds(@RequestParam("ids") Collection<Long> ids);

}
