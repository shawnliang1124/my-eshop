package com.shawnliang.eshop.finace.service;

import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.shawnliang.eshop.wms.domain.SaleDeliveryOrderDO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface FinanceFacadeService {

    /**
     * 创建采购结算单
     * @param purchaseInputOrderDO 采购入库单DTO
     * @return 处理结果
     */
    Boolean createPurchaseSettlementOrder(
            PurchaseInputOrderDO purchaseInputOrderDO);

    /**
     * 给物流公司打款
     * @param saleDeliveryOrderDO 销售出库单
     * @return 处理结果
     */
    Boolean payForLogisticsCompany(
            SaleDeliveryOrderDO saleDeliveryOrderDO);

    /**
     * 执行退货退款操作
     * @param returnGoodsInputOrderDO 退货入库单DTO
     * @return 处理结果
     */
    Boolean executeReturnGoodsRefund(
            ReturnGoodsInputOrderDO returnGoodsInputOrderDO);

}
