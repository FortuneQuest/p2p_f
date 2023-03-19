package cn.oc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : PageVo
 * @Author: oc
 * @Date: 2023/03/17/20:36
 * @Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO<T>  implements  Iterable<T>, Serializable {


    private List<T> content  = new ArrayList<T>();
    private  long total;
    private  int pageNo;
    private  int pageSize;

    /**
     * Returns if there is a previous page.
     *
     * @return if there is a previous page.
     */
    public boolean hasPrevious() {
        return  getPageNo()>0;
    }

    /**
     * Returns if there is a next page.
     * @return
     */
    public boolean hasNext() {
        return  getPageNo()+1<getTotalPage();
    }

    /**
     * Returns whether the current page is the first one.
     *
     * @return whether the current page is the first one.
     */
    public boolean isFirst() {
        return !hasPrevious();
    }

    /**
     * Returns whether the current  page is the last one.
     *
     * @return whether the current  page is the last one.
     */
    boolean isLast(){
        return !hasNext();
    }

    /**
     * Returns the number of total pages.
     *
     * @return the number of total pages
     */
    public int getTotalPage() {
            return getPageSize() ==0?1:(int) Math.ceil((double) total/(double) getPageSize());
    }

    /**
     * Returns whether the current page has content.
     *
     * @return whether the current page has content.
     */
    public boolean hasContent() {
        return getContentSize()>0;
    }
    /**
     * Returns the number of elements on current page.
     *
     * @return the number of elements on current page.
     */
    public int getContentSize() {
        return content.size();
    }



    @Override
    public Iterator<T> iterator() {
        return getContent().iterator();
    }


}
