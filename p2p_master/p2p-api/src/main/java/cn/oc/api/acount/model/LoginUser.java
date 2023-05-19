package cn.oc.api.acount.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : LoginUser
 * @Author: oc
 * @Date: 2023/03/18/13:50
 * @Description: 当前登录用户
 **/
@Data
public class LoginUser {
    private String tenantId;
    private String departmentId;
    private String payload;
    private String username;
    private String mobile;
    private String userAuthorities;
    private String clientId;
}
