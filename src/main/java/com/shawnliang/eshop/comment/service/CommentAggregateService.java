package com.shawnliang.eshop.comment.service;

import com.shawnliang.eshop.comment.domain.CommentInfoDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
public interface CommentAggregateService {

    /**
     * 更新评论的统计信息
     * @param commentInfoDTO
     */
    void updateCommentAggregate(CommentInfoDTO commentInfoDTO);

}
