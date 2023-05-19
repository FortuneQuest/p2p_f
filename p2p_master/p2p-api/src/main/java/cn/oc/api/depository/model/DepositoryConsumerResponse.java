package cn.oc.api.depository.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : DepositoryConsumerResponse
 * @Author: oc
 * @Date: 2023/03/18/20:27
 * @Description:  用户开户返回参数信息
 **/
public class DepositoryConsumerResponse extends DepositoryBaseResponse {

    @ApiModelProperty("银行代码")
    private String bankCode;

    @ApiModelProperty("银行名称")
    private String bankName;
}
