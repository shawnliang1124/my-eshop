package com.shawnliang.eshop.inventory.updater;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.order.domain.OrderItemDTO;
import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderDTO;

import java.util.List;
import java.util.Map;

/**
 * 描述：.
 *
 * @author liangjiajing
 * @date 2021/6/6 16:01
 */
public class PayOrderGoodsStockUpdater extends AbstractGoodsStockUpdaterCommand{

    /**
     * 采购·1入库单DTO
     */
    private Map<Long, OrderItemDTO> orderItemDTOMap;

    /**
     * 采购·1入库单DTO
     */
    private WmsPurchaseInputOrderDTO purchaseInputOrderDTO;

    public PayOrderGoodsStockUpdater(List<InventoryGoodsStockDO> inventoryGoodsStockDOS, InventoryGoodsStockManager inventoryGoodsStockManager, Map<Long, OrderItemDTO> orderItemDTOMap) {
        super(inventoryGoodsStockDOS, inventoryGoodsStockManager);
        this.orderItemDTOMap = orderItemDTOMap;
    }

    /**
     * 更新销售库存
     */
    @Override
    protected void updateSalesStockQuantity() {
        for (InventoryGoodsStockDO inventoryGoodsStockDO : inventoryGoodsStockDOS) {
            OrderItemDTO orderItemDTO = orderItemDTOMap.get(inventoryGoodsStockDO.getGoodsSkuId());
            inventoryGoodsStockDO.setSaleStockQuantity(inventoryGoodsStockDO.getSaledStockQuantity() - orderItemDTO.getPurchaseQuantity());
        }
    }

    /**
     * 更新已经销售的库存
     */
    @Override
    protected void updateSaledStockQuantity() {
        for (InventoryGoodsStockDO inventoryGoodsStockDO : inventoryGoodsStockDOS) {
            OrderItemDTO orderItemDTO = orderItemDTOMap.get(inventoryGoodsStockDO.getGoodsSkuId());
            inventoryGoodsStockDO.setSaledStockQuantity(inventoryGoodsStockDO.getSaledStockQuantity() + orderItemDTO.getPurchaseQuantity());
        }
    }

    /**
     * 更新锁定的库存
     */
    @Override
    protected void updateLockStockQuantity() {
        for (InventoryGoodsStockDO inventoryGoodsStockDO : inventoryGoodsStockDOS) {
            OrderItemDTO orderItemDTO = orderItemDTOMap.get(inventoryGoodsStockDO.getGoodsSkuId());
            inventoryGoodsStockDO.setLockedStockQuantity(inventoryGoodsStockDO.getLockedStockQuantity() + orderItemDTO.getPurchaseQuantity());
        }
    }

    @Override
    protected void updateStockStatus() {

    }
}
