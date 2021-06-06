package com.shawnliang.eshop.cart.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shawnliang.eshop.cart.domain.ShoppingCartItemDO;
import com.shawnliang.eshop.cart.dao.ShoppingCartItemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 购物车的商品条目 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-20
 */
@Repository
public class ShoppingCartItemManager extends ServiceImpl<ShoppingCartItemMapper, ShoppingCartItemDO>{

    /**
     * 根据 购物车Id + 商品skuId 查询购物车条目
     * @param shoppingCartId
     * @param goodsSkuId
     * @return
     */
    public ShoppingCartItemDO getByCartIdAndGoodsSkuId(Long shoppingCartId, Long goodsSkuId) {
        LambdaQueryWrapper<ShoppingCartItemDO> queryWrapper = new QueryWrapper<ShoppingCartItemDO>()
                .lambda()
                .eq(ShoppingCartItemDO::getShoppingCartId, shoppingCartId)
                .eq(ShoppingCartItemDO::getGoodsSkuId, goodsSkuId);

        return this.baseMapper.selectOne(queryWrapper);
    }

}
