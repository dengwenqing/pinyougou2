package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbTypeTemplate;
import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;

import java.util.List;
import java.util.Map;


public interface TypeTemplateService extends BaseService<TbTypeTemplate> {

    PageResult search(Integer page, Integer rows, TbTypeTemplate typeTemplate);

    List<Map<String, Object>> selectOptionList();
}