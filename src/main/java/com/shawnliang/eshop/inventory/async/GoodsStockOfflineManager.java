package com.shawnliang.eshop.inventory.async;

import java.util.List;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/17
 */
public interface GoodsStockOfflineManager {

    /**
     * 消息存储
     * @param stockUpdateMessage
     */
    void storage(GoodStockUpdateMessage stockUpdateMessage);

    /**
     * 获取离线存储标识
     * @return 离线存储标识
     */
    Boolean getOffline();

    /**
     * 设置离线存储标识
     * @param offline 离线存储标识
     */
    void setOffline(Boolean offline);

    /**
     * 判断是否还有下一批库存更新消息
     * @return 是否还有下一批库存更新消息
     */
    public Boolean hasNext();

    /**
     * 获取下一批库存更新消息
     * @return 下一批库存更新消息
     */
    List<GoodStockUpdateMessage> getNextBatch();

    /**
     * 批量删除库存更新消息
     * @param stockUpdateMessages 库存更新消息
     * @throws Exception
     */
    void removeByBatch(List<GoodStockUpdateMessage> stockUpdateMessages);

}
