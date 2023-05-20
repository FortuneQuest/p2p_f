package cn.oc.consumer.agent;

import cn.oc.api.consumer.model.ConsumerRequest;
import cn.oc.api.consumer.model.RechargeRequest;
import cn.oc.api.consumer.model.WithdrawRequest;
import cn.oc.api.depository.model.GatewayRequest;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :DepositoryAgentApiAgentFallback
 * @Author: oc
 * @Date: 2023/05/20/3:45
 * @Description:
 **/
class DepositoryAgentApiAgentFallback implements DepositoryAgentApiAgent {

    @Override
    public RestResponse<GatewayRequest> createWithdrawRecord(WithdrawRequest withdrawRequest) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }

    @Override
    public RestResponse<GatewayRequest> createRechargeRecord(RechargeRequest rechargeRequest) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }

    @Override
    public RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }
}
