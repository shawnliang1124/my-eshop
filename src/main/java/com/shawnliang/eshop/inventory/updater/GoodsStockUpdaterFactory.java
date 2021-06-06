package com.shawnliang.eshop.inventory.updater;

/**
 * 描述：.
 * @author liangjiajing
 * @date 2021/6/6 16:33
 */
public interface GoodsStockUpdaterFactory<T> {

    /**
     * 创建一个库存更新对象
     * @param params
     * @return
     */
    GoodsStockUpdater create(T params);
}
