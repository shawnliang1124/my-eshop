package com.shawnliang.eshop.wms.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 描述：.
 *
 * @author liangjiajing
 * @date 2021/6/6 17:43
 */
@Data
public class ReturnGoodsInputOrderPutOnItemDTO {

    /**
     * id
     */
    private Long id;
    /**
     * 退货入库单条目id
     */
    private Long returnGoodsInputOrderItemId;
    /**
     * 货位id
     */
    private Long goodsAllocationId;
    /**
     * 商品上架数量
     */
    private Long putOnShelvesCount;
    /**
     * 退货入库单商品上架条目的创建时间
     */
    private LocalDateTime gmtCreate;
    /**
     * 退货入库单商品上架条目的修改时间
     */
    private LocalDateTime gmtModified;

}
