package cn.oc.transaction.agent;

import cn.oc.api.consumer.model.BalanceDetailsDTO;
import cn.oc.api.consumer.model.ConsumerDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :ConsumerApiAgentFallback
 * @Author: oc
 * @Date: 2023/05/20/4:38
 * @Description:
 **/
class ConsumerApiAgentFallback implements ConsumerApiAgent {
    @Override
    public RestResponse<BalanceDetailsDTO> getBalance(String userNo) {
        throw new BusinessException(CommonErrorCode.E_999995);
    }

    @Override
    public RestResponse<ConsumerDTO> getCurrentLoginConsumer() {
        throw new BusinessException(CommonErrorCode.E_999995);
    }
}
