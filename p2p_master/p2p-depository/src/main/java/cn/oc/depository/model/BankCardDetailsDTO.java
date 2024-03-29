package cn.oc.depository.model;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 银行卡明细
 * </p>
 *
 * @author zhupeiyuan
 * @since 2019-05-15
 */
@Data
@ApiModel(value = "BankCardDetailsDTO", description = "银行卡明细")
public class BankCardDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键")
	private Long id;

	@ApiModelProperty(value = "银行卡ID")
	private Long bankCardId;

	@ApiModelProperty(value = "账户变动类型")
	private Integer changeType;

	@ApiModelProperty(value = "变动金额")
	private BigDecimal money;

	@ApiModelProperty(value = "当前余额")
	private BigDecimal balance;

	@ApiModelProperty(value = "账户变动时间")
	private LocalDateTime createDate;


}
