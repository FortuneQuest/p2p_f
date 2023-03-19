package cn.oc.acount.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AccountDto
 * @Author: oc
 * @Date: 2023/03/18/13:27
 * @Description:
 **/
@Data
@ApiModel(value = "Account",description = "账户信息")
public class AccountDTO {

    @ApiModelProperty("标识")
    private  Long id ;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("账号状态")
    private  Integer status;

    @ApiModelProperty("域(c：c端用户；b：b端用户)")
    private String domain;
}
