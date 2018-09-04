package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbItemCat;
import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;

import java.util.List;

public interface ItemCatService extends BaseService<TbItemCat> {

    PageResult search(Integer page, Integer rows, TbItemCat itemCat);

    PageResult findByPageParentId(Long parentId, Integer page, Integer rows);
}