package com.shawnliang.eshop.inventory.command;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/21
 */
public interface GoodsStockUpdateCommand {

    /**
     * 更新商品的库存
     * @return
     */
    Boolean updateGoodsStock();
}
