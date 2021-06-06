package com.shawnliang.eshop.commodity.domain;

import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/19
 */
@Data
public class CommodityPropertyDTO {

    private Long id;

    /**
     * 属性名称
     */
    private String propertyName;

    /**
     * 属性描述
     */
    private String propertyDesc;

}
