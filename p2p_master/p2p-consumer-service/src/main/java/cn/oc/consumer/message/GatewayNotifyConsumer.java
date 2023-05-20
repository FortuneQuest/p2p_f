package cn.oc.consumer.message;

import cn.oc.api.depository.model.DepositoryConsumerResponse;
import cn.oc.api.depository.model.DepositoryRechargeResponse;
import cn.oc.api.depository.model.DepositoryWithdrawResponse;
import cn.oc.consumer.service.ConsumerService;
import com.alibaba.fastjson.JSON;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Component
public class GatewayNotifyConsumer {
    @Autowired
    private ConsumerService consumerService;

    public GatewayNotifyConsumer(@Value("${rocketmq.consumer.group}") String consumerGroup, @Value("${rocketmq.name-server}") String mqNameServer) throws MQClientException {
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer(consumerGroup);
        pushConsumer.setNamesrvAddr(mqNameServer);
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        pushConsumer.subscribe("TP_GATEWAY_NOTIFY_AGENT", "*");

        // 注册监听器
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                try {
                    Message message = msgs.get(0);
                    String topic = message.getTopic();
                    String tag = message.getTags();
                    String body = new String(message.getBody(), StandardCharsets.UTF_8);
                    if ("PERSONAL_REGISTER".equals(tag)) {
                        DepositoryConsumerResponse response = JSON.parseObject(body, DepositoryConsumerResponse.class);
                        consumerService.modifyResult(response);
                    }

                    if ("RECHARGE".equals(tag)) {
                        DepositoryRechargeResponse depositoryRechargeResponse = JSON.parseObject(body, DepositoryRechargeResponse.class);
                        consumerService.modifyRechargeRecordResult(depositoryRechargeResponse);
                    }

                    if ("WITHDRAW".equals(tag)) {
                        DepositoryWithdrawResponse depositoryWithdrawResponse = JSON.parseObject(body, DepositoryWithdrawResponse.class);
                        consumerService.modifyWithdrawRecordResult(depositoryWithdrawResponse);
                    }
                } catch (Exception e) {
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        pushConsumer.start();
    }
}
