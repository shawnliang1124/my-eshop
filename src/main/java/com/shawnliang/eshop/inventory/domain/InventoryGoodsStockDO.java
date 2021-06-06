package com.shawnliang.eshop.inventory.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 库存中心的商品库存表
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InventoryGoodsStockDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品sku ID
     */
    private Long goodsSkuId;

    /**
     * 销售库存
     */
    private Long saleStockQuantity;

    /**
     * 锁定库存
     */
    private Long lockedStockQuantity;

    /**
     * 已销售库存
     */
    private Long saledStockQuantity;

    /**
     * 库存状态，0：无库存，1：有库存
     */
    private Integer stockStatus;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
