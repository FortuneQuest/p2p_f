package cn.oc.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ConsumerRegisterDTO
 * @Author: oc
 * @Date: 2023/03/18/18:03
 * @Description: 用户注册信息
 **/
@Data
@ApiModel(value = "ConsumerRegisterDTO", description = "用户注册信息")
public class ConsumerRegisterDTO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户角色.B借款人 or I投资人")
    private String role;

    @ApiModelProperty("验证码key")
    private String key;
}
