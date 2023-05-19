package cn.oc.api.transaction.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ProjectWithTendersDTO
 * @Author: oc
 * @Date: 2023/03/19/15:36
 * @Description:  标的还款信息
 **/
@Data
public class ProjectWithTendersDTO {

    /**
     * 标的信息
     */
    private ProjectDTO project;

    /**
     * 标的对应的所有投标记录
     */
    private List<TenderDTO> tenders;

    /**
     * 投资人让出利率 (投资人让利)
     */
    private BigDecimal commissionInvestorAnnualRate;

    /**
     * 借款人给平台的利率 (借款人让利)
     */
    private BigDecimal commissionBorrowerAnnualRate;
}
