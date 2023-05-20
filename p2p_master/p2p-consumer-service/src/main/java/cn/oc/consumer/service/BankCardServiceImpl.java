package cn.oc.consumer.service;

import cn.oc.api.consumer.model.BankCardDTO;
import cn.oc.consumer.entity.BankCard;
import cn.oc.consumer.mapper.BankCardMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private BankCardMapper bankCardMapper;
    @Autowired
    private ConsumerService consumerService;

    @Override
    public BankCardDTO getByUserMobile(String mobile) {
        BankCard bankCard = bankCardMapper.selectOne(new LambdaQueryWrapper<BankCard>().eq(BankCard::getMobile, mobile));
        if (bankCard == null) {
            return null;
        }

        String name = consumerService.getConsumerByMobile(mobile).getFullname();
        BankCardDTO bankCardDTO = convertBankCardEntityToDTO(bankCard);
        bankCardDTO.setFullName(name);
        return bankCardDTO;
    }

    @Override
    public BankCardDTO getByConsumerId(Long consumerId) {
        LambdaQueryWrapper<BankCard> eq = new LambdaQueryWrapper<BankCard>().eq(BankCard::getConsumerId, consumerId);
        return convertBankCardEntityToDTO(bankCardMapper.selectOne(eq));
    }

    @Override
    public BankCardDTO getByCardNumber(String cardNumber) {
        LambdaQueryWrapper<BankCard> eq = new LambdaQueryWrapper<BankCard>().eq(BankCard::getCardNumber, cardNumber);
        return convertBankCardEntityToDTO(bankCardMapper.selectOne(eq));
    }

    /**
     * entity 2 dto
     *
     * @param entity
     * @return
     */
    private BankCardDTO convertBankCardEntityToDTO(BankCard entity) {
        if (entity == null) {
            return null;
        }

        BankCardDTO dto = new BankCardDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
