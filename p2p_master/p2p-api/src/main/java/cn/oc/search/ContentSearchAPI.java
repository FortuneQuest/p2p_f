package cn.oc.search;

import cn.oc.domain.PageVO;
import cn.oc.domain.RestResponse;
import cn.oc.search.model.ProjectQueryParamsDTO;
import cn.oc.transaction.model.ProjectDTO;

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
