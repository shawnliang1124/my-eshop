package com.shawnliang.eshop.inventory.command;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/21
 */
@Slf4j
public abstract class AbstractGoodsStockUpdaterCommand implements GoodsStockUpdateCommand {

    protected List<InventoryGoodsStockDO> inventoryGoodsStockDOS;

    protected InventoryGoodsStockManager inventoryGoodsStockManager;

    public AbstractGoodsStockUpdaterCommand(List<InventoryGoodsStockDO> inventoryGoodsStockDO,
            InventoryGoodsStockManager inventoryGoodsStockManager) {
        this.inventoryGoodsStockDOS = inventoryGoodsStockDO;
        this.inventoryGoodsStockManager = inventoryGoodsStockManager;
    }

    @Override
    public Boolean updateGoodsStock() {
        updateLockStockQuantity();
        updateSalesStockQuantity();
        updateSaledStockQuantity();
        updateStockStatus();
        return true;
    }

    /**
     * 更新商品的销售库存
     */
    protected abstract void updateSalesStockQuantity();

    /**
     *更新商品的已经销售库存
     */
    protected abstract void updateSaledStockQuantity();

    /**
     * 更新商品的锁定的库存
     */
    protected abstract void updateLockStockQuantity();

    /**
     * 更新商品的库存状态
     */
    protected abstract void updateStockStatus();

    /**
     * 批量执行更新库存DO
     */
    private void executeUpdateGoodStock() {
        for (InventoryGoodsStockDO inventoryGoodsStockDO : inventoryGoodsStockDOS) {
            inventoryGoodsStockManager.updateById(inventoryGoodsStockDO);
        }
    }
}
