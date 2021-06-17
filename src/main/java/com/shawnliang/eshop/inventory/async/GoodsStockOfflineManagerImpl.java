package com.shawnliang.eshop.inventory.async;

import com.alibaba.fastjson.JSONObject;
import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockOfflineDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockOfflineManager;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/17
 */
@Component
public class GoodsStockOfflineManagerImpl implements GoodsStockOfflineManager{

    /**
     * 是否打开离线存储
     */
    private boolean isOpenOffline;

    @Autowired
    private InventoryGoodsStockOfflineManager inventoryGoodsStockOfflineManager;

    @Override
    public void storage(GoodStockUpdateMessage stockUpdateMessage) {
        InventoryGoodsStockOfflineDO inventoryGoodsStockOfflineDO = create(stockUpdateMessage);
        inventoryGoodsStockOfflineManager.save(inventoryGoodsStockOfflineDO);
    }

    @Override
    public Boolean getOffline() {
        return this.isOpenOffline;
    }

    @Override
    public void setOffline(Boolean offline) {
        this.isOpenOffline = offline;
    }

    @Override
    public Boolean hasNext() {
        return inventoryGoodsStockOfflineManager.countOfflineMsg() > 0;
    }

    @Override
    public List<GoodStockUpdateMessage> getNextBatch() {
        List<GoodStockUpdateMessage> results = Lists.newArrayList();

        // 查询50条离线存储信息
        List<InventoryGoodsStockOfflineDO> inventoryGoodsStockOfflineDOList = inventoryGoodsStockOfflineManager
                .listBySize(50);
        for (InventoryGoodsStockOfflineDO inventoryGoodsStockOfflineDO : inventoryGoodsStockOfflineDOList) {
            GoodStockUpdateMessage updateMessage = new GoodStockUpdateMessage();
            updateMessage.setMsgId(inventoryGoodsStockOfflineDO.getMsgId());
            updateMessage.setOperation(inventoryGoodsStockOfflineDO.getOperation());
            updateMessage.setParameter(JSONObject.parse(inventoryGoodsStockOfflineDO.getParameter()));

            results.add(updateMessage);
        }
        return results;
    }

    @Override
    public void removeByBatch(List<GoodStockUpdateMessage> stockUpdateMessages) {
        if (!CollectionUtils.isEmpty(stockUpdateMessages)) {
            List<String> msgIds = stockUpdateMessages.stream()
                    .map(GoodStockUpdateMessage::getMsgId).collect(Collectors.toList());

            List<Long> ids = inventoryGoodsStockOfflineManager.findIdInMsgIds(msgIds);

            inventoryGoodsStockOfflineManager.removeByIds(ids);
        }

    }

    /**
     * 创建 离线存储消息
     * @param goodStockUpdateMessage
     * @return
     */
    private InventoryGoodsStockOfflineDO create(GoodStockUpdateMessage goodStockUpdateMessage) {
        InventoryGoodsStockOfflineDO entity = new InventoryGoodsStockOfflineDO();

        entity.setMsgId(goodStockUpdateMessage.getMsgId());
        entity.setOperation(goodStockUpdateMessage.getOperation());
        entity.setParameter(JSONObject.toJSONString(goodStockUpdateMessage.getParameter()));

        return entity;
    }
}
