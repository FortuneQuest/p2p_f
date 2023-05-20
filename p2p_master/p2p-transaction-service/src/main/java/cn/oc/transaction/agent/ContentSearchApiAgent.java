package cn.oc.transaction.agent;

import cn.oc.api.transaction.model.ProjectDTO;
import cn.oc.api.transaction.model.ProjectQueryDTO;
import cn.oc.common.domain.PageVO;
import cn.oc.common.domain.RestResponse;
import cn.oc.transaction.agent.ContentSearchApiAgentConfiguration;
import cn.oc.transaction.agent.ContentSearchApiAgentFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@FeignClient(
        value = "content-search-service",
        fallback = ContentSearchApiAgentFallback.class,
        configuration = {ContentSearchApiAgentConfiguration.class}
)
public interface ContentSearchApiAgent {
    @PostMapping(value = "/search/l/projects/indexes/q")
    RestResponse<PageVO<ProjectDTO>> queryProjectIndex(@RequestBody ProjectQueryDTO projectQueryDTO, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "sortBy", required = false) String sortBy, @RequestParam(value = "order", required = false) String order);
}

