package com.shawnliang.eshop.order.domain;

import java.util.Date;
import java.util.List;

/**
 * 订单信息DTO
 * @author zhonghuashishan
 *
 */
public class OrderInfoDTO {

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
	 * 用户名
	 */
	private String username;
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
	 * 是否发表了评论
	 */
	private Integer publishedComment;
	/**
	 * 确认收货时间
	 */
	private Date confirmReceiptTime;
	/**
	 * 销售出库单的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 销售出库单的修改时间
	 */
	private Date gmtModified;
	/**
	 * 订单包含的订单条目
	 */
	private List<OrderItemDTO> orderItems;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getConsigneeCellPhoneNumber() {
		return consigneeCellPhoneNumber;
	}
	public void setConsigneeCellPhoneNumber(String consigneeCellPhoneNumber) {
		this.consigneeCellPhoneNumber = consigneeCellPhoneNumber;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Double getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(Double couponAmount) {
		this.couponAmount = couponAmount;
	}
	public Double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getTaxpayerId() {
		return taxpayerId;
	}
	public void setTaxpayerId(String taxpayerId) {
		this.taxpayerId = taxpayerId;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	public Integer getPublishedComment() {
		return publishedComment;
	}
	public void setPublishedComment(Integer publishedComment) {
		this.publishedComment = publishedComment;
	}
	public Date getConfirmReceiptTime() {
		return confirmReceiptTime;
	}
	public void setConfirmReceiptTime(Date confirmReceiptTime) {
		this.confirmReceiptTime = confirmReceiptTime;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}

}
