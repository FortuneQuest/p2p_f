package cn.oc.uaa.agent;

import cn.oc.api.acount.model.AccountDTO;
import cn.oc.api.acount.model.AccountLoginDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :AccountApiAgentFallback
 * @Author: oc
 * @Date: 2023/05/19/2:46
 * @Description:
 **/
class AccountApiAgentFallback implements AccountApiAgent {
    @Override
    public RestResponse<AccountDTO> login(AccountLoginDTO accountLoginDTO) {
        throw new BusinessException(CommonErrorCode.E_999995);
    }
}
