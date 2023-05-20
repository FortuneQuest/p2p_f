package cn.oc.consumer.agent;

import cn.oc.api.account.model.AccountDTO;
import cn.oc.api.account.model.AccountRegisterDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@FeignClient(
        value = "account-service",
        fallback = AccountApiAgentFallback.class,
        configuration = {AccountApiAgentConfiguration.class})
public interface AccountApiAgent {
    /**
     * 用户注册
     *
     * @param accountRegisterDTO 用户注册信息
     * @return
     */
    @Hmily
    @PostMapping(value = "/account/l/accounts")
    RestResponse<AccountDTO> register(@RequestBody AccountRegisterDTO accountRegisterDTO);
}

