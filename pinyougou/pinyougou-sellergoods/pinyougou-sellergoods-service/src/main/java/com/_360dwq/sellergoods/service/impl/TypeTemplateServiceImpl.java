package com._360dwq.sellergoods.service.impl;

import com._360dwq.service.impl.BaseServiceImpl;
import com._360dwq.vo.PageResult;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com._360dwq.mapper.TypeTemplateMapper;
import com._360dwq.pojo.TbTypeTemplate;
import com._360dwq.sellergoods.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service(interfaceClass = TypeTemplateService.class)
public class TypeTemplateServiceImpl extends BaseServiceImpl<TbTypeTemplate> implements TypeTemplateService {

    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    @Override
    public PageResult search(Integer page, Integer rows, TbTypeTemplate typeTemplate) {
        PageHelper.startPage(page, rows);

        Example example = new Example(TbTypeTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(typeTemplate.getName())){
            criteria.andLike("name", "%" + typeTemplate.getName() + "%");
        }

        List<TbTypeTemplate> list = typeTemplateMapper.selectByExample(example);
        PageInfo<TbTypeTemplate> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Map<String, Object>> selectOptionList() {

        return typeTemplateMapper.selectOptionList();
    }
}
