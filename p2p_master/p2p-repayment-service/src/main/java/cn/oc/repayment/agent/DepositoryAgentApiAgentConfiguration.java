package cn.oc.repayment.agent;

import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :DepositoryAgentApiAgentConfiguration
 * @Author: oc
 * @Date: 2023/05/20/4:20
 * @Description:
 **/
class DepositoryAgentApiAgentConfiguration {
    @Bean
    public DepositoryAgentApiAgentFallback depositoryAgentApiAgentFallback() {
        return new DepositoryAgentApiAgentFallback();
    }
}
