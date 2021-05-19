package com.shawnliang.eshop.order.service;

import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import java.util.List;

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

    /**
     * 通知订单中心，“订单发表评论”事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informPublishCommentEvent(Long orderId);


    /**
     * 查询出没有发表评论的订单
     * @return
     */
    List<OrderInfoDTO> listNotPublishCommentOrders();

    /**
     * 批量进行统计事件
     * @param orderIds
     */
    void informBatchPublishCommentEvent(List<Long> orderIds);
}
