package com.shawnliang.eshop.inventory.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shawnliang.eshop.inventory.domain.InventoryGoodsStockOfflineDO;
import com.shawnliang.eshop.inventory.dao.InventoryGoodsStockOfflineMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 库存中心离线信息存储表 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-06-17
 */
@Repository
public class InventoryGoodsStockOfflineManager extends ServiceImpl<InventoryGoodsStockOfflineMapper, InventoryGoodsStockOfflineDO>{

    /**
     * 获取离线消息的数量
     * @return
     */
    public Integer countOfflineMsg() {
        LambdaQueryWrapper<InventoryGoodsStockOfflineDO> lambda = new QueryWrapper<InventoryGoodsStockOfflineDO>()
                .lambda();

        return this.baseMapper.selectCount(lambda);
    }

    /**
     * 批量查询消息的数量
     * @param size
     * @return
     */
    public List<InventoryGoodsStockOfflineDO> listBySize(Integer size) {
        LambdaQueryWrapper<InventoryGoodsStockOfflineDO> lambda = new QueryWrapper<InventoryGoodsStockOfflineDO>()
                .lambda()
                .last("LIMIT " + size);

        return this.baseMapper.selectList(lambda);
    }

    public List<Long> findIdInMsgIds(List<String> msgIds) {
        LambdaQueryWrapper<InventoryGoodsStockOfflineDO> queryWrapper = new QueryWrapper<InventoryGoodsStockOfflineDO>()
                .lambda()
                .select(InventoryGoodsStockOfflineDO::getId)
                .in(InventoryGoodsStockOfflineDO::getMsgId, msgIds);
        List<InventoryGoodsStockOfflineDO> inventoryGoodsStockOfflineDOList = this.baseMapper
                .selectList(queryWrapper);

        return inventoryGoodsStockOfflineDOList.stream().map(InventoryGoodsStockOfflineDO::getId)
                .collect(Collectors.toList());
    }
}
