package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbGoods;
import com._360dwq.service.BaseService;
import com._360dwq.vo.Goods;
import com._360dwq.vo.PageResult;


public interface GoodsService extends BaseService<TbGoods> {

    PageResult search(Integer page, Integer rows, TbGoods goods);

    void addGoods(Goods goods);
}