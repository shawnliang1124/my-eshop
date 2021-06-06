package com.shawnliang.eshop.inventory.async;

import lombok.Data;

/**
 * 描述：.
 *
 * @author liangjiajing
 * @date 2021/6/6 18:48
 */
@Data
public class GoodStockUpdateMessage {

    /**
     * 商品库存更新操作
     */
    private Integer operation;

    /**
     * 核心参数数据
     */
    private Object parameter;
}
