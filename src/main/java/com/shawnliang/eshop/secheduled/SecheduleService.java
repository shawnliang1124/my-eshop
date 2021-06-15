package com.shawnliang.eshop.secheduled;

import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/15
 */
public interface SecheduleService {

    /**
     * 通知库存中心，“采购入库完成”事件发生了
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean informPurchaseInputFinished(
            PurchaseInputOrderDO purchaseInputOrderDTO);

    /**
     * 通知库存中心，“提交订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO);

    /**
     * 通知库存中心，“支付订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informPayOrderEvent(OrderInfoDTO orderDTO);

    /**
     * 通知库存中心，“取消订单”事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderInfoDTO orderDTO);

    /**
     * 通知库存中心，“完成退货入库”事件发生了
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    Boolean informReturnGoodsInputFinished(
            ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     * 调度采购入库
     * @param purchaseInputOrderDO 采购单DTO
     * @return 处理结果
     */
    Boolean schedulePurchaseInput(PurchaseInputOrderDO purchaseInputOrderDO);

    /**
     * 调度销售出库
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean scheduleSaleDelivery(OrderInfoDTO orderDTO);

    /**
     * 调度退货入库
     * @param orderDTO 订单DTO
     * @param returnGoodsWorksheetDTO 退货工单DTO
     * @return 处理结果
     */
    Boolean scheduleReturnGoodsInput(OrderInfoDTO orderDTO,
            ReturnGoodsInputOrderDTO returnGoodsWorksheetDTO);

}
