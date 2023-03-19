package cn.oc.agent;

import cn.oc.acount.model.AccountDTO;
import cn.oc.acount.model.AccountLoginDTO;
import cn.oc.domain.BusinessException;
import cn.oc.domain.CommonErrorCode;
import cn.oc.domain.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccountApiAgent
 * @Author: oc
 * @Date: 2023/03/19/19:57
 * @Description:
 **/
@FeignClient(value = "account-service",
        configuration = AccountApiAgent.AccountApiAgentConfig.class,
        fallback = AccountApiAgent.AccountApiAgentFallback.class)
public interface AccountApiAgent {

    @PostMapping(value = "/account/l/accounts/session")
    RestResponse<AccountDTO> login(@RequestBody AccountLoginDTO accountLoginDTO);

    class AccountApiAgentConfig {
        @Bean
        public AccountApiAgentFallback accountApiAgentFallback() {
            return new AccountApiAgentFallback();
        }
    }

    class AccountApiAgentFallback implements AccountApiAgent {
        @Override
        public RestResponse<AccountDTO> login(AccountLoginDTO accountLoginDTO) {
            throw new BusinessException(CommonErrorCode.E_999995);
        }
    }
}
