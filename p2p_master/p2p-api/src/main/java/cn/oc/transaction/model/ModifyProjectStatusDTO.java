package cn.oc.transaction.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ModifyProjectStatusDTO
 * @Author: oc
 * @Date: 2023/03/19/14:35
 * @Description:  修改标的状态DTO
 **/
@Data
public class ModifyProjectStatusDTO {

    /**
     * 请求流水号
     */
    private String requestNo;

    /**
     * 标的号
     */
    private String projectNo;

    /**
     * 更新标的状态
     */
    private String projectStatus;

    /**
     * 业务实体id
     */
    private Long id;
}
