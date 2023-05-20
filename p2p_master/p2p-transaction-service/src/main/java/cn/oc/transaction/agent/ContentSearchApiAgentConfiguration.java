package cn.oc.transaction.agent;

import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :ContentSearchApiAgentConfiguration
 * @Author: oc
 * @Date: 2023/05/20/4:39
 * @Description:
 **/
class ContentSearchApiAgentConfiguration {
    @Bean
    public ContentSearchApiAgentFallback contentSearchApiAgentFallback() {
        return new ContentSearchApiAgentFallback();
    }
}
