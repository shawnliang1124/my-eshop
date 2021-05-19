package com.shawnliang.eshop.comment.schedlues;

import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.order.domain.OrderItemDTO;
import com.shawnliang.eshop.order.service.OrderFacadeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Description :  订单计时器 .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
@Component
public class OrderInfoScheduled {

    @Autowired
    private OrderFacadeService orderFacadeService;

    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void execute() {
        List<OrderInfoDTO> orderInfoDTOS = orderFacadeService.listNotPublishCommentOrders();

        for (OrderInfoDTO orderInfoDTO : orderInfoDTOS) {
            if (CollectionUtils.isEmpty(orderInfoDTO.getOrderItems())) {
                continue;
            }

            // 遍历订单
            for (OrderItemDTO orderItem : orderInfoDTO.getOrderItems()) {

            }
        }
    }

}
