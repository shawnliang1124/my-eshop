package com.shawnliang.eshop.comment.manager;

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

}
