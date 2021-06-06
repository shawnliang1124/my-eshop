package com.shawnliang.eshop.cart.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
     * 主键
     */
    private Long id;

    /**
     * 会员账号ID
     */
    private Long userAccountId;

    private Long goodsSkuId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


    /**
     * 购物车条目明细
     */
    private List<ShoppingCartItemVO> shoppingCartItemVOS;
}
