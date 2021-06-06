package com.shawnliang.eshop.cart.service.impl;

import com.shawnliang.eshop.cart.domain.ShoppingCartDO;
import com.shawnliang.eshop.cart.domain.ShoppingCartDTO;
import com.shawnliang.eshop.cart.domain.ShoppingCartItemDO;
import com.shawnliang.eshop.cart.domain.ShoppingCartItemDTO;
import com.shawnliang.eshop.cart.manager.ShoppingCartItemManager;
import com.shawnliang.eshop.cart.manager.ShoppingCartManager;
import com.shawnliang.eshop.cart.service.ShoppingCartService;
import com.shawnliang.eshop.commodity.domain.GoodsSkuDto;
import com.shawnliang.eshop.commodity.service.CommodityPropertyService;
import com.shawnliang.eshop.commodity.service.GoodsFacadeService;
import com.shawnliang.eshop.exceptions.BizException;
import com.shawnliang.eshop.inventory.service.InventoryFacadeService;
import com.shawnliang.eshop.promotion.domain.PromotionActivityDO;
import com.shawnliang.eshop.promotion.domain.PromotionActivityDTO;
import com.shawnliang.eshop.promotion.service.PromotionFacadeService;
import com.shawnliang.eshop.utils.BeanUtil;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/20
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartManager shoppingCartManager;

    @Autowired
    private ShoppingCartItemManager shoppingCartItemManager;

    @Autowired
    private GoodsFacadeService goodsFacadeService;

    @Autowired
    private InventoryFacadeService inventoryFacadeService;

    @Autowired
    private PromotionFacadeService promotionFacadeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addShoppingCartItem(Long userAccountId, Long goodsSkuId) {
        if (userAccountId == null || goodsSkuId == null) {
            throw new BizException("参数有误");
        }

        // 查看用户有无购物车，没有就创建一个
        ShoppingCartDO shoppingCartDO = shoppingCartManager.getByUserAccountId(userAccountId);
        if (shoppingCartDO == null) {
            shoppingCartDO = new ShoppingCartDO();

            shoppingCartDO.setUserAccountId(userAccountId);
            shoppingCartManager.save(shoppingCartDO);
        }

        ShoppingCartItemDO shoppingCartItemDO = shoppingCartItemManager
                .getByCartIdAndGoodsSkuId(shoppingCartDO.getId(), goodsSkuId);
        ShoppingCartItemDO entity = new ShoppingCartItemDO();
        if (shoppingCartItemDO == null) {
            entity.setGoodsSkuId(goodsSkuId);
            entity.setShoppingCartId(shoppingCartDO.getId());
            entity.setPurchaseQuantity(1L);
        } else {
            entity.setId(shoppingCartItemDO.getId());
            entity.setPurchaseQuantity(shoppingCartItemDO.getPurchaseQuantity() + 1);
        }

        shoppingCartItemManager.saveOrUpdate(entity);
    }

    @Override
    public ShoppingCartDTO getByUserAccountId(Long userAccountId) {
        // 根据用户Id 查询购物车
        ShoppingCartDO shoppingCartDO = shoppingCartManager.getByUserAccountId(userAccountId);

        if (shoppingCartDO == null) {
            return new ShoppingCartDTO();
        }

        ShoppingCartDTO shoppingCartDTO = BeanUtil.copyPropertiesJson(shoppingCartDO, ShoppingCartDTO.class);

        // 查询购物车中明细的数据
        List<ShoppingCartItemDO> shoppingCartItemDOS = shoppingCartItemManager.listByShopCartId(shoppingCartDTO.getId());
        if (CollectionUtils.isEmpty(shoppingCartItemDOS)) {
            return shoppingCartDTO;
        }

        List<ShoppingCartItemDTO> shoppingCartItemDTOList = Lists.newArrayList();

        for (ShoppingCartItemDO shoppingCartItemDO : shoppingCartItemDOS) {
            ShoppingCartItemDTO shoppingCartItemDTO = BeanUtil.copyPropertiesJson(shoppingCartItemDO, ShoppingCartItemDTO.class);

            // 给购物车商品条目填充属性
            GoodsSkuDto goodsSkuDto = goodsFacadeService.getGoodsSkuById(shoppingCartItemDTO.getGoodsSkuId());
            if (goodsSkuDto != null) {
                shoppingCartItemDTO.setGoodsId(goodsSkuDto.getGoodsId());
                shoppingCartItemDTO.setGoodsLength(goodsSkuDto.getGoodsLength());
                shoppingCartItemDTO.setGoodsHeight(goodsSkuDto.getGoodsHeight());
                shoppingCartItemDTO.setGoodsName(goodsSkuDto.getGoodsName());
                shoppingCartItemDTO.setGoodsSkuCode(goodsSkuDto.getGoodsSkuCode());
                shoppingCartItemDTO.setSalePrice(goodsSkuDto.getSalePrice());
            }

            // 给购物车商品条目填充库存的属性
            Long saleStockQuantity = inventoryFacadeService
                    .getSaleStockQuantity(shoppingCartItemDTO.getGoodsSkuId());
            shoppingCartItemDTO.setSaleStockQuantity(saleStockQuantity);

            // 给购物车填充商品促销的属性
            List<PromotionActivityDTO> promotionActivityDTOList = promotionFacadeService
                    .listPromotionActivitiesByGoodsId(shoppingCartItemDTO.getGoodsId());
            shoppingCartItemDTO.setPromotionActivityDTOList(promotionActivityDTOList);

            // 最后添加到集合中
            shoppingCartItemDTOList.add(shoppingCartItemDTO);
        }

        shoppingCartDTO.setShoppingCartItemDTOList(shoppingCartItemDTOList);

        return shoppingCartDTO;
    }
}
