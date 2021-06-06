package com.shawnliang.eshop.inventory.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockDO;
import com.shawnliang.eshop.inventory.dao.InventoryGoodsStockMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 库存中心的商品库存表 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-21
 */
@Repository
public class InventoryGoodsStockManager extends ServiceImpl<InventoryGoodsStockMapper, InventoryGoodsStockDO>{

    /**
     * 查询sku对应的库存
     * @param goodsSkuId
     * @return
     */
    public InventoryGoodsStockDO getBySkuId(Long goodsSkuId) {
        LambdaQueryWrapper<InventoryGoodsStockDO> queryWrapper = new QueryWrapper<InventoryGoodsStockDO>()
                .lambda()
                .eq(InventoryGoodsStockDO::getGoodsSkuId, goodsSkuId);

        return this.baseMapper.selectOne(queryWrapper);
    }

}
