package com.shawnliang.eshop.finace.service;

import com.shawnliang.eshop.wms.domain.PurchaseInputOrderDTO;
import com.shawnliang.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.shawnliang.eshop.wms.domain.SaleDeliveryOrderDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface FinanceFacadeService {

    /**
     * 创建采购结算单
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean createPurchaseSettlementOrder(
            PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 给物流公司打款
     * @param saleDeliveryOrderDTO 销售出库单
     * @return 处理结果
     */
    Boolean payForLogisticsCompany(
            SaleDeliveryOrderDTO saleDeliveryOrderDTO);

    /**
     * 执行退货退款操作
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    Boolean executeReturnGoodsRefund(
            ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

}
