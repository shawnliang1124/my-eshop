package com.shawnliang.eshop.wms.domain;

import java.util.Date;
import lombok.Data;

/**
 * Description : 采购入库单DTO  .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
@Data
public class PurchaseInputOrderDTO {

    /**
     * id
     */
    private Long id;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 预期到达时间
     */
    private Date expectArrivalTime;
    /**
     * 实际到达时间
     */
    private Date arrivalTime;
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
     * 采购入库单备注
     */
    private String purchaseInputOrderComment;
    /**
     * 采购员
     */
    private String purchaser;
    /**
     * 采购入库单的状态
     */
    private Integer purcahseInputOrderStatus;
    /**
     * 采购入库单的创建时间
     */
    private Date gmtCreate;
    /**
     * 采购入库单的修改时间
     */
    private Date gmtModified;

}
