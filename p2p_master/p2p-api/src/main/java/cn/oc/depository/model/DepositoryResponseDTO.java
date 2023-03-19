package cn.oc.depository.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : DepositoryResponseDTO
 * @Author: oc
 * @Date: 2023/03/18/23:37
 * @Description:
 **/
@Data
public class DepositoryResponseDTO<T> implements Serializable {

    /**
     * 业务数据报文, JSON格式
     */
    @ApiModelProperty("业务数据报文，JSON格式")
    private T respData;

    /**
     * 签名
     */
    @ApiModelProperty("签名数据")
    private String signature;
}
