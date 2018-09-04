package com._360dwq.sellergoods.service.impl;

import com._360dwq.mapper.GoodsDescMapper;
import com._360dwq.pojo.TbGoodsDesc;
import com._360dwq.sellergoods.service.GoodsDescService;
import com._360dwq.service.impl.BaseServiceImpl;
import com._360dwq.vo.PageResult;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(interfaceClass = GoodsDescService.class)
public class GoodsDescServiceImpl extends BaseServiceImpl<TbGoodsDesc> implements GoodsDescService {

    @Autowired
    private GoodsDescMapper goodsDescMapper;

    @Override
    public PageResult search(Integer page, Integer rows, TbGoodsDesc goodsDesc) {
        PageHelper.startPage(page, rows);

        Example example = new Example(TbGoodsDesc.class);
        Example.Criteria criteria = example.createCriteria();
        /*if(!StringUtils.isEmpty(goodsDesc.get***())){
            criteria.andLike("***", "%" + goodsDesc.get***() + "%");
        }*/

        List<TbGoodsDesc> list = goodsDescMapper.selectByExample(example);
        PageInfo<TbGoodsDesc> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
