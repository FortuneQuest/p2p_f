package cn.oc.consumer.agent;

import cn.oc.api.account.model.AccountDTO;
import cn.oc.api.account.model.AccountRegisterDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :AccountApiAgentFallback
 * @Author: oc
 * @Date: 2023/05/20/3:44
 * @Description:
 **/
class AccountApiAgentFallback implements AccountApiAgent {
    @Override
    public RestResponse<AccountDTO> register(AccountRegisterDTO accountRegisterDTO) {
        throw new BusinessException(CommonErrorCode.E_999995);
    }
}
