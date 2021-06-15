package com.shawnliang.eshop.inventory.async;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/15
 */
public interface StockUpdateResultManager {

    /**
     * 设置对商品库存更新结果的观察
     * @param messageId 消息id
     */
    void observe(String messageId);

    /**
     * 获取商品库存更新结果的观察目标
     * @param messageId 商品库存更新消息id
     * @return 商品库存更新结果的观察目标
     */
    void inform(String messageId, Boolean result);

    /**
     * 获取库存更新结果观察目标
     * @param messageId 消息id
     * @return
     */
    StockUpdateObservable getObservable(String messageId);

}
