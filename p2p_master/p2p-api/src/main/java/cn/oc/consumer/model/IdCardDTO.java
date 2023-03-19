package cn.oc.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : IdCardDTO
 * @Author: oc
 * @Date: 2023/03/18/18:35
 * @Description: 百度ORC识别身份证信息
 **/
@Data
@ApiModel(value = "IdCardDTO", description = "百度ORC识别身份证信息")
public class IdCardDTO {
    @ApiModelProperty("正反面")
    private String flag;

    @ApiModelProperty("ORC识别身份证号码")
    private String idCardNo;

    @ApiModelProperty("ORC识别身份证姓名")
    private String idCardName;

    @ApiModelProperty("ORC识别身份证地址")
    private String idCardAddress;
}
