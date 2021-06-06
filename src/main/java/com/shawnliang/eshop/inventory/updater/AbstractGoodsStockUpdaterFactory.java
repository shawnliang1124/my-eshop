package com.shawnliang.eshop.inventory.updater;

import com.shawnliang.eshop.inventory.constant.StockStatus;
import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：.
 *
 * @author liangjiajing
 * @date 2021/6/6 16:34
 */
public abstract class AbstractGoodsStockUpdaterFactory<T> implements GoodsStockUpdaterFactory<T>{

    protected InventoryGoodsStockManager inventoryGoodsStockManager;

    public AbstractGoodsStockUpdaterFactory(InventoryGoodsStockManager inventoryGoodsStockManager) {
        this.inventoryGoodsStockManager = inventoryGoodsStockManager;
    }

    @Override
    public GoodsStockUpdater create(T params) {
        List<Long> goodSkuIds = getGoodsSkuId(params);
        List<InventoryGoodsStockDO> stockDOList = createGoodStockDO(goodSkuIds);
        return createUpdater(stockDOList, params);
    }

    /**
     * 创建库存更新命令
     * @param stockDOList 商品库存DO对象集合
     * @param params
     * @return
     */
    protected abstract GoodsStockUpdater createUpdater(List<InventoryGoodsStockDO> stockDOList, T params);


    /**
     * 获取 商品的sku集合
     * @param params
     * @return
     */
    protected abstract List<Long> getGoodsSkuId(T params);


    /**
     * 创建商品库存DO 对象集合
     * @param goodSkuIds 商品skuIds
     * @return
     */
    private List<InventoryGoodsStockDO> createGoodStockDO(List<Long> goodSkuIds) {
        List<InventoryGoodsStockDO> goodsStockDOS = new ArrayList<>(goodSkuIds.size());

        for (Long goodSkuId : goodSkuIds) {
            InventoryGoodsStockDO inventoryGoodsStockDO = inventoryGoodsStockManager.getBySkuId(goodSkuId);

            if (inventoryGoodsStockDO == null) {
                inventoryGoodsStockDO = new InventoryGoodsStockDO();
                inventoryGoodsStockDO.setGoodsSkuId(goodSkuId);
                inventoryGoodsStockDO.setSaleStockQuantity(0L);
                inventoryGoodsStockDO.setLockedStockQuantity(0L);
                inventoryGoodsStockDO.setSaledStockQuantity(0L);
                inventoryGoodsStockDO.setStockStatus(StockStatus.NOT_IN_STOCK);

                inventoryGoodsStockManager.save(inventoryGoodsStockDO);
            }
        }
        return goodsStockDOS;
    }
}
