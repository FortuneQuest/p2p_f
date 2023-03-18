package cn.oc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : PageRequestParams
 * @Author: oc
 * @Date: 2023/03/17/18:41
 * @Description:
 **/
@Data
@AllArgsConstructor
public class PageRequestParams {

    private  long startRow;

    private  long limit;

   public static PageRequestParams of(Integer pageNo,Integer pageSize) {
       Long startRow = Long.valueOf((pageNo - 1) * pageSize);
       Long limit =Long.valueOf((pageSize));
       return new PageRequestParams(startRow,limit);
   }

   public long getStarRow() {
       return startRow;
   }

    public void setStartRow(long startRow) {
        this.startRow = startRow;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

}
