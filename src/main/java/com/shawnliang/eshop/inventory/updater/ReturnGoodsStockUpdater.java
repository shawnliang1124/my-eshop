package com.shawnliang.eshop.inventory.updater;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;

import java.util.List;
import java.util.Map;

/**
 * 描述：.退货异步更新库存
 *
 * @author liangjiajing
 * @date 2021/6/6 17:30
 */
public class ReturnGoodsStockUpdater extends AbstractGoodsStockUpdaterCommand{

    private  Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap;

    public ReturnGoodsStockUpdater(List<InventoryGoodsStockDO> inventoryGoodsStockDOS,
                                   InventoryGoodsStockManager inventoryGoodsStockManager,
                                   Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap) {
        super(inventoryGoodsStockDOS, inventoryGoodsStockManager);
        this.returnGoodsInputOrderItemDTOMap = returnGoodsInputOrderItemDTOMap;
    }

    @Override
    protected void updateSalesStockQuantity() {
        for (InventoryGoodsStockDO inventoryGoodsStockDO : inventoryGoodsStockDOS) {
            ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO = returnGoodsInputOrderItemDTOMap.get(inventoryGoodsStockDO.getId());
            inventoryGoodsStockDO.setSaleStockQuantity(inventoryGoodsStockDO.getSaleStockQuantity() + returnGoodsInputOrderItemDTO.getArrivalCount());
        }
    }

    @Override
    protected void updateSaledStockQuantity() {
        for (InventoryGoodsStockDO inventoryGoodsStockDO : inventoryGoodsStockDOS) {
            ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO = returnGoodsInputOrderItemDTOMap.get(inventoryGoodsStockDO.getId());
            inventoryGoodsStockDO.setSaleStockQuantity(inventoryGoodsStockDO.getSaledStockQuantity() - returnGoodsInputOrderItemDTO.getArrivalCount());
        }
    }

    @Override
    protected void updateLockStockQuantity() {

    }

    @Override
    protected void updateStockStatus() {

    }
}
