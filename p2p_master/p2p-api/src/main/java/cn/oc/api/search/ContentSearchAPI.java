package cn.oc.api.search;

import cn.oc.common.domain.PageVO;
import cn.oc.common.domain.RestResponse;
import cn.oc.api.search.model.ProjectQueryParamsDTO;
import cn.oc.api.transaction.model.ProjectDTO;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ContentSearchAPI
 * @Author: oc
 * @Date: 2023/03/19/0:35
 * @Description:
 **/

public interface ContentSearchAPI {
    /**
     * 检索标的
     *
     * @param projectQueryParamsDTO
     * @return
     */
    RestResponse<PageVO<ProjectDTO>> queryProjectIndex(ProjectQueryParamsDTO projectQueryParamsDTO, Integer pageNo, Integer pageSize, String sortBy, String order);
}
