package com.shawnliang.eshop.wms.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 退货入库单条目DTO
 * @author zhonghuashishan
 *
 */
@Data
public class ReturnGoodsInputOrderItemDTO {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 退货入库单id
	 */
	private Long returnGoodsInputOrderId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 商品sku编号
	 */
	private String goodsSkuCode;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品sku的销售属性
	 */
	private String saleProperties;
	/**
	 * 商品毛重
	 */
	private Double goodsGrossWeight;
	/**
	 * 商品sku购买数量
	 */
	private Long purchaseQuantity;
	/**
	 * 商品sku购买价格
	 */
	private Double purchasePrice;
	/**
	 * 商品sku使用的促销活动id
	 */
	private Long promotionActivityId;
	/**
	 * 商品长度
	 */
	private Double goodsLength;
	/**
	 * 商品宽度
	 */
	private Double goodsWidth;
	/**
	 * 商品高度
	 */
	private Double goodsHeight;
	/**
	 * 退货商品到货后质检出来的合格商品数量
	 */
	private Long qualifiedCount;
	/**
	 * 退货商品的实际到货数量
	 */
	private Long arrivalCount;
	/**
	 * 退货入库单条目的创建时间
	 */
	private LocalDateTime gmtCreate;
	/**
	 * 退货入库单条目的修改时间
	 */
	private LocalDateTime gmtModified;
	

}
