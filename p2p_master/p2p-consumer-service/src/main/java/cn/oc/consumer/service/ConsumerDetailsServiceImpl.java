package cn.oc.consumer.service;

import cn.oc.api.consumer.model.ConsumerDTO;
import cn.oc.api.consumer.model.ConsumerDetailsDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.consumer.common.ConsumerErrorCode;
import cn.oc.consumer.entity.Consumer;
import cn.oc.consumer.entity.ConsumerDetails;
import cn.oc.consumer.mapper.ConsumerDetailsMapper;
import cn.oc.consumer.mapper.ConsumerMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Service
public class ConsumerDetailsServiceImpl implements ConsumerDetailsService {
    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private ConsumerMapper consumerMapper;
    @Autowired
    private ConsumerDetailsMapper consumerDetailsMapper;

    @Override
    public void createConsumerDetails(ConsumerDetailsDTO consumerDetailsDTO, String mobile) {
        ConsumerDTO consumerByMobile = consumerService.getConsumerByMobile(mobile);
        Integer count = consumerDetailsMapper.selectCount(new LambdaQueryWrapper<ConsumerDetails>().eq(ConsumerDetails::getConsumerId, consumerByMobile.getId()));
        if (!count.equals(0)) {
            throw new BusinessException(ConsumerErrorCode.E_140107);
        }

        ConsumerDetails consumerDetails = convertDto2entity(consumerDetailsDTO);
        consumerDetails.setConsumerId(consumerByMobile.getId());
        consumerDetails.setUploadDate(LocalDateTime.now());
        consumerDetailsMapper.insert(consumerDetails);

        Consumer consumer = new Consumer();
        consumer.setId(consumerByMobile.getId());
        consumer.setIsCardAuth(1);
        consumerMapper.updateById(consumer);
    }

    private ConsumerDetails convertDto2entity(ConsumerDetailsDTO consumerDetailsDTO) {
        if (consumerDetailsDTO == null) {
            return null;
        }

        ConsumerDetails consumerDetails = new ConsumerDetails();
        BeanUtils.copyProperties(consumerDetailsDTO, consumerDetails);
        return consumerDetails;
    }
}
