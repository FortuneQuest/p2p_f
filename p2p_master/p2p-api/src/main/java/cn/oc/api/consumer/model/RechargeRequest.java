package cn.oc.api.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : RechargeRequest
 * @Author: oc
 * @Date: 2023/03/18/18:56
 * @Description: 用户充值请求信息
 **/
@Data
@Accessors(chain = true)
@ApiModel("用户充值请求信息")
public class RechargeRequest {
    @ApiModelProperty("标识")
    private Long id;

    @ApiModelProperty("用户编号")
    private String userNo;

    @ApiModelProperty("请求流水号")
    private String requestNo;

    @ApiModelProperty("充值金额")
    private BigDecimal amount;

    @ApiModelProperty("页面回调URL")
    private String callbackUrl;
}
