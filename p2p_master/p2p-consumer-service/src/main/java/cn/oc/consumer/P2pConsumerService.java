package cn.oc.consumer;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.oc.consumer.agent"})
@MapperScan("cn.oc.consumer.mapper")
public class P2pConsumerService {

    public static void main(String[] args) {
        SpringApplication.run(P2pConsumerService.class, args);
    }
}