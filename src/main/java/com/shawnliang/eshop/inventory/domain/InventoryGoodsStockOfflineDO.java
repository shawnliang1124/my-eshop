package com.shawnliang.eshop.inventory.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 库存中心离线信息存储表
 * </p>
 *
 * @author shawnLiang
 * @since 2021-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InventoryGoodsStockOfflineDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String msgId;

    private Integer operation;

    private String parameter;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

}
