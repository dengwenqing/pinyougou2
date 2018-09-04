package com._360dwq.sellergoods.service.impl;

import com._360dwq.mapper.BrandMapper;
import com._360dwq.pojo.TbBrand;
import com._360dwq.sellergoods.service.BrandService;
import com._360dwq.service.BaseService;
import com._360dwq.service.impl.BaseServiceImpl;
import com._360dwq.vo.PageResult;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @Author Dw_Qin
 * @Date 2017/08/27 0:04
 * @Email 569806951@qq.com
 */

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl extends BaseServiceImpl<TbBrand> implements BrandService{
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<TbBrand> queryAll() {
        return brandMapper.queryAll();
    }

    @Override
    public List<TbBrand> testPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        return brandMapper.queryAll();
    }

    @Override
    public PageResult search(TbBrand tbBrand, Integer page, Integer rows) {
        //设置分页
        PageHelper.startPage(page,rows);

        //设置查询条件
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(tbBrand.getName())){
            criteria.andLike("name","%" + tbBrand.getName() + "%");
        }
        if(!StringUtils.isEmpty(tbBrand.getFirstChar())){
            criteria.andEqualTo("firstChar",tbBrand.getFirstChar());
        }

        List<TbBrand> brandList = brandMapper.selectByExample(example);
        PageInfo<TbBrand> pageInfo = new PageInfo<TbBrand>(brandList);
        return new PageResult(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public List<Map<String, Object>> selectOptionList() {
        return brandMapper.selectOptionList();
    }
}
