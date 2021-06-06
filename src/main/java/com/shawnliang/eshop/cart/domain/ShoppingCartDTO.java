package com.shawnliang.eshop.cart.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-20
 */
@Data
public class ShoppingCartDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 会员账号ID
     */
    private Long userAccountId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

}
