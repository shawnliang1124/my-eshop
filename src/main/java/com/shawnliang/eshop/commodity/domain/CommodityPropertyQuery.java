package com.shawnliang.eshop.commodity.domain;

import lombok.Data;

/**
 * Description :  商品查询类 .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/19
 */
@Data
public class CommodityPropertyQuery {

    private Integer page;

    private Integer size;

    /**
     * 属性名称
     */
    private String propertyName;

    /**
     * 属性描述
     */
    private String propertyDesc;

}
