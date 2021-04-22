package com.shawnliang.eshop.inventory.service;

import com.shawnliang.eshop.order.domain.OrderDto;
import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDTO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface InventoryFacadeService {

    /**
     * 通知库存中心，“采购入库完成”事件发生了
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean informPurchaseInputFinished(
            PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 通知库存中心，“提交订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDto orderDTO);

    /**
     * 通知库存中心，“支付订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informPayOrderEvent(OrderDto orderDTO);

    /**
     * 通知库存中心，“取消订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderDto orderDTO);

    /**
     * 通知库存中心，“完成退货入库”事件发生了
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    Boolean informReturnGoodsInputFinished(
            ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     * 查询商品sku的库存
     * @param goodsSkuId 商品sku id
     * @return 商品sku的库存
     */
    Long getSaleStockQuantity(Long goodsSkuId);

}
