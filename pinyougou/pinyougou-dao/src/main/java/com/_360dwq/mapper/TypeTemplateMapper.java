package com._360dwq.mapper;

import com._360dwq.pojo.TbTypeTemplate;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TypeTemplateMapper extends Mapper<TbTypeTemplate> {

    List<Map<String, Object>> selectOptionList();
}