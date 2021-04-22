package com.shawnliang.eshop.wms.service;

import com.shawnliang.eshop.order.domain.OrderDO;
import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.shawnliang.eshop.wms.domain.SaleDeliveryOrderDO;

/**
 * Description :  采购中心对外提供的接口 .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface WmsFacadeService {


    /**
     * 创建采购入库单
     * @param purchaseInputOrderDO 采购入库单DTO
     * @return 处理结果
     */
    Boolean createPurchaseInputOrder(PurchaseInputOrderDO purchaseInputOrderDO);

    /**
     * 创建销售出库单
     * @param saleDeliveryOrderDO 销售出库单DTO
     * @return 处理结果
     */
    Boolean createSaleDeliveryOrder(SaleDeliveryOrderDO saleDeliveryOrderDO);

    /**
     * 创建退货入库单
     * @param returnGoodsInputOrder 退货入库单DTO
     * @return 处理结果
     */
    Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDO returnGoodsInputOrder);

    /**
     * 通知WMS中心，“提交订单”事件发生了
     * @param orderDO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDO orderDO);

    /**
     * 通知WMS中心，“支付订单”事件发生了
     * @param orderDO 订单DTO
     * @return 处理结果
     */
    Boolean informPayOrderEvent(OrderDO orderDO);

    /**
     * 通知WMS中心，“取消订单”事件发生了
     * @param orderDO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderDO orderDO);

}
