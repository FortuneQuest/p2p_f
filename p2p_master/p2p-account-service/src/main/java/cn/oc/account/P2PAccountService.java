package cn.oc.account;


import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.oc.account.agent"})
@MapperScan("cn.oc.account.mapper")
public class P2PAccountService {

    public static void main(String[] args) {
        SpringApplication.run(P2PAccountService.class, args);
    }
}