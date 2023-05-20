package cn.oc.search.service;

import cn.oc.api.search.model.ProjectQueryParamsDTO;
import cn.oc.api.transaction.model.ProjectDTO;
import cn.oc.common.domain.PageVO;
/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public interface ContentSearchService {
    /**
     * 标的检索
     *
     * @param queryParamsDTO 查询集
     * @param pageNo         页码
     * @param pageSize       数据条数
     * @param sortBy         排序
     * @param order          顺序
     * @return
     */
    PageVO<ProjectDTO> queryProjectIndex(ProjectQueryParamsDTO queryParamsDTO, Integer pageNo, Integer pageSize, String sortBy, String order);
}
