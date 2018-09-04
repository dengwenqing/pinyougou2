package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbSpecification;
import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;
import com._360dwq.vo.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface SpecificationService extends BaseService<TbSpecification> {

    PageResult search(Integer page, Integer rows, TbSpecification specification);

    void add(Specification specification);

    Specification findOne(Long id);

    void update(Specification specification);

    void deleteSpecificationByIds(Long[] ids);

    List<Map<String, Object>> selectOptionList();
}