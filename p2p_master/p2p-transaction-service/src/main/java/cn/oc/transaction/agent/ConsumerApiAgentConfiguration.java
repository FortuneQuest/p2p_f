package cn.oc.transaction.agent;

import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :ConsumerApiAgentConfiguration
 * @Author: oc
 * @Date: 2023/05/20/4:38
 * @Description:
 **/
class ConsumerApiAgentConfiguration {
    @Bean
    public ConsumerApiAgentFallback consumerApiAgentFallback() {
        return new ConsumerApiAgentFallback();
    }
}
