package cn.oc.api.acount;

import cn.oc.api.acount.model.AccountDTO;
import cn.oc.api.acount.model.AccountLoginDTO;
import cn.oc.api.acount.model.AccountRegisterDTO;
import cn.oc.common.domain.RestResponse;


/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccountApi
 * @Author: oc
 * @Date: 2023/03/18/12:46
 * @Description:
 **/
public interface AccountApi {
    /**
     * 用户登录
     *
     * @param accountLoginDTO 封装登录请求数据
     * @return
     */
    RestResponse<AccountDTO> login(AccountLoginDTO accountLoginDTO);

    /**
     * 用户注册
     *
     * @param accountRegisterDTO 注册信息实体类
     * @return
     */
    RestResponse<AccountDTO> registry(AccountRegisterDTO accountRegisterDTO);

    /**
     * 校验手机号和验证码
     *
     * @param mobile 手机号
     * @param key    校验标识
     * @param code   验证码
     * @return
     */
    RestResponse<Integer> checkMobile(String mobile, String key, String code);

    /**
     * 获取短信验证码
     *
     * @param mobile 手机号
     * @return
     */
    RestResponse getSMSCode(String mobile);
}
