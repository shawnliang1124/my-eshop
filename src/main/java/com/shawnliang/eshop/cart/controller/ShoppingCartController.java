package com.shawnliang.eshop.cart.controller;

import com.shawnliang.eshop.cart.domain.ShoppingCartVO;
import com.shawnliang.eshop.cart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/20
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 增加购物车
     * @param shoppingCartVO
     */
    @PostMapping("add-item")
    public void addShoppingItem(ShoppingCartVO shoppingCartVO) {
        shoppingCartService.addShoppingCartItem(shoppingCartVO.getUserAccountId()
                , shoppingCartVO.getGoodsSkuId());
    }

}
