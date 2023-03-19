package cn.oc.acount.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccountLoginDTO
 * @Author: oc
 * @Date: 2023/03/18/13:44
 * @Description: 封装账户登录信息
 **/

@Data
@ApiModel(value = "AccountLoginDTO",description = "账户登录信息")
public class AccountLoginDTO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("手机号")
    private  String mobile;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("域(c：c端用户；b：b端用户)")
    private String domain;
}
