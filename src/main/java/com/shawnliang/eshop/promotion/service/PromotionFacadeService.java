package com.shawnliang.eshop.promotion.service;

import com.shawnliang.eshop.promotion.domain.PromotionActivityDTO;
import java.util.List;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface PromotionFacadeService {


    /**
     * 根据商品id查询促销活动
     * @param goodsId 商品id
     * @return 促销活动
     */
    List<PromotionActivityDTO> listPromotionActivitiesByGoodsId(Long goodsId);


}
