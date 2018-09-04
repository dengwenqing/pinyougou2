package com._360dwq.service.impl;

import com._360dwq.service.BaseService;
import com._360dwq.vo.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;


import java.io.Serializable;
import java.util.List;

/**
 * @Author Dw_Qin
 * @Date 2016/08/27 09:10
 * @Email 569806951@qq.com
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private Mapper<T> tMapper;

    @Override
    public T findOne(Serializable id) {
        return tMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return tMapper.selectAll();
    }

    @Override
    public List<T> findByWhere(T t) {
        return tMapper.select(t);
    }

    @Override
    public PageResult findPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<T> list = tMapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PageResult findPage(Integer page, Integer rows, T t) {
        PageHelper.startPage(page, rows);
        List<T> list = tMapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void add(T t) {
        tMapper.insertSelective(t);
    }

    @Override
    public void update(T t) {
        tMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public void deleteByIds(Serializable[] ids) {
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                tMapper.deleteByPrimaryKey(id);
            }
        }
    }
}
