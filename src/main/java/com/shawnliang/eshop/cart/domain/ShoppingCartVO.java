package com.shawnliang.eshop.cart.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-20
 */
@Data
public class ShoppingCartVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    private Long goodsSkuId;

    /**
     * 会员账号ID
     */
    private Long userAccountId;
}
