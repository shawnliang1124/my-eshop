package com.shawnliang.eshop.comment.service;

import com.shawnliang.eshop.comment.domain.CommentInfoDTO;
import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.order.domain.OrderItemDTO;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
public interface CommentInfoService {

    /**
     * 手动保存评论
     * @param commentInfoDTO 评论DTO
     * @return
     */
    Boolean saveManualCommentInfo(CommentInfoDTO commentInfoDTO);

    /**
     * 自动保存评论
     * @param orderInfoDTO
     * @param orderItemDTO
     * @return
     */
    CommentInfoDTO saveAutoCommentInfo(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO);

}
