package cn.oc.uaa.agent;

import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :AccountApiAgentConfig
 * @Author: oc
 * @Date: 2023/05/19/2:46
 * @Description:
 **/
class AccountApiAgentConfig {
    @Bean
    public AccountApiAgentFallback accountApiAgentFallback() {
        return new AccountApiAgentFallback();
    }
}
