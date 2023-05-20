package cn.oc.transaction.agent;

import cn.oc.api.transaction.model.ProjectDTO;
import cn.oc.api.transaction.model.ProjectQueryDTO;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.PageVO;
import cn.oc.common.domain.RestResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName :ContentSearchApiAgentFallback
 * @Author: oc
 * @Date: 2023/05/20/4:39
 * @Description:
 **/
class ContentSearchApiAgentFallback implements ContentSearchApiAgent {

    @Override
    public RestResponse<PageVO<ProjectDTO>> queryProjectIndex(ProjectQueryDTO projectQueryDTO, Integer pageNo, Integer pageSize, String sortBy, String order) {
        throw new BusinessException(CommonErrorCode.E_999993);
    }
}
