package cn.oc.consumer.agent;

import cn.oc.api.acount.model.AccountDTO;
import cn.oc.api.acount.model.AccountRegisterDTO;
import cn.oc.common.domain.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : accountApiAgent
 * @Author: oc
 * @Date: 2023/04/11/17:24
 * @Description:
 **/
@FeignClient(name = "account-service",url = "http://localhost:53030")       //需要调用的微服务
public interface AccountApiAgent {

    @PostMapping("/account/l/accounts")
    RestResponse<AccountDTO> registry(@RequestBody  AccountRegisterDTO accountRegisterDTO);
}
