package cn.oc.uaa.agent;

import cn.oc.api.account.model.AccountDTO;
import cn.oc.api.account.model.AccountLoginDTO;
import cn.oc.common.domain.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@FeignClient(value = "account-service",
        configuration = AccountApiAgentConfig.class,
        fallback = AccountApiAgentFallback.class)
public interface AccountApiAgent {
    @PostMapping(value = "/account/l/accounts/session")
    RestResponse<AccountDTO> login(@RequestBody AccountLoginDTO accountLoginDTO);
}

