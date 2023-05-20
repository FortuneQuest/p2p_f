package cn.oc.repayment.agent;

import cn.oc.api.depository.model.UserAutoPreTransactionRequest;
import cn.oc.api.repayment.model.RepaymentRequest;
import cn.oc.common.domain.RestResponse;
import cn.oc.repayment.agent.DepositoryAgentApiAgentConfiguration;
import cn.oc.repayment.agent.DepositoryAgentApiAgentFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@FeignClient(
        value = "depository-agent-service",
        fallback = DepositoryAgentApiAgentFallback.class,
        configuration = {DepositoryAgentApiAgentConfiguration.class}
)
public interface DepositoryAgentApiAgent {

    /**
     * 确认还款
     *
     * @param repaymentRequest
     * @return
     */
    @PostMapping("/depository-agent/l/confirm-repayment")
    RestResponse<String> confirmRepayment(RepaymentRequest repaymentRequest);

    /**
     * 还款预处理
     *
     * @param userAutoPreTransactionRequest
     * @return
     */
    @PostMapping("/depository/l/user-auto-pre-transaction")
    RestResponse<String> userAutoPreTransaction(UserAutoPreTransactionRequest userAutoPreTransactionRequest);
}

