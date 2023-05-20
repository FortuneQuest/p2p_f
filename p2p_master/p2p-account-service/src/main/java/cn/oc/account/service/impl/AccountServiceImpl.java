package cn.oc.account.service.impl;

import cn.oc.account.common.AccountErrorCode;
import cn.oc.account.entity.Account;
import cn.oc.account.mapper.AccountMapper;
import cn.oc.account.service.AccountService;
import cn.oc.account.service.SmsService;
import cn.oc.api.account.model.AccountDTO;
import cn.oc.api.account.model.AccountLoginDTO;
import cn.oc.api.account.model.AccountRegisterDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.RestResponse;
import cn.oc.common.util.PasswordUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccountServiceImpl
 * @Author: oc
 * @Date: 2023/04/08/16:17
 * @Description:
 **/
@Service
public class AccountServiceImpl  extends ServiceImpl<AccountMapper, Account> implements  AccountService {

    @Autowired
    private SmsService smsService;

    @Value("${sms.enable}")
    private boolean smsEnable;

    /**
     * 短信验证码
     * @param mobile 手机号
     * @return
     */
    @Override
    public RestResponse getSmsCode(String mobile) {
        return smsService.getSmsCode(mobile);
    }

    /**
     * 检查验证码
     * @param mobile
     * @param key
     * @param code
     * @return
     */
    @Override
    public Integer checkMobile(String mobile, String key, String code) {
        smsService.verifySmsCode(key, code);
        return count(new LambdaQueryWrapper<Account>().eq(Account::getMobile, mobile));

    }

    /**
     * 注册
     * @param accountRegisterDTO
     * @return
     */
    @Override
    public AccountDTO register(AccountRegisterDTO accountRegisterDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountRegisterDTO,account);
        account.setPassword(PasswordUtil.generate(accountRegisterDTO.getPassword()));
        if (smsEnable) {
            account.setPassword(account.getMobile());
        }
        account.setDomain("c");
        save(account);
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account,accountDTO);
        return accountDTO;
    }

    @Override
    public AccountDTO login(AccountLoginDTO accountLoginDTO) {

        //如果是c端用户，用户名就是手机号，如果是b端用户，用户名就是用户名
        Account account;
        if (accountLoginDTO.getDomain().equalsIgnoreCase("c")) {
             account = getAccountByMobile(accountLoginDTO.getMobile());
        } else {
             account = getAccountByUserName(accountLoginDTO.getUsername());
        }
        if (account == null) {
                throw new BusinessException(AccountErrorCode.E_130104);
        }
        System.out.println(account.getUsername());
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(account,accountDTO);
        if(smsEnable){ //如果为true,表示采用短信验证码登录，无需比较密码
            return accountDTO;
        }
        System.out.println(PasswordUtil.verify(accountLoginDTO.getPassword(), account.getPassword()));
        if (PasswordUtil.verify(accountLoginDTO.getPassword(), account.getPassword())) {
            return  accountDTO;
        }
        throw  new BusinessException(AccountErrorCode.E_130105);
    }



    private  Account getAccountByMobile(String mobile) {
       return   getOne(new LambdaQueryWrapper<Account>().eq(Account::getMobile,mobile));
    }

    private  Account getAccountByUserName(String username) {
        return getOne(new LambdaQueryWrapper<Account>().eq(Account::getUsername,username));
    }
}
