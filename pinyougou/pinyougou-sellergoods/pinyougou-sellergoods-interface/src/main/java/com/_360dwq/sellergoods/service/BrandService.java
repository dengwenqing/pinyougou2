package com._360dwq.sellergoods.service;

import com._360dwq.pojo.TbBrand;
import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Author Dw_Qin
 * @Date 2018/08/27 0:03
 * @Email 569806951@qq.com
 */

public interface BrandService extends BaseService<TbBrand> {
    List<TbBrand> queryAll();

    List<TbBrand> testPage(Integer page, Integer rows);

    PageResult search(TbBrand tbBrand, Integer page, Integer rows);

    List<Map<String, Object>> selectOptionList();
}
