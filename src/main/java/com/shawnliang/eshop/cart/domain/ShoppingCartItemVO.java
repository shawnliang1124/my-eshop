package com.shawnliang.eshop.cart.domain;

import com.shawnliang.eshop.promotion.domain.PromotionActivityDTO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 购物车的商品条目
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-20
 */
@Data
public class ShoppingCartItemVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 购物车ID
     */
    private Long shoppingCartId;

    /**
     * 商品sku ID
     */
    private Long goodsSkuId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**+
     * 商品sku编号
     */
    private String goodsSkuCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品的销售价格
     */
    private Double salePrice;

    /**
     * 商品的毛重
     */
    private Double goodsWeight;

    /**
     * 商品长度
     */
    private Double goodsLength;

    /**
     * 商品高度
     */
    private Double goodsHeight;

    /**
     * 购买数量
     */
    private Long purchaseQuantity;

    /**
     * 商品的sku库存
     */
    private Long saleStockQuantity;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * 购物车条目的活动属性
     */
    private List<PromotionActivityDTO> promotionActivityDTOList;
}
