package com.shawnliang.eshop.cart.controller;

import com.shawnliang.eshop.cart.domain.ShoppingCartDTO;
import com.shawnliang.eshop.cart.domain.ShoppingCartItemDTO;
import com.shawnliang.eshop.cart.domain.ShoppingCartItemVO;
import com.shawnliang.eshop.cart.domain.ShoppingCartVO;
import com.shawnliang.eshop.cart.service.ShoppingCartService;
import com.shawnliang.eshop.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/view/{userAccountId}")
    public ShoppingCartVO viewByUserAccountId(@PathVariable("userAccountId") Long userAccountId) {
        ShoppingCartDTO shoppingCartDTO = shoppingCartService
                .getByUserAccountId(userAccountId);

        if (shoppingCartDTO == null) {
            return new ShoppingCartVO();
        }

        List<ShoppingCartItemDTO> shoppingCartItemDTOList =
                shoppingCartDTO.getShoppingCartItemDTOList();
        List<ShoppingCartItemVO> shoppingCartItemVOS = BeanUtil
                .copyPropertiesJson(shoppingCartItemDTOList, ShoppingCartItemVO.class);

        // 设置vo的明细
        ShoppingCartVO shoppingCartVO = BeanUtil.copyPropertiesJson(shoppingCartDTO, ShoppingCartVO.class);
        shoppingCartVO.setShoppingCartItemVOS(shoppingCartItemVOS);
        return shoppingCartVO;
    }

}
