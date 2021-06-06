package com.shawnliang.eshop.commodity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品中心的属性表
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommodityPropertyDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 属性名称
     */
    private String propertyName;

    /**
     * 属性描述
     */
    private String propertyDesc;

    /**
     * 输入方式，1：多选，2：输入
     */
    private Integer inputType;

    /**
     * 可选值范围，如果输入方式是可选，那么需要提供一些供选择的值范围
     */
    private String inputValues;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
