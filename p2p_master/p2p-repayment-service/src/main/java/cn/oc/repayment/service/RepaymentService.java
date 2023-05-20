package cn.oc.repayment.service;



import cn.oc.api.repayment.model.RepaymentPlanDTO;
import cn.oc.api.repayment.model.RepaymentRequest;
import cn.oc.api.transaction.model.ProjectWithTendersDTO;
import cn.oc.repayment.entity.RepaymentDetail;
import cn.oc.repayment.entity.RepaymentPlan;

import java.util.List;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public interface RepaymentService {
    /**
     * 远程调用确认还款接口
     *
     * @param repaymentPlan
     * @param repaymentRequest
     */
    void invokeConfirmRepayment(RepaymentPlan repaymentPlan, RepaymentRequest repaymentRequest);

    /**
     * 执行还款
     *
     * @param date
     */
    void executeRepayment(String date);

    /**
     * 确认还款处理
     *
     * @param repaymentPlan
     * @param repaymentRequest
     * @return
     */
    Boolean confirmRepayment(RepaymentPlan repaymentPlan, RepaymentRequest repaymentRequest);

    /**
     * 还款预处理-冻结借款人应还金额
     *
     * @param repaymentPlan
     * @param preRequestNo
     * @return
     */
    Boolean preRepayment(RepaymentPlan repaymentPlan, String preRequestNo);

    /**
     * 根据还款计划生成还款明细并保存
     *
     * @param repaymentPlan
     * @return
     */
    RepaymentDetail saveRepaymentDetail(RepaymentPlan repaymentPlan);

    /**
     * 查询到期还款计划
     *
     * @param date yyyy-MM-dd
     * @return
     */
    List<RepaymentPlanDTO> selectDueRepayment(String date);

    /**
     * 启动还款
     *
     * @param projectWithTendersDTO
     * @return
     */
    String startRepayment(ProjectWithTendersDTO projectWithTendersDTO);

    void sendRepaymentNotify(String format);
}
