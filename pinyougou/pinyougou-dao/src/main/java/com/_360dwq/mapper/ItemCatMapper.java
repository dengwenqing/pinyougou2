package com._360dwq.mapper;

import com._360dwq.pojo.TbItemCat;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemCatMapper extends Mapper<TbItemCat> {
    List<TbItemCat> findByParentId(Long parentId);
}
