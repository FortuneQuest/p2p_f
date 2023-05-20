package cn.oc.repayment.agent;

import cn.oc.api.depository.model.UserAutoPreTransactionRequest;
import cn.oc.api.repayment.model.RepaymentRequest;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :DepositoryAgentApiAgentFallback
 * @Author: oc
 * @Date: 2023/05/20/4:20
 * @Description:
 **/
class DepositoryAgentApiAgentFallback implements DepositoryAgentApiAgent {

    @Override
    public RestResponse<String> confirmRepayment(RepaymentRequest repaymentRequest) {
        throw new BusinessException(CommonErrorCode.E_999997);
    }

    @Override
    public RestResponse<String> userAutoPreTransaction(UserAutoPreTransactionRequest userAutoPreTransactionRequest) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }
}
