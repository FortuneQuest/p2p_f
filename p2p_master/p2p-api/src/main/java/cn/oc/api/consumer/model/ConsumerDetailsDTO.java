package cn.oc.api.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ConsumerDetailsDTO
 * @Author: oc
 * @Date: 2023/03/18/15:34
 * @Description: 封装平台c端用户详细信息
 **/
@Data
@ApiModel(value = "ConsumerDetailsDTO", description = "平台c端用户详细信息")
public class ConsumerDetailsDTO {


    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户标识")
    private Long consumerId;

    @ApiModelProperty("身份证号")
    private String idCardNo;

    @ApiModelProperty("身份证照片面标识")
    private String idCardPhoto;

    @ApiModelProperty("身份证国徽面标识")
    private String idCardEmblem;

    @ApiModelProperty("住址")
    private String address;

    @ApiModelProperty("企业邮箱")
    private String enterpriseMail;

    @ApiModelProperty("联系人关系")
    private String contactRelation;


}

