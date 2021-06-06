package com.shawnliang.eshop.commodity.domain;

import java.util.Date;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
@Data
public class GoodsSkuDto {

    /**
     * id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品sku编号
     */
    private String goodsSkuCode;
    /**
     * 采购价格
     */
    private Double purchasePrice;
    /**
     * 销售价格
     */
    private Double salePrice;
    /**
     * 折扣价格
     */
    private Double discountPrice;

    /**
     * 商品的毛重
     */
    private Double goodsWeight;

    /**
     * 商品长度
     */
    private Double goodsLength;

    /**
     * 商品高度
     */
    private Double goodsHeight;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改文件
     */
    private Date gmtModified;

}
