package cn.oc.repayment.controller;
import cn.oc.api.repayment.RepaymentAPI;

import cn.oc.api.transaction.model.ProjectWithTendersDTO;
import cn.oc.common.domain.RestResponse;
import cn.oc.repayment.service.RepaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
@RestController
@Api(value = "还款服务", tags = "repayment")
public class RepaymentController implements RepaymentAPI {
    @Autowired
    private RepaymentService repaymentService;

    @Override
    @PostMapping("/l/start-repayment")
    @ApiOperation("启动还款")
    @ApiImplicitParam(name = "projectWithTendersDTO", value = "通过id获取标的信息", required = true, dataType = "ProjectWithTendersDTO", paramType = "body")
    public RestResponse<String> startRepayment(@RequestBody ProjectWithTendersDTO projectWithTendersDTO) {
        return RestResponse.success(repaymentService.startRepayment(projectWithTendersDTO));
    }
}
