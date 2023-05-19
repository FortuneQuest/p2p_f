package cn.oc.consumer.service.impl;


import cn.oc.api.acount.model.AccountDTO;
import cn.oc.api.acount.model.AccountRegisterDTO;
import cn.oc.api.consumer.model.BorrowerDTO;
import cn.oc.api.consumer.model.ConsumerDTO;
import cn.oc.api.consumer.model.ConsumerRegisterDTO;
import cn.oc.api.consumer.model.ConsumerRequest;
import cn.oc.api.depository.model.DepositoryConsumerResponse;
import cn.oc.api.depository.model.GatewayRequest;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CodePrefixCode;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;
import cn.oc.common.util.CodeNoUtil;
import cn.oc.consumer.agent.AccountApiAgent;
import cn.oc.consumer.common.ConsumerErrorCode;
import cn.oc.consumer.entity.Consumer;
import cn.oc.consumer.mapper.ConsumerMapper;
import cn.oc.consumer.service.ConsumerService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ConsumerImpl
 * @Author: oc
 * @Date: 2023/04/11/15:35
 * @Description:
 **/
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {


    @Autowired
    AccountApiAgent accountApiAgent;
    /**
     * 检查手机号是否被注册，用户是否存在
     * @param mobile
     * @return
     */
    @Override
    public Integer checkMobile(String mobile) {
        return getByMobile(mobile)==null?0:1;
    }

    /**
     * 用户注册
     * @param consumerRegisterDTO
     */
    @Override
    public void register(ConsumerRegisterDTO consumerRegisterDTO) {
        if (checkMobile(consumerRegisterDTO.getMobile()) == 1) {
             throw new BusinessException(ConsumerErrorCode.E_140107);
        }
        Consumer consumer = new Consumer();
        BeanUtils.copyProperties(consumerRegisterDTO,consumer);
        consumer.setUsername(CodeNoUtil.getNo(CodePrefixCode.CODE_NO_PREFIX));
        consumerRegisterDTO.setUsername(consumer.getUsername());
        consumer.setUserNo(CodeNoUtil.getNo(CodePrefixCode.CODE_CONSUMER_PREFIX));
        consumer.setIsBindCard(0);
        save(consumer);

        //远程调用服务
        AccountRegisterDTO accountRegisterDTO = new AccountRegisterDTO();
        BeanUtils.copyProperties(consumerRegisterDTO,accountRegisterDTO);
        RestResponse<AccountDTO> dtoRestResponse = accountApiAgent.registry(accountRegisterDTO);
        if (dtoRestResponse.getCode() != CommonErrorCode.SUCCESS.getCode()) {
            throw  new BusinessException(ConsumerErrorCode.E_140106);
        }
    }

    @Override
    public RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest) {
        return null;
    }

    @Override
    public Boolean modifyResult(DepositoryConsumerResponse response) {
        return null;
    }

    @Override
    public ConsumerDTO getByMobile(String mobile) {
        Consumer consumer = getOne(new LambdaQueryWrapper<Consumer>().eq(Consumer::getMobile, mobile));
        if (consumer != null) {
            ConsumerDTO consumerDTO = new ConsumerDTO();
            BeanUtils.copyProperties(consumer,consumerDTO);
            return  consumerDTO;
        }
        return  null;
    }

    @Override
    public BorrowerDTO getBorrower(Long id) {
        return null;
    }


}
