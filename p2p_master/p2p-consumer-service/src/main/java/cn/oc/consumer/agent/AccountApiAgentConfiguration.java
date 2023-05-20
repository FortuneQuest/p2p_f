package cn.oc.consumer.agent;

import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :AccountApiAgentConfiguration
 * @Author: oc
 * @Date: 2023/05/20/3:44
 * @Description:
 **/
class AccountApiAgentConfiguration {
    @Bean
    public AccountApiAgentFallback accountApiAgentFallback() {
        return new AccountApiAgentFallback();
    }
}
