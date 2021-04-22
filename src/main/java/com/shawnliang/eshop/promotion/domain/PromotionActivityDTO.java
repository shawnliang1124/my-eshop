package com.shawnliang.eshop.promotion.domain;

import java.util.Date;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
@Data
public class PromotionActivityDTO {

    /**
     * id
     */
    private Long id;
    /**
     * 促销活动名称
     */
    private String promotionActivityName;
    /**
     * 促销活动开始时间
     */
    private Date promotionActivityStartTime;
    /**
     * 促销活动结束时间
     */
    private Date promotionActivityEndTime;
    /**
     * 促销活动备注
     */
    private String promotionActivityComment;
    /**
     * 促销活动状态
     */
    private Integer promotionActivityStatus;
    /**
     * 促销活动规则
     */
    private String promotionActivityRule;
    /**
     * 促销活动的创建时间
     */
    private Date gmtCreate;
    /**
     * 促销活动的修改时间
     */
    private Date gmtModified;

}
