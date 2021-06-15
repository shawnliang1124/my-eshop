package com.shawnliang.eshop.inventory.async;

import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/15
 */
@Data
public class StockUpdateResult {

    /**
     * 商品库存更新消息id
     */
    private String messageId;
    /**
     * 商品库存更新结果
     */
    private Boolean result;

}
