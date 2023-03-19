package cn.oc.depository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : DepositoryRecordDTO
 * @Author: oc
 * @Date: 2023/03/18/22:57
 * @Description: 存管交易记录表
 **/
@Data
@EqualsAndHashCode(callSuper = false)  //如果callSuper为false,则不会涉及父类的属性，而callSuper为true时
                                        // ，表示对父类的属性也要生成equals和hashCode方法
@ApiModel(value = "DepositoryRecordDTO对象", description = "存管交易记录表")
public class DepositoryRecordDTO implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "请求流水号")
    private String requestNo;

    @ApiModelProperty(value = "业务实体类型")
    private String objectType;

    @ApiModelProperty(value = "关联业务实体标识")
    private Long objectId;

    @ApiModelProperty(value = "请求时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "是否是同步调用")
    private Integer isSyn;

    @ApiModelProperty(value = "数据同步状态")
    private Integer requestStatus;

    @ApiModelProperty(value = "消息确认时间")
    private LocalDateTime confirmDate;

    @ApiModelProperty("返回数据")
    private String responseData;
}

