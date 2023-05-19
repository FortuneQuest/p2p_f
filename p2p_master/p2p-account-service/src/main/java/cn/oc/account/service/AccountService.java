package cn.oc.account.service;

import cn.oc.account.entity.Account;
import cn.oc.api.acount.model.AccountDTO;
import cn.oc.api.acount.model.AccountLoginDTO;
import cn.oc.api.acount.model.AccountRegisterDTO;
import cn.oc.common.domain.RestResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccountService
 * @Author: oc
 * @Date: 2023/04/08/15:58
 * @Description:
 **/
public interface AccountService extends IService<Account> {

    /**
     * 获取手机验证码
     * @param mobile 手机号
     * @return
     */
    RestResponse getSmsCode(String mobile);


    /**
     * 校验手机验证码
     * @param mobile
     * @param key
     * @param code
     * @return
     */
    Integer checkMobile(String mobile, String key, String code);

    /**
     * 注册
     * @param accountRegisterDTO
     * @return
     */
    AccountDTO register(AccountRegisterDTO accountRegisterDTO);

    /**
     * 登录
     * @param accountLoginDTO
     * @return
     */
    AccountDTO login(AccountLoginDTO accountLoginDTO);
}
