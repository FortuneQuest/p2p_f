package cn.oc.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : BankCardDTO
 * @Author: oc
 * @Date: 2023/03/18/15:28
 * @Description:  银行卡信息
 **/
@Data
@ApiModel(value = "BankCardDTO", description = "银行卡信息")
public class BankCardDTO {

    @ApiModelProperty("标识")
    private Long id;

    @ApiModelProperty("用户标识")
    private Long consumerId;

    @ApiModelProperty("用户实名")
    private String fullName;

    @ApiModelProperty("银行编码")
    private String bankCode;

    @ApiModelProperty("银行名称")
    private String bankName;

    @ApiModelProperty("银行卡号")
    private String cardNumber;

    @ApiModelProperty("银行预留手机号")
    private String mobile;

    @ApiModelProperty("可用状态")
    private Integer status;
}
