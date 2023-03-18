package cn.oc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : RestResponse
 * @Author: oc
 * @Date: 2023/03/17/22:44
 * @Description:
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "RestResponse<T>", description = "响应通用参数包装" )
public class RestResponse<T> {

    @ApiModelProperty("响应错误编码，0为正确")
    private int code;

    @ApiModelProperty("相应错误信息")
    private String msg;

    @ApiModelProperty("响应内容")
    private T result;

   public RestResponse() {
       this(0,"");
   }
    public RestResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> RestResponse<T> success() {
        return new RestResponse<>();
    }

    public static <T> RestResponse<T> success(T result) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResult(result);
        return response;
    }

    public static <T> RestResponse<T> validfail(String msg) {
        RestResponse<T> response = new RestResponse<T>();
        response.setCode(-2);
        response.setMsg(msg);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
