package com._360dwq.vo;

import com._360dwq.pojo.TbSpecification;
import com._360dwq.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Dw_Qin
 * @Date 2017/08/31 14:01
 * @Email 569806951@qq.com
 */
public class Specification implements Serializable {
    private TbSpecification specification;
    private List<TbSpecificationOption> specificationOptionList;

    public TbSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(TbSpecification specification) {
        this.specification = specification;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "specification=" + specification +
                ", specificationOptionList=" + specificationOptionList +
                '}';
    }
}
