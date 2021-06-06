package com.shawnliang.eshop.wms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 * 采购入库单条目关联的上架条目
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-21
 */
@Data
public class WmsPurchaseInputPutOnItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购入库单条目ID
     */
    private Long purchaseInputOrderItemId;

    /**
     * 货位ID
     */
    private Long goodsAllocationId;

    /**
     * 上架数量
     */
    private Long putOnShelvesCount;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
