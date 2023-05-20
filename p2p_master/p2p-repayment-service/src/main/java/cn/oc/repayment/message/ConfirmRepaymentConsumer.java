package cn.oc.repayment.message;

import cn.oc.api.repayment.model.RepaymentRequest;
import cn.oc.repayment.entity.RepaymentPlan;
import cn.oc.repayment.service.RepaymentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Component
@RocketMQMessageListener(topic = "TP_CONFIRM_REPAYMENT", consumerGroup = "CID_CONFIRM_REPAYMENT")
public class ConfirmRepaymentConsumer implements RocketMQListener<String> {
    @Autowired
    private RepaymentService repaymentService;

    @Override
    public void onMessage(String msg) {
        // 解析消息
        JSONObject jsonObject = JSON.parseObject(msg);
        RepaymentPlan repaymentPlan = JSONObject.parseObject(jsonObject.getString("repaymentPlan"), RepaymentPlan.class);
        RepaymentRequest repaymentRequest = JSONObject.parseObject(jsonObject.getString("repaymentRequest"), RepaymentRequest.class);

        // 执行业务
        repaymentService.invokeConfirmRepayment(repaymentPlan, repaymentRequest);
    }
}
