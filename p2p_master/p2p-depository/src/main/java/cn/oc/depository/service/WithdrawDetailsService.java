package cn.oc.depository.service;

import cn.oc.depository.entity.WithdrawDetails;
import cn.oc.depository.model.WithdrawRequest;
import cn.oc.depository.model.WithdrawResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户余额明细表 服务类
 * </p>
 *
 * @author zhupeiyuan
 * @since 2019-05-13
 */
public interface WithdrawDetailsService extends IService<WithdrawDetails> {

    /**
     * 用户提现
     * @param withdrawRequest
     * @return
     */
    WithdrawResponse withDraw(WithdrawRequest withdrawRequest);

}
