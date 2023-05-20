package cn.oc.transaction.agent;

import cn.oc.api.depository.model.LoanRequest;
import cn.oc.api.depository.model.UserAutoPreTransactionRequest;
import cn.oc.api.transaction.model.ModifyProjectStatusDTO;
import cn.oc.api.transaction.model.ProjectDTO;
import cn.oc.common.domain.RestResponse;
import cn.oc.transaction.agent.DepositoryAgentApiAgentConfiguration;
import cn.oc.transaction.agent.DepositoryAgentApiAgentFallback;

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
        configuration = {DepositoryAgentApiAgentConfiguration.class}
)
public interface DepositoryAgentApiAgent {
    /**
     * 放款
     *
     * @param loanRequest
     * @return
     */
    @PostMapping("/depository/l/confirm-loan")
    RestResponse<String> confirmLoan(LoanRequest loanRequest);

    /**
     * 修改标的状态
     *
     * @param modifyProjectStatusDTO
     * @return
     */
    @PostMapping("/depository/l/modify-project-status")
    RestResponse<String> modifyProjectStatus(ModifyProjectStatusDTO modifyProjectStatusDTO);

    /**
     * 预处理冻结远程调用
     *
     * @param userAutoPreTransactionRequest 预处理信息
     * @return
     */
    @PostMapping("/depository/l/user-auto-pre-transaction")
    RestResponse<String> userAutoPreTransaction(UserAutoPreTransactionRequest userAutoPreTransactionRequest);

    /**
     * 存管代理新增项目
     *
     * @param projectDTO 项目信息
     * @return 提示信息
     */
    @PostMapping("/depository/l/create-project")
    RestResponse<String> createProject(@RequestBody ProjectDTO projectDTO);
}

