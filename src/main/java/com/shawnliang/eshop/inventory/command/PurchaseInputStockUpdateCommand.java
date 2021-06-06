package com.shawnliang.eshop.inventory.command;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description :  采购入库更新库存 .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/21
 */
public class PurchaseInputStockUpdateCommand extends AbstractGoodsStockUpdaterCommand{

    /**
     * 采购·1入库单DTO
     */
    private WmsPurchaseInputOrderDTO purchaseInputOrderDTO;


    @Autowired
    private InventoryGoodsStockManager inventoryGoodsStockManager;

    public PurchaseInputStockUpdateCommand(
            List<InventoryGoodsStockDO> inventoryGoodsStockDOS,
            InventoryGoodsStockManager inventoryGoodsStockManager,
            WmsPurchaseInputOrderDTO purchaseInputOrderDTO) {
        super(inventoryGoodsStockDOS, inventoryGoodsStockManager);
        this.purchaseInputOrderDTO = purchaseInputOrderDTO;
    }

    /**
     * 采购的时候，销售库存会进行更新
     */
    @Override
    protected void updateSalesStockQuantity() {

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
