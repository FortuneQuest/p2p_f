package cn.oc.api.search;


import cn.oc.api.search.model.ProjectQueryParamsDTO;
import cn.oc.api.transaction.model.ProjectDTO;
import cn.oc.common.domain.PageVO;
import cn.oc.common.domain.RestResponse;


/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public interface ContentSearchAPI {
    /**
     * 检索标的
     *
     * @param projectQueryParamsDTO
     * @return
     */
    RestResponse<PageVO<ProjectDTO>> queryProjectIndex(ProjectQueryParamsDTO projectQueryParamsDTO, Integer pageNo, Integer pageSize, String sortBy, String order);
}
