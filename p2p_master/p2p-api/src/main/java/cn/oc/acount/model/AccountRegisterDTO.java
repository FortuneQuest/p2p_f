package cn.oc.acount.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccoutRegisterDTO
 * @Author: oc
 * @Date: 2023/03/18/13:49
 * @Description:
 **/
@Data
@ApiModel(value = "AccountRegisterDTO", description = "账户注册信息")
public class AccountRegisterDTO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("密码")
    private String password;
}
