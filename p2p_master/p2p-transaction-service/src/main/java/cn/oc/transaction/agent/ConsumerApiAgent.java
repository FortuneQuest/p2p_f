package cn.oc.transaction.agent;

import cn.oc.api.consumer.model.BalanceDetailsDTO;
import cn.oc.api.consumer.model.ConsumerDTO;
import cn.oc.common.domain.RestResponse;
import cn.oc.transaction.agent.ConsumerApiAgentConfiguration;
import cn.oc.transaction.agent.ConsumerApiAgentFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@FeignClient(
        value = "consumer-service",
        fallback = ConsumerApiAgentFallback.class,
        configuration = {ConsumerApiAgentConfiguration.class}
)
public interface ConsumerApiAgent {
    /**
     * 获取用户余额信息
     *
     * @param userNo 用户流水号
     * @return
     */
    @GetMapping("/consumer/l/balances/{userNo}")
    RestResponse<BalanceDetailsDTO> getBalance(@PathVariable("userNo") String userNo);

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    @GetMapping("/consumer/my/consumers")
    RestResponse<ConsumerDTO> getCurrentLoginConsumer();
}

