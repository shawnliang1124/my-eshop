package com.shawnliang.eshop.wms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 * wms中心的采购入库单条目表
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-21
 */
@Data
public class WmsPurchaseInputOrderItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购入库单ID
     */
    private Long purchaseInputOrderId;

    /**
     * 商品SKU ID
     */
    private Long goodsSkuId;

    /**
     * 采购数量
     */
    private Long purchaseCount;

    /**
     * 采购价格 (分为单位)
     */
    private Long purchasePrice;

    /**
     * 合格商品的数量
     */
    private Long qualifiedCount;

    /**
     * 到货的商品数量
     */
    private Long arrivalCount;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
