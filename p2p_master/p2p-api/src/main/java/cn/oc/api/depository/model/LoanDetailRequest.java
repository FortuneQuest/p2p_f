package cn.oc.api.depository.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : LoanDetailRequest
 * @Author: oc
 * @Date: 2023/03/18/23:48
 * @Description: 放款明细请求信息
 **/
@Data
public class LoanDetailRequest {

    /**
     * 放款金额
     */
    private BigDecimal amount;

    /**
     * 预处理业务流水号
     */
    private String preRequestNo;


}
