package com._360dwq.service;

import com._360dwq.vo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Dw_Qin
 * @Date 2016/08/27 09:15
 * @Email 569806951@qq.com
 */
public interface BaseService<T> {
    /**
      *@desc 根据主键查询
      *@param id
      *@return T(实体对象)
      */
    public T findOne(Serializable id);

    /**
      *@desc 查询全部
      *@return List<T>实体对象集合
      */
    public List<T> findAll();

    /**
      *@desc 根据条件查询列表
      *@param t 查询条件对象
      *@return List<T> 实体对象集合
      */
    public List<T> findByWhere(T t);

    /**
      *@desc 分页查询列表
      *@param page(页号),rows(页大小)
      *@return 分页实体类对象
      */
    public PageResult findPage(Integer page, Integer rows);

    /**
     *@desc 分页查询列表
     *@param page(页号),rows(页大小),t 查询条件对象
     *@return 分页实体类对象
     */
    public PageResult findPage(Integer page, Integer rows,T t);

    /**
      *@desc 新增
      *@param t 实体对象
      */
    public void add(T t);

    /**
      *@desc 根据主键更新
      *@param t 实体对象
      */
    public void update(T t);

    /**
      *@desc 批量删除
      *@param ids 主键集合
      */
    public void deleteByIds(Serializable[] ids);
}
