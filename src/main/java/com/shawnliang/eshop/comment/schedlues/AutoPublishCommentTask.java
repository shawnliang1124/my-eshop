package com.shawnliang.eshop.comment.schedlues;

import com.shawnliang.eshop.comment.domain.CommentInfoDTO;
import com.shawnliang.eshop.comment.service.CommentAggregateService;
import com.shawnliang.eshop.comment.service.CommentInfoService;
import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.order.domain.OrderItemDTO;
import com.shawnliang.eshop.order.service.OrderFacadeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Description :  自动发表评论 .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
@Component
public class AutoPublishCommentTask {

    @Autowired
    private OrderFacadeService orderFacadeService;

    @Autowired
    private CommentInfoService commentInfoService;

    @Autowired
    private CommentAggregateService commentAggregateService;

    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void execute() {
        // 查询出近7天没有发表过评论的订单
        List<OrderInfoDTO> orderInfoDTOS = orderFacadeService
                .listNotPublishCommentOrders();
        List<Long> orderIds = new ArrayList<>(orderInfoDTOS.size());

        for (OrderInfoDTO orderInfoDTO : orderInfoDTOS) {
            if (CollectionUtils.isEmpty(orderInfoDTO.getOrderItems())) {
                continue;
            }

            orderIds.add(orderInfoDTO.getId());

            // 遍历订单
            for (OrderItemDTO orderItem : orderInfoDTO.getOrderItems()) {
                // 自动发表评论
                CommentInfoDTO commentInfoDTO = commentInfoService
                        .saveAutoCommentInfo(orderInfoDTO, orderItem);

                // 进行评论相关统计
                commentAggregateService.updateCommentAggregate(commentInfoDTO);
            }

            // 通知订单中心，批量进行了评论
            orderFacadeService.informBatchPublishCommentEvent(orderIds);
        }
    }

}
