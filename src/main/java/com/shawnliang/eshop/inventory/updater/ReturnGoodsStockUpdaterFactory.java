package com.shawnliang.eshop.inventory.updater;

import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.manager.InventoryGoodsStockManager;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;
import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderDTO;
import com.shawnliang.eshop.wms.domain.WmsPurchaseInputOrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 描述：采购商品，更新库存.
 * @author liangjiajing
 * @date 2021/6/6 16:52
 */
@Service
public class ReturnGoodsStockUpdaterFactory<T>
        extends AbstractGoodsStockUpdaterFactory<T> {


    public ReturnGoodsStockUpdaterFactory(@Autowired InventoryGoodsStockManager inventoryGoodsStockManager) {
        super(inventoryGoodsStockManager);
    }

    @Override
    protected GoodsStockUpdater createUpdater(List<InventoryGoodsStockDO> stockDOList, T params) {
        ReturnGoodsInputOrderDTO purchaseInputOrderDTO = (ReturnGoodsInputOrderDTO) params;
        List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOs = purchaseInputOrderDTO.getReturnGoodsInputOrderItemDTOs();

        Map<Long, ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOMap = returnGoodsInputOrderItemDTOs.stream()
                .collect(Collectors.toMap(ReturnGoodsInputOrderItemDTO::getGoodsSkuId, Function.identity()));

        return new ReturnGoodsStockUpdater(stockDOList, inventoryGoodsStockManager, returnGoodsInputOrderItemDTOMap);
    }


    @Override
    protected List<Long> getGoodsSkuId(T params) {
        WmsPurchaseInputOrderDTO purchaseInputOrderDTO = (WmsPurchaseInputOrderDTO) params;
        List<WmsPurchaseInputOrderItemDTO> inputOrderItemDTOS = purchaseInputOrderDTO.getInputOrderItemDTOS();

        if (CollectionUtils.isEmpty(inputOrderItemDTOS)) {
            return new ArrayList<>();
        }

        return inputOrderItemDTOS.stream()
                .map(WmsPurchaseInputOrderItemDTO::getGoodsSkuId).collect(Collectors.toList());
    }
}
