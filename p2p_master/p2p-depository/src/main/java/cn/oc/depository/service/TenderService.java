package cn.oc.depository.service;

import cn.oc.depository.entity.Tender;
import cn.oc.depository.model.ConfirmLoanResponse;
import cn.oc.depository.model.UserAutoPreTransactionRequest;
import cn.oc.depository.model.UserAutoPreTransactionResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 投标信息表 服务类
 * </p>
 *
 * @author zhupeiyuan
 * @since 2019-05-13
 */
public interface TenderService extends IService<Tender> {

	/**
	 * 投标预授权处理
	 * @param preTransactionRequest
	 * @return
	 */
	UserAutoPreTransactionResponse autoPreTransactionForTender(UserAutoPreTransactionRequest preTransactionRequest);

	/**
	 * 放款确认
	 * @param reqData
	 * @return
	 */
	ConfirmLoanResponse confirmLoan(String reqData);

}
