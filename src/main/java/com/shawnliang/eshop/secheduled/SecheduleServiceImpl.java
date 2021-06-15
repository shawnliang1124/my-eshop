package com.shawnliang.eshop.secheduled;

import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/15
 */
@Service
@Slf4j
public class SecheduleServiceImpl implements SecheduleService{

    @Override
    public Boolean informPurchaseInputFinished(PurchaseInputOrderDO purchaseInputOrderDTO) {
        return null;
    }

    @Override
    public Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO) {
        return null;
    }

    @Override
    public Boolean informPayOrderEvent(OrderInfoDTO orderDTO) {
        return null;
    }

    @Override
    public Boolean informCancelOrderEvent(OrderInfoDTO orderDTO) {
        return null;
    }

    @Override
    public Boolean informReturnGoodsInputFinished(
            ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO) {
        return null;
    }

    @Override
    public Boolean schedulePurchaseInput(PurchaseInputOrderDO purchaseInputOrderDO) {
        return null;
    }

    @Override
    public Boolean scheduleSaleDelivery(OrderInfoDTO orderDTO) {
        return null;
    }

    @Override
    public Boolean scheduleReturnGoodsInput(OrderInfoDTO orderDTO,
            ReturnGoodsInputOrderDTO returnGoodsWorksheetDTO) {
        return null;
    }
}
