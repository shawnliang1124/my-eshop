package com.shawnliang.eshop.comment.service.impl;

import com.shawnliang.eshop.comment.constant.CommentStatus;
import com.shawnliang.eshop.comment.constant.CommentType;
import com.shawnliang.eshop.comment.constant.DefaultComment;
import com.shawnliang.eshop.comment.constant.ShowPictures;
import com.shawnliang.eshop.comment.domain.CommentInfoDO;
import com.shawnliang.eshop.comment.domain.CommentInfoDTO;
import com.shawnliang.eshop.comment.manager.CommentInfoManager;
import com.shawnliang.eshop.comment.service.CommentInfoService;
import com.shawnliang.eshop.order.domain.OrderInfoDTO;
import com.shawnliang.eshop.order.domain.OrderItemDTO;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.BeanUtil;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
@Service
@Slf4j
public class CommentInfoServiceImpl implements CommentInfoService {

    @Autowired
    private CommentInfoManager commentInfoManager;

    @Override
    public Boolean saveManualCommentInfo(CommentInfoDTO commentInfoDTO) {
        // 计算总分
        Integer totalScore = Math.round((commentInfoDTO.getCustomerServiceScore()
        + commentInfoDTO.getGoodsScore()
        + commentInfoDTO.getLogisticsScore()) / 3);

        commentInfoDTO.setIsDefaultComment(DefaultComment.NO);
        commentInfoDTO.setCommentStatus(CommentStatus.APPROVING);

        // 设置评论的类型
        Integer commentType = 0;
        if (totalScore > 4) {
            commentType = CommentType.GOOD_COMMENT;
        } else if (totalScore == 3) {
            commentType = CommentType.MEDIUM_COMMENT;
        } else if (totalScore > 0 && totalScore <= 2) {
            commentType = CommentType.BAD_COMMENT;
        }

        commentInfoDTO.setCommentType(commentType);

        // 设置时间
        LocalDateTime date = LocalDateTime.now();
        commentInfoDTO.setGmtCreate(date);
        commentInfoDTO.setGmtModified(date);

        CommentInfoDO commentInfoDO = BeanUtil
                .copyPropertiesJson(commentInfoDTO, CommentInfoDO.class);
        return commentInfoManager.save(commentInfoDO);
    }

    @Override
    public CommentInfoDTO saveAutoCommentInfo(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO) {
        CommentInfoDTO commentInfoDTO = createOrderInfo(orderInfoDTO, orderItemDTO);
        CommentInfoDO commentInfoDO = BeanUtil
                .copyPropertiesJson(commentInfoDTO, CommentInfoDO.class);

        // 保存到数据库中
        commentInfoManager.save(commentInfoDO);
        return commentInfoDTO;
    }

    private CommentInfoDTO createOrderInfo(OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO) {
        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();

        commentInfoDTO.setUserAccountId(orderInfoDTO.getUserAccountId());
        commentInfoDTO.setUsername(orderInfoDTO.getUsername());
        commentInfoDTO.setOrderInfoId(orderInfoDTO.getId());
        commentInfoDTO.setOrderInfoId(orderItemDTO.getId());
        commentInfoDTO.setGoodsId(orderItemDTO.getGoodsId());
        commentInfoDTO.setGoodsSkuId(orderItemDTO.getGoodsSkuId());
        commentInfoDTO.setGoodsSkuSaleProperties(orderItemDTO.getSaleProperties());
        commentInfoDTO.setTotalScore(5);
        commentInfoDTO.setGoodsScore(5);
        commentInfoDTO.setCustomerServiceScore(5);
        commentInfoDTO.setLogisticsScore(5);
        commentInfoDTO.setCommentContent("");
        commentInfoDTO.setIsShowPictures(ShowPictures.NO);
        commentInfoDTO.setIsDefaultComment(DefaultComment.YES);
        commentInfoDTO.setCommentStatus(CommentStatus.APPROVED);
        commentInfoDTO.setCommentType(CommentType.GOOD_COMMENT);
        commentInfoDTO.setGmtCreate(LocalDateTime.now());

        return commentInfoDTO;
    }
}
