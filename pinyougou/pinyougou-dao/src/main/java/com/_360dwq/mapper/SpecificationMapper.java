package com._360dwq.mapper;

import com._360dwq.pojo.TbSpecification;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpecificationMapper extends Mapper<TbSpecification> {

    List<Map<String, Object>> selectOptionList();
}
