package cn.oc.depository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : DepositoryWithdrawResponse
 * @Author: oc
 * @Date: 2023/03/18/23:40
 * @Description: 存管提现响应信息
 **/
@Data
@ApiModel(value = "WithdrawResponse", description = "用户提现请求返回信息")
public class DepositoryWithdrawResponse extends DepositoryBaseResponse{

    @ApiModelProperty("交易状态")
    private String transactionStatus;
}
