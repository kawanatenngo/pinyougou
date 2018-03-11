package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
/**
 * 品牌服务层接口
 */
public interface BrandService {
    /**
     * 查询所有品牌
     */
    List<TbBrand> findAll();

    /**
     * 返回分页列表
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加品牌
     */
    void add(TbBrand brand);

    /**
     * 修改品牌
     */
    void update(TbBrand brand);

    /**
     * 根据id查找品牌
     */
    TbBrand findOne(Long id);
}
