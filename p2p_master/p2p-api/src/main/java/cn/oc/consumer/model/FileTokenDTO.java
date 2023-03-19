package cn.oc.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : FileTokenDTO
 * @Author: oc
 * @Date: 2023/03/18/18:16
 * @Description:  上传文件凭证
 **/
@Data
@ApiModel(value = "FileTokenDTO", description = "上传文件凭证")
public class FileTokenDTO {
    @ApiModelProperty("应用ID")
    private String appId;

    @ApiModelProperty("ak")
    private String accessKey;

    @ApiModelProperty("sk")
    private String secretKey;
}
