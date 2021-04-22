package com.shawnliang.eshop.wms.service;

import com.shawnliang.eshop.order.domain.OrderDto;
import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDTO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.shawnliang.eshop.wms.domain.SaleDeliveryOrderDTO;

/**
 * Description :  采购中心对外提供的接口 .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface WmsFacadeService {


    /**
     * 创建采购入库单
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 创建销售出库单
     * @param saleDeliveryOrderDTO 销售出库单DTO
     * @return 处理结果
     */
    Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrderDTO);

    /**
     * 创建退货入库单
     * @param returnGoodsInputOrder 退货入库单DTO
     * @return 处理结果
     */
    Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDTO returnGoodsInputOrder);

    /**
     * 通知WMS中心，“提交订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDto orderDTO);

    /**
     * 通知WMS中心，“支付订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informPayOrderEvent(OrderDto orderDTO);

    /**
     * 通知WMS中心，“取消订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderDto orderDTO);

}
