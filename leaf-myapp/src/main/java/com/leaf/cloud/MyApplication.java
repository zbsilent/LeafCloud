package com.leaf.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述
 *
 * @author zbsilent
 * @version 1.0
 * @createDate 2024/7/2 下午4:10
 **/
@SpringBootApplication
@MapperScan("com.leaf.cloud.mapper")
@EnableDiscoveryClient
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}