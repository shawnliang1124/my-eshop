package com.shawnliang.eshop.inventory.async;

/**
 * 描述：.商品库存更新消息的队列接口
 * @author liangjiajing
 * @date 2021/6/6 18:48
 */
public interface GoodsStockUpdateQueue {

    /**
     * 将一个消息放入队列
     * @param message
     * @throws
     */
    void put(GoodStockUpdateMessage message) throws InterruptedException;

    /**
     * 从队列里面取出一个消息
     * @return
     */
    GoodStockUpdateMessage get() throws InterruptedException;
}
