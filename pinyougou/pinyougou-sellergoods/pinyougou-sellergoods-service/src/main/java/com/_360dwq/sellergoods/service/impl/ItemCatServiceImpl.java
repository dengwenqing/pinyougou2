package com._360dwq.sellergoods.service.impl;

import com._360dwq.mapper.ItemCatMapper;
import com._360dwq.pojo.TbItemCat;
import com._360dwq.sellergoods.service.ItemCatService;
import com._360dwq.service.impl.BaseServiceImpl;
import com._360dwq.vo.PageResult;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(interfaceClass = ItemCatService.class)
public class ItemCatServiceImpl extends BaseServiceImpl<TbItemCat> implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public PageResult search(Integer page, Integer rows, TbItemCat itemCat) {
        PageHelper.startPage(page, rows);

        Example example = new Example(TbItemCat.class);
        Example.Criteria criteria = example.createCriteria();
        /*if(!StringUtils.isEmpty(itemCat.get***())){
            criteria.andLike("***", "%" + itemCat.get***() + "%");
        }*/

        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        PageInfo<TbItemCat> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PageResult findByPageParentId(Long parentId, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);

        List<TbItemCat> list = itemCatMapper.findByParentId(parentId);
        PageInfo<TbItemCat> pageInfo = new PageInfo<TbItemCat>(list);

        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

}
