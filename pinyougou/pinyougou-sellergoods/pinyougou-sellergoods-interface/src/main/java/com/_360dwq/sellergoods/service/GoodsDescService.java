package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbGoodsDesc;
import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;
public interface GoodsDescService extends BaseService<TbGoodsDesc> {

    PageResult search(Integer page, Integer rows, TbGoodsDesc goodsDesc);
}