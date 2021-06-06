package com.shawnliang.eshop.inventory.updater;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.order.domain.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 描述：.提交订单更新库存
 * @author liangjiajing
 * @date 2021/6/6 17:47
 */
@Service
public class SubmitOrderGoodsStockUpdaterFactory<T> extends AbstractGoodsStockUpdaterFactory<T>{

    public SubmitOrderGoodsStockUpdaterFactory(@Autowired InventoryGoodsStockManager inventoryGoodsStockManager) {
        super(inventoryGoodsStockManager);
    }

    @Override
    protected GoodsStockUpdater createUpdater(List<InventoryGoodsStockDO> stockDOList, T params) {
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) params;
        List<OrderItemDTO> orderItems = orderInfoDTO.getOrderItems();

        Map<Long, OrderItemDTO> orderItemMap = orderItems.stream().
                collect(Collectors.toMap(OrderItemDTO::getGoodsSkuId, Function.identity()));
        return new SubmitOrderGoodsStockUpdater(stockDOList, inventoryGoodsStockManager, orderItemMap);
    }

    @Override
    protected List<Long> getGoodsSkuId(T params) {
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) params;
        List<OrderItemDTO> orderItems = orderInfoDTO.getOrderItems();

        return orderItems.stream().map(OrderItemDTO::getGoodsSkuId)
                .collect(Collectors.toList());
    }
}
