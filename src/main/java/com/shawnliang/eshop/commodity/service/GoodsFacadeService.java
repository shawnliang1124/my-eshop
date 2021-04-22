package com.shawnliang.eshop.commodity.service;

import com.shawnliang.eshop.commodity.domain.GoodsSkuDto;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface GoodsFacadeService {


    /**
     * 根据id查询商品sku
     * @param goodsSkuId 商品sku id
     * @return 商品sku DTO
     */
    GoodsSkuDto getGoodsSkuById(Long goodsSkuId);

}
