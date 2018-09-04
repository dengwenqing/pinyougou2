package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbSpecificationOption;
import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;


public interface SpecificationOptionService extends BaseService<TbSpecificationOption> {

    PageResult search(Integer page, Integer rows, TbSpecificationOption specificationOption);
}