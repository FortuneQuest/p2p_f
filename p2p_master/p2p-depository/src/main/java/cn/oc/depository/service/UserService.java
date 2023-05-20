package cn.oc.depository.service;

import cn.oc.depository.entity.DepositoryBankCard;
import cn.oc.depository.entity.User;
import cn.oc.depository.model.PersonalRegisterRequest;
import cn.oc.depository.model.PersonalRegisterResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 存管用户信息表 服务类
 * </p>
 *
 * @author zhupeiyuan
 * @since 2019-05-13
 */
public interface UserService extends IService<User> {

	/**
	 * 用户绑卡注册
	 * @param personalRegisterRequest
	 * @return
	 */
	PersonalRegisterResponse createUser(PersonalRegisterRequest personalRegisterRequest);

	/**
	 * 根据用户编码获取绑定银行卡信息
	 * @param userNo
	 * @return
	 */
	DepositoryBankCard getDepositoryBankCardByUserNo(String userNo);

	/**
	 * 校验用户交易密码
	 * @param userNo
	 * @param password
	 * @return
	 */
	Boolean verifyPassword(String userNo, String password);

}
