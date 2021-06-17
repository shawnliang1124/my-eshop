package com.shawnliang.eshop.inventory.async;

import java.util.concurrent.ArrayBlockingQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述：.
 *
 * @author liangjiajing
 * @date 2021/6/6 18:50
 */
@Component
@Slf4j
public class GoodsStockUpdateQueueImpl implements GoodsStockUpdateQueue{

    @Autowired
    private GoodsStockOfflineManager goodsStockOfflineManager;

    /**
     * 商品库存更新队列
     */
    private ArrayBlockingQueue<GoodStockUpdateMessage> queue =
            new ArrayBlockingQueue<GoodStockUpdateMessage>(1000);


    @Override
    public void put(GoodStockUpdateMessage message) throws InterruptedException {
        // 如果队列在满的情况下，先存储到数据库上，等待队列消费完了，再从去开一个后台线程。从数据库中拿数据丢到队列上
        if (goodsStockOfflineManager.getOffline()) {
            log.info("队列已经满了，消息进行离线的存储");
            goodsStockOfflineManager.storage(message);

            // 队列为空的情况，开启一个后台线程去进行离线消息的消费
            if (queue.size() == 0) {
                new OfflineResumeThread(goodsStockOfflineManager, this).start();
            }

            return;
        }

        // 如果队列的大小已经满了，直接触发离线存储
        if (queue.size() == 1000) {
            log.info("队列已经满了，直接触发离线存储");
            goodsStockOfflineManager.storage(message);
            goodsStockOfflineManager.setOffline(true);
            return;
        }

        queue.put(message);
    }

    @Override
    public GoodStockUpdateMessage get() throws InterruptedException {
        return queue.take();
    }
}
