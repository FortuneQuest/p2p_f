package cn.oc.api.transaction.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : TenderOverviewDTO
 * @Author: oc
 * @Date: 2023/03/19/15:44
 * @Description:   投标信息预览
 **/
@Data
@ApiModel(value = "TenderOverviewDTO", description = "投标信息预览")
public class TenderOverviewDTO {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("投标人用户标识")
    private Long consumerId;

    @ApiModelProperty("投标人用户名")
    private String consumerUsername;

    @ApiModelProperty("投标冻结金额")
    private BigDecimal amount;

    @ApiModelProperty("投标方式")
    private String tenderWay = "手动出借";

    @ApiModelProperty("创建时间")
    // private LocalDateTime createDate;
    private Date createDate;
}
