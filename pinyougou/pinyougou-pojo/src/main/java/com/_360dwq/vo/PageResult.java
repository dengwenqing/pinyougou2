package com._360dwq.vo;

import java.io.Serializable;
import java.util.List;
/**
 * @Author Dw_Qin
 * @Date 2017/08/27 09:15
 * @Email 569806951@qq.com
 */

public class PageResult implements Serializable {
    //总记录数
    private Long total;
    //记录列表；?表示占位符类似泛型，除此以外；使用了?的该属性在赋值以后不可以改变其值
    private List<?> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
