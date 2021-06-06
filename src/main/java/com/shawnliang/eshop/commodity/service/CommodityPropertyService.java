package com.shawnliang.eshop.commodity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyDTO;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyQuery;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/19
 */
public interface CommodityPropertyService {

    /**
     * 分页查询商品属性
     * @param query
     * @return
     */
    IPage<CommodityPropertyDTO> findByPageAndQuery(CommodityPropertyQuery query);

    /**
     * 按照ID 查询
     * @param id
     * @return
     */
    CommodityPropertyDTO findById(Long id);

    /**
     * 新增商品属性
     * @param commodityPropertyDTO
     */
    void saveProperty(CommodityPropertyDTO commodityPropertyDTO);

    /**
     * 更新商品属性
     * @param commodityPropertyDTO
     */
    void updateProperty(CommodityPropertyDTO commodityPropertyDTO);
}
