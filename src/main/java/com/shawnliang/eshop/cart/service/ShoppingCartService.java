package com.shawnliang.eshop.cart.service;

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

}
