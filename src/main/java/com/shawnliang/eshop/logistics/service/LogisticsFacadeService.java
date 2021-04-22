package com.shawnliang.eshop.logistics.service;

import com.shawnliang.eshop.commodity.domain.GoodsSkuDto;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface LogisticsFacadeService {

    /**
     * 计算商品sku的运费
     * @param goodsSkuDTO 商品sku DTO
     * @return 商品sku的运费
     */
    Double calculateFreight(GoodsSkuDto goodsSkuDTO);

}
