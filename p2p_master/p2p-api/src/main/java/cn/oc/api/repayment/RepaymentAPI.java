package cn.oc.api.repayment;

import cn.oc.api.transaction.model.ProjectWithTendersDTO;
import cn.oc.common.domain.RestResponse;



/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public interface RepaymentAPI {
    /**
     * 启动还款
     *
     * @param projectWithTendersDTO
     * @return
     */
    RestResponse<String> startRepayment(ProjectWithTendersDTO projectWithTendersDTO);
}
