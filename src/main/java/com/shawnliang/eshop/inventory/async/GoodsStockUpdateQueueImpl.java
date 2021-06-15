package com.shawnliang.eshop.inventory.async;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 描述：.
 *
 * @author liangjiajing
 * @date 2021/6/6 18:50
 */
@Component
public class GoodsStockUpdateQueueImpl implements GoodsStockUpdateQueue{

    /**
     * 商品库存更新队列
     */
    private ArrayBlockingQueue<GoodStockUpdateMessage> queue =
            new ArrayBlockingQueue<GoodStockUpdateMessage>(1000);


    @Override
    public void put(GoodStockUpdateMessage message) throws InterruptedException {
        queue.put(message);

        // TODO 如果队列再满的情况下·，就不要放到队列里面取了，只能丢到ipan上
    }

    @Override
    public GoodStockUpdateMessage get() throws InterruptedException {
        return queue.take();
    }
}
