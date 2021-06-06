package com.shawnliang.eshop.cart.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shawnliang.eshop.cart.domain.ShoppingCartDO;
import com.shawnliang.eshop.cart.dao.ShoppingCartMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 购物车 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-20
 */
@Repository
public class ShoppingCartManager extends ServiceImpl<ShoppingCartMapper, ShoppingCartDO>{

    /**
     * 根据用户的账号查询购物车
     * @param userAccountId
     * @return
     */
    public ShoppingCartDO getByUserAccountId(Long userAccountId) {
        LambdaQueryWrapper<ShoppingCartDO> queryWrapper = new QueryWrapper<ShoppingCartDO>()
                .lambda()
                .eq(ShoppingCartDO::getUserAccountId, userAccountId);

        return this.baseMapper.selectOne(queryWrapper);
    }


}
