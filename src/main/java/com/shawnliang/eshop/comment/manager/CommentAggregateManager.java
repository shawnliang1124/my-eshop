package com.shawnliang.eshop.comment.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shawnliang.eshop.comment.domain.CommentAggregateDO;
import com.shawnliang.eshop.comment.dao.CommentAggregateMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 评论聚合汇总表 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-18
 */
@Repository
public class CommentAggregateManager extends ServiceImpl<CommentAggregateMapper, CommentAggregateDO>{


    public CommentAggregateDO getByGoodsId(Long goodsId) {
        LambdaQueryWrapper<CommentAggregateDO> queryWrapper = new QueryWrapper<CommentAggregateDO>().lambda()
                .eq(CommentAggregateDO::getGoodsId, goodsId);

        return this.baseMapper.selectOne(queryWrapper);
    }

}
