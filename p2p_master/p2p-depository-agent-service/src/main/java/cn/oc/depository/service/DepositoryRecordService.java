package cn.oc.depository.service;

import cn.oc.api.consumer.model.ConsumerRequest;
import cn.oc.api.consumer.model.RechargeRequest;
import cn.oc.api.consumer.model.WithdrawRequest;
import cn.oc.api.depository.model.*;
import cn.oc.api.repayment.model.RepaymentRequest;
import cn.oc.api.transaction.model.ModifyProjectStatusDTO;
import cn.oc.api.transaction.model.ProjectDTO;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public interface DepositoryRecordService {
    /**
     * 还款确认
     *
     * @param repaymentRequest
     * @return
     */
    DepositoryResponseDTO<DepositoryBaseResponse> confirmRepayment(RepaymentRequest repaymentRequest);

    /**
     * 修改标的状态
     *
     * @param modifyProjectStatusDTO
     * @return
     */
    DepositoryResponseDTO<DepositoryBaseResponse> modifyProjectStatus(ModifyProjectStatusDTO modifyProjectStatusDTO);

    /**
     * 审核满标放款
     *
     * @param loanRequest
     * @return
     */
    DepositoryResponseDTO<DepositoryBaseResponse> confirmLoan(LoanRequest loanRequest);

    /**
     * 投标预处理
     *
     * @param userAutoPreTransactionRequest
     * @return
     */
    DepositoryResponseDTO<DepositoryBaseResponse> userAutoPreTransaction(UserAutoPreTransactionRequest userAutoPreTransactionRequest);

    /**
     * 保存标的
     *
     * @param projectDTO 标的信息
     * @return
     */
    DepositoryResponseDTO<DepositoryBaseResponse> createProject(ProjectDTO projectDTO);

    /**
     * 生成用户提现数据
     *
     * @param withdrawRequest
     * @return
     */
    GatewayRequest withdrawRecords(WithdrawRequest withdrawRequest);

    /**
     * 生成用户充值数据
     *
     * @param rechargeRequest
     * @return
     */
    GatewayRequest rechargeRecords(RechargeRequest rechargeRequest);

    /**
     * 根据请求流水号更新请求状态
     *
     * @param requestNo
     * @param requestsStatus
     * @return
     */
    Boolean modifyRequestStatus(String requestNo, Integer requestsStatus);

    /**
     * 开通存管账户
     *
     * @param consumerRequest 开户信息
     * @return
     */
    GatewayRequest createConsumer(ConsumerRequest consumerRequest);
}
