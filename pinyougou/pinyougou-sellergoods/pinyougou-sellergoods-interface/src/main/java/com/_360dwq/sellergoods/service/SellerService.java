package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbSeller;
import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;


public interface SellerService extends BaseService<TbSeller> {

    PageResult search(Integer page, Integer rows, TbSeller seller);
}