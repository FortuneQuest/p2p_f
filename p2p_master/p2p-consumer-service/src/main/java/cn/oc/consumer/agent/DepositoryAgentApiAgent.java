package cn.oc.consumer.agent;

import cn.oc.api.consumer.model.ConsumerRequest;
import cn.oc.api.consumer.model.RechargeRequest;
import cn.oc.api.consumer.model.WithdrawRequest;
import cn.oc.api.depository.model.GatewayRequest;
import cn.oc.common.domain.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@FeignClient(
        value = "depository-agent-service",
        fallback = DepositoryAgentApiAgentFallback.class,
        configuration = {DepositoryAgentApiAgentConfiguration.class})
public interface DepositoryAgentApiAgent {
    /**
     * 生成提现请求数据
     *
     * @param withdrawRequest
     * @return
     */
    @PostMapping("/depository/l/withdraws")
    RestResponse<GatewayRequest> createWithdrawRecord(@RequestBody WithdrawRequest withdrawRequest);

    /**
     * 生成充值请求数据
     *
     * @param rechargeRequest
     * @return
     */
    @PostMapping("/depository/l/recharges")
    RestResponse<GatewayRequest> createRechargeRecord(@RequestBody RechargeRequest rechargeRequest);

    /**
     * 生成用户数据远程调用
     *
     * @param consumerRequest
     * @return
     */
    @PostMapping("/depository/l/consumers")
    RestResponse<GatewayRequest> createConsumer(@RequestBody ConsumerRequest consumerRequest);
}

