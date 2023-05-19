package cn.oc.consumer.service;


import cn.oc.api.consumer.model.BorrowerDTO;
import cn.oc.api.consumer.model.ConsumerDTO;
import cn.oc.api.consumer.model.ConsumerRegisterDTO;
import cn.oc.api.consumer.model.ConsumerRequest;
import cn.oc.api.depository.model.DepositoryConsumerResponse;
import cn.oc.api.depository.model.GatewayRequest;
import cn.oc.common.domain.RestResponse;
import cn.oc.consumer.entity.Consumer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ConsumerService
 * @Author: oc
 * @Date: 2023/04/11/15:12
 * @Description:
 **/
public interface ConsumerService extends IService<Consumer> {
    /**
     * 检测用户是否存在
     * @param mobile
     * @return
     */
    Integer checkMobile(String mobile);
    /**
     * 用户注册
     * @param consumerRegisterDTO
     * @return
     */
    void register(ConsumerRegisterDTO consumerRegisterDTO);

    /**
     生成开户数据
     @param consumerRequest
     @return
     */
    RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest);

    /**
     * 更新开户结果
     * @param response
     * @return
     */
    Boolean modifyResult(DepositoryConsumerResponse response);

    /**
     * 通过手机号获取当前用户信息
     * @param mobile
     * @return
     */
    ConsumerDTO getByMobile(String mobile);

    /**
     * 获取借款人基本信息
     * @param id
     * @return
     */
    BorrowerDTO getBorrower(Long id);
}
