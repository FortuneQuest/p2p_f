package cn.oc.consumer.controller;


import cn.oc.api.consumer.ConsumerApi;
import cn.oc.api.consumer.model.*;
import cn.oc.api.depository.model.GatewayRequest;
import cn.oc.common.domain.RestResponse;
import cn.oc.consumer.service.ConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@Api(value = "用户服务的Controller", tags = "Consumer", description = "用户服务API")
    public class ConsumerController implements ConsumerApi {

    @Autowired
    ConsumerService consumerService;



        @ApiOperation("测试hello")
        @GetMapping(path = "/hello")
        public String hello(){
            return "hello";
        }

        @ApiOperation("测试hi")
        @PostMapping(path="/hi")
        @ApiImplicitParam(name="name",value = "姓名",required = true,dataType = "String")
        public String hi(String name){
            return "hi,"+name;
        }

    @Override
    public RestResponse<BigDecimal> getMyBankCardDetails() {
        return null;
    }

    @Override
    public RestResponse<BigDecimal> getBankCardDetails(Long id) {
        return null;
    }

    @Override
    public RestResponse<BalanceDetailsDTO> getMyBalance() {
        return null;
    }

    @Override
    public RestResponse<BalanceDetailsDTO> getBalance(String userNo) {
        return null;
    }

    @Override
    public RestResponse<BorrowerDTO> getBorrower(Long id) {
        return null;
    }

    @Override
    public RestResponse<String> saveConsumerDetails(ConsumerDetailsDTO consumerDetailsDTO) {
        return null;
    }

    @Override
    public RestResponse<FileTokenDTO> applyUploadCertificate() {
        return null;
    }

    @Override
    public RestResponse<IdCardDTO> imageRecognition(MultipartFile multipartFile, String flag) throws IOException {
        return null;
    }

    @Override
    public RestResponse<GatewayRequest> createWithdrawRecord(String amount, String callbackUrl) {
        return null;
    }

    @Override
    public RestResponse<ConsumerDTO> getConsumer() {
        return null;
    }

    @Override
    public RestResponse<BankCardDTO> getBankCard() throws IOException {
        return null;
    }

    @Override
    public RestResponse<GatewayRequest> createConsumer(ConsumerRequest consumerRequest) throws IOException {
        return null;
    }

    /**
     * 用户注册
     * @param consumerRegisterDTO
     * @return
     */
    @Override
    @ApiOperation("用户注册")
    @PostMapping("/consumers")
    public RestResponse register(@RequestBody ConsumerRegisterDTO consumerRegisterDTO) {
        consumerService.register(consumerRegisterDTO);
        return  RestResponse.success();
    }
}
