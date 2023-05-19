package cn.oc.api.depository;

import cn.oc.api.consumer.model.ConsumerRequest;
import cn.oc.api.consumer.model.RechargeRequest;
import cn.oc.api.consumer.model.WithdrawRequest;
import cn.oc.api.depository.model.GatewayRequest;
import cn.oc.api.depository.model.LoanRequest;
import cn.oc.api.depository.model.UserAutoPreTransactionRequest;
import cn.oc.common.domain.RestResponse;
import cn.oc.api.repayment.model.RepaymentRequest;
import cn.oc.api.transaction.model.ModifyProjectStatusDTO;
import cn.oc.api.transaction.model.ProjectDTO;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : DepositoryAgentApi
 * @Author: oc
 * @Date: 2023/03/18/19:09
 * @Description:  银行存管系统代理服务API
 **/
public interface DepositoryAgentApi {
    /**
     * 还款确认
     *
     * @param repaymentRequest 还款信息
     * @return
     */
    RestResponse<String> confirmRepayment(RepaymentRequest repaymentRequest);

    /**
     * 修改标的状态
     *
     * @param modifyProjectStatusDTO
     * @return
     */
    RestResponse<String> modifyProjectStatus(ModifyProjectStatusDTO modifyProjectStatusDTO);

    /**
     * 审核标的满标放款
     *
     * @param loanRequest
     * @return
     */
    RestResponse<String> confirmLoan(LoanRequest loanRequest);

    /**
     * 预授权处理
     *
     * @param userAutoPreTransactionRequest 预授权处理信息
     * @return
     */
    RestResponse<String> userAutoPreTransaction(UserAutoPreTransactionRequest userAutoPreTransactionRequest);

    /**
     * 保存标的信息
     *
     * @param projectDTO 标的信息
     * @return 返回提示信息
     */
    RestResponse<String> createProject(ProjectDTO projectDTO);

    /**
     * 生成用户提现数据
     *
     * @param withdrawRequest
     * @return
     */
    RestResponse<GatewayRequest> createWithdrawRecord(WithdrawRequest withdrawRequest);

    /**
     *
     ** 生成用户充值数据
     * @param rechargeRequest
     * @return
             */
    RestResponse<GatewayRequest> createRechargeRecord(RechargeRequest rechargeRequest);

    /**
     * 开通存管账户
     *
     * @param consumerRequest 开户信息
     * @return
     */
    RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest);
}
