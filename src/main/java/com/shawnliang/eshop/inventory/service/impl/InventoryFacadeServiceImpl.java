package com.shawnliang.eshop.inventory.service.impl;

import com.shawnliang.eshop.inventory.async.GoodStockUpdateMessage;
import com.shawnliang.eshop.inventory.async.GoodsStockUpdateQueue;
import com.shawnliang.eshop.inventory.constant.GoodsStockUpdateOperation;
import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.inventory.service.InventoryFacadeService;
import com.shawnliang.eshop.inventory.updater.*;
import com.shawnliang.eshop.order.domain.OrderDO;
import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * 描述：.库存中心实现
 * @author liangjiajing
 * @date 2021/6/6 18:21
 */
@Service
@Slf4j
public class InventoryFacadeServiceImpl implements InventoryFacadeService {

    @Autowired
    private PurchaseInputStockUpdaterFactory<WmsPurchaseInputOrderDTO>
            purchaseInputStockUpdaterFactory;

    @Autowired
    private ReturnGoodsStockUpdaterFactory<ReturnGoodsInputOrderDTO>
            returnGoodsStockUpdaterFactory;

    @Autowired
    private SubmitOrderGoodsStockUpdaterFactory<OrderInfoDTO>
            submitOrderGoodsStockUpdaterFactory;

    @Autowired
    private PayOrderStockUpdaterFactory<OrderInfoDTO>
            payOrderStockUpdaterFactory;

    @Autowired
    private CancelOrderStockUpdaterFactory<OrderInfoDTO>
            cancelOrderStockUpdaterFactory;

    @Autowired
    private InventoryGoodsStockManager inventoryGoodsStockManager;

    @Autowired
    private GoodsStockUpdateQueue goodsStockUpdateQueue;

    @Override
    public void informPurchaseInputFinished(WmsPurchaseInputOrderDTO wmsPurchaseInputOrderDTO) {
        GoodsStockUpdater goodsStockUpdater = purchaseInputStockUpdaterFactory.create(wmsPurchaseInputOrderDTO);
        goodsStockUpdater.updateGoodsStock();
    }

    @Override
    public void informSubmitOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            GoodsStockUpdater goodsStockUpdater = submitOrderGoodsStockUpdaterFactory.create(orderInfoDTO);
            goodsStockUpdater.updateGoodsStock();

            //  异步通知信息已经更新
            GoodStockUpdateMessage goodStockUpdateMessage = new GoodStockUpdateMessage();
            goodStockUpdateMessage.setParameter(GoodsStockUpdateOperation.SUBMIT_ORDER);
            goodStockUpdateMessage.setParameter(orderInfoDTO);
            goodsStockUpdateQueue.put(goodStockUpdateMessage);
        } catch (Exception e) {
            log.error("error", e);
        }
    }

    @Override
    public void informPayOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            GoodsStockUpdater goodsStockUpdater = payOrderStockUpdaterFactory.create(orderInfoDTO);
            goodsStockUpdater.updateGoodsStock();

            //  异步通知信息通知更新库存
            GoodStockUpdateMessage goodStockUpdateMessage = new GoodStockUpdateMessage();
            goodStockUpdateMessage.setParameter(GoodsStockUpdateOperation.PAY_ORDER);
            goodStockUpdateMessage.setParameter(orderInfoDTO);
            goodsStockUpdateQueue.put(goodStockUpdateMessage);
        } catch (Exception e) {
            log.error("error", e);
        }

    }

    @Override
    public void informCancelOrderEvent(OrderInfoDTO orderInfoDTO) {
        try {
            GoodsStockUpdater goodsStockUpdater = cancelOrderStockUpdaterFactory.create(orderInfoDTO);
            goodsStockUpdater.updateGoodsStock();

            //  异步通知信息已经更新
            GoodStockUpdateMessage goodStockUpdateMessage = new GoodStockUpdateMessage();
            goodStockUpdateMessage.setParameter(GoodsStockUpdateOperation.CANCEL_ORDER);
            goodStockUpdateMessage.setParameter(orderInfoDTO);
            goodsStockUpdateQueue.put(goodStockUpdateMessage);
        } catch (Exception e) {
            log.error("error", e);
        }
    }

    @Override
    public void informReturnGoodsInputFinished(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO) {
        GoodsStockUpdater goodsStockUpdater = returnGoodsStockUpdaterFactory.create(returnGoodsInputOrderDTO);
        goodsStockUpdater.updateGoodsStock();
    }

    @Override
    public Long getSaleStockQuantity(Long goodsSkuId) {
        InventoryGoodsStockDO goodsStockDO = inventoryGoodsStockManager.getBySkuId(goodsSkuId);
        if (goodsStockDO == null) {
            return 0L;
        }

        return goodsStockDO.getSaleStockQuantity();
    }
}
