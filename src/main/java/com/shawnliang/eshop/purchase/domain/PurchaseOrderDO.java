package com.shawnliang.eshop.purchase.domain;

import java.util.Date;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
@Data
public class PurchaseOrderDO {

    /**
     * id
     */
    private Long id;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 预期到货时间
     */
    private Date expectArrivalTime;
    /**
     * 采购联系人
     */
    private String purchaseContactor;
    /**
     * 采购联系人电话号码
     */
    private String purchaseContactPhoneNumber;
    /**
     * 采购联系人邮箱地址
     */
    private String purchaseContactEmail;
    /**
     * 采购单备注
     */
    private String purchaseOrderComment;
    /**
     * 采购员
     */
    private String purchaser;
    /**
     * 采购单的状态
     */
    private Integer purcahseOrderStatus;
    /**
     * 采购单的创建时间
     */
    private Date gmtCreate;
    /**
     * 采购单的修改时间
     */
    private Date gmtModified;


}
