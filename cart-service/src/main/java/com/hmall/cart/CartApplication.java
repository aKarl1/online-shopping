package com.hmall.cart;

import com.hmall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.hmall.cart.mapper")
@SpringBootApplication//是spring boot的核心注解，包括三个注解
@EnableFeignClients(basePackages = "com.hmall.api.client",defaultConfiguration= DefaultFeignConfig.class)
//open依赖注入进来了，但是需要加这个注解才可以生效，在远程调用时，client扫描不到，所以在启动openfeign的注解上加入要openfeign的扫描
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);

    }

}