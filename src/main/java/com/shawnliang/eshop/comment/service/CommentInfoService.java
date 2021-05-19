package com.shawnliang.eshop.comment.service;

import com.shawnliang.eshop.comment.domain.CommentInfoDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
public interface CommentService {

    /**
     * 保存评论
     * @param commentInfoDTO 评论DTO
     * @return
     */
    Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO);

}
