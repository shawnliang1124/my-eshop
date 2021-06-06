package com.shawnliang.eshop.inventory.updater;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderDTO;
import java.util.List;
import java.util.Map;

import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description :  采购入库更新库存 .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/21
 */
public class PurchaseInputStockUpdater extends AbstractGoodsStockUpdaterCommand{

    /**
     * 采购入库单条目DTO集合
     */
    private Map<Long, WmsPurchaseInputOrderItemDTO> purchaseInputOrderItemDTOMap;


    @Autowired
    private InventoryGoodsStockManager inventoryGoodsStockManager;

    public PurchaseInputStockUpdater(
            List<InventoryGoodsStockDO> inventoryGoodsStockDOS,
            InventoryGoodsStockManager inventoryGoodsStockManager,
            Map<Long, WmsPurchaseInputOrderItemDTO> purchaseInputOrderItemDTOMap) {
        super(inventoryGoodsStockDOS, inventoryGoodsStockManager);

        this.purchaseInputOrderItemDTOMap = purchaseInputOrderItemDTOMap;
    }

    /**
     * 采购的时候，销售库存会进行更新
     */
    @Override
    protected void updateSalesStockQuantity() {
        for (InventoryGoodsStockDO inventoryGoodsStockDO : inventoryGoodsStockDOS) {
            inventoryGoodsStockDO.setSaleStockQuantity(inventoryGoodsStockDO.getSaledStockQuantity() + 1);
        }
    }

    @Override
    protected void updateSaledStockQuantity() {
    }

    @Override
    protected void updateLockStockQuantity() {

    }

    @Override
    protected void updateStockStatus() {

    }
}
