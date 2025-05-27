package com.hmalluser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.hmalluser.mapper")
@SpringBootApplication//这个是核心注解，里面包含三部分内容
//1.configuration表示这个配置类，比如之前基于注解，还是xml都是要自己写配置类，基于注解的也要写扫描路径和配置
//2.configurationscan表示扫描当前包和包下带有bean注解的类
//3.enableautoconfigation,自动配置功能，怎么理解呢，就是starter已经加载了相关的配置，这个注解就是给他自动装配起来，
//比如springmv里的非常强的组件，starter都已经引入了，这个注解就是相当于把他们都自动装配了
@EnableFeignClients
public class UserApplication {
    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);
        //1.自动加入到ioc容器
        //2.启动tomcat服务器
    }
}