package com.shawnliang.eshop.order.service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface OrderFacadeService {


    /**
     * 通知订单中心，“商品完成发货”事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informGoodsDeliveryFinishedEvent(Long orderId);

    /**
     * 通知订单中心，“退货工单审核不通过”事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId);

    /**
     * 通知订单中心，“退货工单审核通过”事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsWorsheetApprovedEvent(Long orderId);

    /**
     * 通知订单中心，“确认收到退货商品”事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsReceivedEvent(Long orderId);

    /**
     * 通知订单中心，“退货入库单审核通过”事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId);

    /**
     * 通知订单中心，“完成退款”事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informRefundFinishedEvent(Long orderId);


}
