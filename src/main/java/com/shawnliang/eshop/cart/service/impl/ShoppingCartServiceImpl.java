package com.shawnliang.eshop.cart.service.impl;

import com.shawnliang.eshop.cart.domain.ShoppingCartDO;
import com.shawnliang.eshop.cart.domain.ShoppingCartItemDO;
import com.shawnliang.eshop.cart.manager.ShoppingCartItemManager;
import com.shawnliang.eshop.cart.manager.ShoppingCartManager;
import com.shawnliang.eshop.cart.service.ShoppingCartService;
import com.shawnliang.eshop.exceptions.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
