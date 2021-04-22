package com.shawnliang.eshop.order.domain;

import java.util.Date;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
@Data
public class OrderDto {

    /**
     * id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 用户账号id
     */
    private Long userAccountId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 收货地址
     */
    private String deliveryAddress;
    /**
     * 收货人手机号码
     */
    private String consigneeCellPhoneNumber;
    /**
     * 运费
     */
    private Double freight;
    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 订单总金额
     */
    private Double totalAmount;
    /**
     * 折扣金额
     */
    private Double discountAmount;
    /**
     * 优惠券抵扣金额
     */
    private Double couponAmount;
    /**
     * 应付金额
     */
    private Double payableAmount;
    /**
     * 发票抬头
     */
    private String invoiceTitle;
    /**
     * 纳税人识别号
     */
    private String taxpayerId;
    /**
     * 订单备注
     */
    private String orderComment;
    /**
     * 销售出库单的创建时间
     */
    private Date gmtCreate;
    /**
     * 销售出库单的修改时间
     */
    private Date gmtModified;

}
