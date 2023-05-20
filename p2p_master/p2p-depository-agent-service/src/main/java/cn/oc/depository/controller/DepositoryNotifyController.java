package cn.oc.depository.controller;

import cn.oc.api.depository.model.DepositoryConsumerResponse;
import cn.oc.api.depository.model.DepositoryRechargeResponse;
import cn.oc.api.depository.model.DepositoryWithdrawResponse;
import cn.oc.common.util.EncryptUtil;
import cn.oc.depository.message.GatewayMessageProducer;
import cn.oc.depository.service.DepositoryRecordService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 存管代理服务消息通知
 * </p>
 *
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@RestController
@Api(value = "银行存管系统通知服务", tags = "depository-agent")
public class DepositoryNotifyController {
    @Autowired
    private DepositoryRecordService depositoryRecordService;
    @Autowired
    private GatewayMessageProducer gatewayMessageProducer;

    @GetMapping(value = "/gateway", params = "serviceName=WITHDRAW")
    @ApiOperation("接受银行存管系统提现返回结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceName", value = "请求的存管接口名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "platformNo", value = "平台编号, 平台与存管系统签约时获取", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "signature", value = "对reqData参数的签名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "reqData", value = "业务数据报文, json格式", required = true, dataType = "String", paramType = "query")
    })
    public String receiveDepositoryWithdrawResult(@RequestParam(name = "serviceName") String serviceName, @RequestParam("platformNo") String platformNo, @RequestParam("signature") String signature, @RequestParam("reqData") String reqData) {
        DepositoryWithdrawResponse depositoryWithdrawResponse = JSON.parseObject(EncryptUtil.decodeUTF8StringBase64(reqData), DepositoryWithdrawResponse.class);
        gatewayMessageProducer.personalWithdraw(depositoryWithdrawResponse);
        return "OK";
    }

    @GetMapping(value = "/gateway", params = "serviceName=RECHARGE")
    @ApiOperation("接受银行存管系统充值返回结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceName", value = "请求的存管接口名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "platformNo", value = "平台编号, 平台与存管系统签约时获取", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "signature", value = "对reqData参数的签名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "reqData", value = "业务数据报文, json格式", required = true, dataType = "String", paramType = "query")
    })
    public String receiveDepositoryRechargeResult(@RequestParam(name = "serviceName") String serviceName, @RequestParam("platformNo") String platformNo, @RequestParam("signature") String signature, @RequestParam("reqData") String reqData) {
        DepositoryRechargeResponse depositoryRechargeResponse = JSON.parseObject(EncryptUtil.decodeUTF8StringBase64(reqData), DepositoryRechargeResponse.class);
        gatewayMessageProducer.personalRecharge(depositoryRechargeResponse);
        return "OK";
    }

    @GetMapping(value = "/gateway", params = "PERSONAL_REGISTER")
    @ApiOperation("接受银行存管系统开户回调结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceName", value = "请求的存管接口名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "platformNo", value = "平台编号, 平台与存管系统签约时获取", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "signature", value = "对reqData参数的签名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "reqData", value = "业务数据报文, json格式", required = true, dataType = "String", paramType = "query")
    })
    public String receiveDepositoryCreateConsumerResult(@RequestParam(name = "serviceName") String serviceName, @RequestParam("platformNo") String platformNo, @RequestParam("signature") String signature, @RequestParam("reqData") String reqData) {
        // 更新数据
        DepositoryConsumerResponse response = JSON.parseObject(EncryptUtil.decodeUTF8StringBase64(reqData), DepositoryConsumerResponse.class);
        depositoryRecordService.modifyRequestStatus(response.getRequestNo(), response.getStatus());
        // 给用户中心发送消息
        gatewayMessageProducer.personalRegister(response);

        // 给银行存管系统返回结果
        return "OK";
    }
}
