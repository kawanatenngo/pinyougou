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
}
