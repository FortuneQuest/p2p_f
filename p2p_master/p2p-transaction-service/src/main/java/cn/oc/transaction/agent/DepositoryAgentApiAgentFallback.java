package cn.oc.transaction.agent;

import cn.oc.api.depository.model.LoanRequest;
import cn.oc.api.depository.model.UserAutoPreTransactionRequest;
import cn.oc.api.transaction.model.ModifyProjectStatusDTO;
import cn.oc.api.transaction.model.ProjectDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :DepositoryAgentApiAgentFallback
 * @Author: oc
 * @Date: 2023/05/20/4:40
 * @Description:
 **/
class DepositoryAgentApiAgentFallback implements DepositoryAgentApiAgent {

    @Override
    public RestResponse<String> confirmLoan(LoanRequest loanRequest) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }

    @Override
    public RestResponse<String> modifyProjectStatus(ModifyProjectStatusDTO modifyProjectStatusDTO) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }

    @Override
    public RestResponse<String> userAutoPreTransaction(UserAutoPreTransactionRequest userAutoPreTransactionRequest) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }

    @Override
    public RestResponse<String> createProject(ProjectDTO projectDTO) {
        throw new BusinessException(CommonErrorCode.E_999996);
    }
}
