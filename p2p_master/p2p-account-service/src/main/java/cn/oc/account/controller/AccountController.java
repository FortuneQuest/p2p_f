package cn.oc.account.controller;

import cn.oc.account.service.impl.AccountServiceImpl;

import cn.oc.api.account.AccountAPI;
import cn.oc.api.account.model.AccountDTO;
import cn.oc.api.account.model.AccountLoginDTO;
import cn.oc.api.account.model.AccountRegisterDTO;
import cn.oc.common.domain.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccountController
 * @Author: oc
 * @Date: 2023/04/07/18:05
 * @Description:
 **/
@RestController
@Api("统一账号服务api")
public class AccountController implements AccountAPI {

    @Autowired
    private AccountServiceImpl accountService;

    @ApiOperation("测试用例")
    @GetMapping("/hello")
    public String hello() {
        return  "hello";
    }

    /**
     * 登录
     * @param accountLoginDTO 封装登录请求数据
     * @return
     */
    @PostMapping("/l/accounts/session")
    @ApiOperation("登录获取session")
    @Override
    public RestResponse<AccountDTO> login(@RequestBody AccountLoginDTO accountLoginDTO) {
        return RestResponse.success(accountService.login(accountLoginDTO));
    }

    /**
     * 注册  由于不暴露给前端 路径用l
     * @param accountRegisterDTO 注册信息实体类
     * @return
     */
    @ApiOperation("注册功能")
    @PostMapping("/l/accounts")
    @Override
    public RestResponse<AccountDTO> registry(@RequestBody @Validated AccountRegisterDTO accountRegisterDTO) {
        return RestResponse.success(accountService.register(accountRegisterDTO));
    }

    @Override
    @ApiOperation("校验手机号验证码")
    @GetMapping("/mobiles/{mobile}/key/{key}/code/{code}")
    public RestResponse<Integer> checkMobile(@PathVariable String mobile,@PathVariable String key, @PathVariable String code) {
        Integer integer = accountService.checkMobile(mobile, key, code);
        return RestResponse.success(integer);
    }

    @Override
    @ApiOperation("获取手机验证码")
    @GetMapping("/sms/{mobile}")
    public RestResponse getSMSCode( @PathVariable  String mobile) {
        return accountService.getSmsCode(mobile);
    }
}
