package com.shawnliang.eshop.inventory.updater;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.order.domain.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 描述： 购买订单更新库存.
 * @author liangjiajing
 * @date 2021/6/6 17:26
 */
@Service
public class PayOrderStockUpdaterFactory<T>
    extends AbstractGoodsStockUpdaterFactory<T> {

    public PayOrderStockUpdaterFactory(@Autowired InventoryGoodsStockManager inventoryGoodsStockManager) {
        super(inventoryGoodsStockManager);
    }

    @Override
    protected GoodsStockUpdater createUpdater(List<InventoryGoodsStockDO> stockDOList, T params) {
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) params;
        List<OrderItemDTO> orderItems = orderInfoDTO.getOrderItems();

        if (CollectionUtils.isEmpty(orderItems)) {
            return null;
        }

        Map<Long, OrderItemDTO> orderItemDTOMap = orderItems.stream()
        .collect(Collectors.toMap(OrderItemDTO::getGoodsSkuId, Function.identity()));

        return new PayOrderGoodsStockUpdater(stockDOList, inventoryGoodsStockManager, orderItemDTOMap);
    }

    @Override
    protected List<Long> getGoodsSkuId(T params) {
        OrderInfoDTO orderInfoDTO = (OrderInfoDTO) params;

        List<Long> goodsSkuIds = new ArrayList<Long>();

        List<OrderItemDTO> orderItemDTOs = orderInfoDTO.getOrderItems();
        for(OrderItemDTO orderItemDTO : orderItemDTOs) {
            goodsSkuIds.add(orderItemDTO.getGoodsSkuId());
        }

        return goodsSkuIds;
    }
}
