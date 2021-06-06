package com.shawnliang.eshop.cart.service;

import com.shawnliang.eshop.cart.domain.ShoppingCartDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/20
 */
public interface ShoppingCartService {

    /**
     * 添加购物车的条目
     * @param userAccountId
     * @param goodsSkuId
     */
    void addShoppingCartItem(Long userAccountId, Long goodsSkuId);

    /**
     * 根据用户id 查询购车车的数据
     * @param userAccountId
     * @return
     */
    ShoppingCartDTO getByUserAccountId(Long userAccountId);

}
