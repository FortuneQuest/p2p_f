package cn.oc.repayment;

import cn.oc.domain.RestResponse;
import cn.oc.transaction.model.ProjectWithTendersDTO;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : RepaymentAPI
 * @Author: oc
 * @Date: 2023/03/19/0:08
 * @Description:  还款
 **/
public interface RepaymentAPI {

    /**
     * 启动还款
     *
     * @param projectWithTendersDTO
     * @return
     */
    RestResponse<String> startRepayment(ProjectWithTendersDTO projectWithTendersDTO);
}
