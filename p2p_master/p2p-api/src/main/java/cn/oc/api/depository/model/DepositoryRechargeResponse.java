package cn.oc.api.depository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : DepositoryRechargeResponse
 * @Author: oc
 * @Date: 2023/03/18/22:49
 * @Description:   存管充值响应信息
 **/
@Data
@ApiModel(value = "RechargeResponse", description = "用户充值请求返回信息")
public class DepositoryRechargeResponse extends DepositoryBaseResponse {

    @ApiModelProperty("交易状态")
    private String transactionStatus;
}
