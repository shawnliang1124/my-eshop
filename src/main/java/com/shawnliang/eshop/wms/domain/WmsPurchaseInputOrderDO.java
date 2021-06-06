package com.shawnliang.eshop.wms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * wms中心的采购入库单
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WmsPurchaseInputOrderDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 预计到货时间
     */
    private LocalDateTime expectArrivalTime;

    /**
     * 实际到货时间
     */
    private LocalDateTime arrivalTime;

    /**
     * 采购联系人
     */
    private String purchaseContactor;

    /**
     * 采购联系电话
     */
    private String purchaseContactPhoneNumber;

    /**
     * 采购联系邮箱
     */
    private String purchaseContactEmail;

    /**
     * 采购入库单的说明备注
     */
    private String purchaseInputOrderComment;

    /**
     * 采购员
     */
    private String purchaser;

    /**
     * 采购入库单状态，1：编辑中，2：待审核，3：已入库，4：待结算，5：已完成
     */
    private Integer purchaseInputOrderStatus;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
