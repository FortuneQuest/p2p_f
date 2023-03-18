package cn.oc.domain;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : CodePrefixCode
 * @Author: oc
 * @Date: 2023/03/15/10:11
 * @Description:
 **/
public enum CodePrefixCode {

    /**
     * 不使用前缀
     */
    CODE_NO_PREFIX("","不使用前缀"),

    /**
     * 标的好前缀
     */
    CODE_PROJECT_PREFIX("PRO","标的号前缀"),

    /**
     * 用户编码前缀
     */
    CODE_CONSUMER_PREFIX("USR_", "用户编码前缀"),

    /**
     * 请求流水号前缀
     */
    CODE_REQUEST_PREFIX("REQ_", "请求流水号前缀");

    private String code;
    private String desc;

    CodePrefixCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
