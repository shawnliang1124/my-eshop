package com.shawnliang.eshop.inventory.service;

import com.shawnliang.eshop.order.domain.OrderDO;
import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface InventoryFacadeService {

    /**
     * 通知库存中心，“采购入库完成”事件发生了
     * @param purchaseInputOrderDO 采购入库单DTO
     * @return 处理结果
     */
    void informPurchaseInputFinished(
            WmsPurchaseInputOrderDTO wmsPurchaseInputOrderDTO);

    /**
     * 通知库存中心，“提交订单”事件发生了
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    void informSubmitOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知库存中心，“支付订单”事件发生了
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    void informPayOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知库存中心，“取消订单”事件发生了
     * @param orderDO 订单DTO
     * @return 处理结果
     */
    void informCancelOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知库存中心，“完成退货入库”事件发生了
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    void informReturnGoodsInputFinished(
            ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     * 查询商品sku的库存
     * @param goodsSkuId 商品sku id
     * @return 商品sku的库存
     */
    Long getSaleStockQuantity(Long goodsSkuId);

}
