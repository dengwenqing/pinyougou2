package com._360dwq.sellergoods.service.impl;

import com._360dwq.service.impl.BaseServiceImpl;
import com._360dwq.vo.PageResult;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com._360dwq.mapper.SellerMapper;
import com._360dwq.pojo.TbSeller;
import com._360dwq.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(interfaceClass = SellerService.class)
public class SellerServiceImpl extends BaseServiceImpl<TbSeller> implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public PageResult search(Integer page, Integer rows, TbSeller seller) {
        PageHelper.startPage(page, rows);

        Example example = new Example(TbSeller.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(seller.getStatus())) {
            criteria.andEqualTo("status", seller.getStatus());
        }
        if (!StringUtils.isEmpty(seller.getNickName())) {
            criteria.andLike("nickName", "%" + seller.getNickName() + "%");
        }
        if (!StringUtils.isEmpty(seller.getName())) {
            criteria.andLike("name", "%" + seller.getName() + "%");
        }

        List<TbSeller> list = sellerMapper.selectByExample(example);
        PageInfo<TbSeller> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
