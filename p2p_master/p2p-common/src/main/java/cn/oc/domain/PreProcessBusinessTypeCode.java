package cn.oc.domain;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : PreProcessBusinessTypeCode
 * @Author: oc
 * @Date: 2023/03/17/22:02
 * @Description:
 **/

public enum PreProcessBusinessTypeCode {
    /**
     * 用户 投标 业务代码
     */
    TENDER("TENDER", "投标"),

    /**
     * 用户 还款 业务代码
     */
    REPAYMENT("REPAYMENT", "还款"),

    /**
     * 用户 债权购买 业务代码
     */
    CREDIT_ASSIGNMENT("CREDIT_ASSIGNMENT", "债权购买"),

    /**
     * 用户 代偿 业务代码
     */
    COMPENSATORY("COMPENSATORY", "代偿"),

    /**
     * 用户 代偿还款 业务代码
     */
    COMPENSATORY_REPAYMENT("COMPENSATORY_REPAYMENT", "代偿还款"),
    ;

    private String code;
    private String desc;


    PreProcessBusinessTypeCode (String code, String desc) {
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

