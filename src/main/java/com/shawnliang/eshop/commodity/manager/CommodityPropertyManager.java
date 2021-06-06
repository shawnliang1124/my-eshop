package com.shawnliang.eshop.commodity.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shawnliang.eshop.commodity.dao.CommodityPropertyMapper;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyDO;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品中心的属性表 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-19
 */
@Repository
public class CommodityPropertyManager extends ServiceImpl<CommodityPropertyMapper, CommodityPropertyDO>{

    /**
     * 分页查询商品属性
     * @param pageQuery
     * @param query
     * @return
     */
    public IPage<CommodityPropertyDO> findByPageAndQuery(Page<CommodityPropertyDO> pageQuery, CommodityPropertyQuery query) {
        LambdaQueryWrapper<CommodityPropertyDO> queryWrapper = new QueryWrapper<CommodityPropertyDO>()
                .lambda()
                .like(StringUtils.isNotBlank(query.getPropertyName()),
                        CommodityPropertyDO::getPropertyName, query.getPropertyName())
                .like(StringUtils.isNotBlank(query.getPropertyDesc()),
                        CommodityPropertyDO::getPropertyDesc, query.getPropertyDesc());

        return this.baseMapper.selectPage(pageQuery, queryWrapper);
    }

}
