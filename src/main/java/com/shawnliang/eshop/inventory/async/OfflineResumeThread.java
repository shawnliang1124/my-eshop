package com.shawnliang.eshop.inventory.async;

import java.util.List;
import lombok.SneakyThrows;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/17
 */
public class OfflineResumeThread extends Thread {

    private GoodsStockOfflineManager goodsStockOfflineManager;

    private GoodsStockUpdateQueue goodsStockUpdateQueue;

    public OfflineResumeThread(GoodsStockOfflineManager goodsStockOfflineManager
            , GoodsStockUpdateQueue goodsStockUpdateQueue) {
        this.goodsStockOfflineManager = goodsStockOfflineManager;
        this.goodsStockUpdateQueue = goodsStockUpdateQueue;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (goodsStockOfflineManager.hasNext()) {
            List<GoodStockUpdateMessage> updateMessageList =
                    goodsStockOfflineManager.getNextBatch();

            for (GoodStockUpdateMessage updateMessage : updateMessageList) {
                goodsStockUpdateQueue.put(updateMessage);
            }

            goodsStockOfflineManager.removeByBatch(updateMessageList);
        }

        goodsStockOfflineManager.setOffline(false);

    }
}
