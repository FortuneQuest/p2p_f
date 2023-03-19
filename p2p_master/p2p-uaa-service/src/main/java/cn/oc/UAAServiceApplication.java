package cn.oc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"cn.oc.agent"})
public class UAAServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UAAServiceApplication.class, args);
    }
}