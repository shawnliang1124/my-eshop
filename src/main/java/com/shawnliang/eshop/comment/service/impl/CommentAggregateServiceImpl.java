package com.shawnliang.eshop.comment.service.impl;

import com.shawnliang.eshop.comment.constant.CommentType;
import com.shawnliang.eshop.comment.constant.ShowPictures;
import com.shawnliang.eshop.comment.domain.CommentAggregateDO;
import com.shawnliang.eshop.comment.domain.CommentInfoDTO;
import com.shawnliang.eshop.comment.manager.CommentAggregateManager;
import com.shawnliang.eshop.comment.service.CommentAggregateService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.MathUtils;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
@Service
public class CommentAggregateServiceImpl implements CommentAggregateService {

    @Autowired
    private CommentAggregateManager aggregateManager;

    @Override
    public void updateCommentAggregate(CommentInfoDTO commentInfoDTO) {
        Long goodsId = commentInfoDTO.getGoodsId();

        CommentAggregateDO commentAggregateDO = aggregateManager.getByGoodsId(goodsId);
        // 如果商品id还没有对应的评论统计信息，则新增一条评论统计信息
        if (commentAggregateDO == null) {
            commentAggregateDO = new CommentAggregateDO();
            commentAggregateDO.setGoodsId(goodsId);
            commentAggregateDO.setTotalCommentCount(1L);

            // 根据评分设置好/中/差 评的数量
            if (commentInfoDTO.getCommentType().equals(CommentType.GOOD_COMMENT)) {
                commentAggregateDO.setGoodCommentCount(1L);
            } else if (commentInfoDTO.getCommentType().equals(CommentType.MEDIUM_COMMENT)) {
                commentAggregateDO.setMediumCommentCount(1L);
            } else if (commentInfoDTO.getCommentType().equals(CommentType.BAD_COMMENT)) {
                commentAggregateDO.setBadCommentCount(1L);
            }

            Double goodCommentRate = MathUtils.result(commentAggregateDO.getGoodCommentCount()
                    , commentAggregateDO.getTotalCommentCount());
            commentAggregateDO.setGoodCommentRate(new BigDecimal(goodCommentRate));

            if (commentInfoDTO.getIsShowPictures().equals(ShowPictures.YES)) {
                commentAggregateDO.setShowPicturesCommentCount(1L);
            }

            aggregateManager.save(commentAggregateDO);
        } else {
            commentAggregateDO.setTotalCommentCount(commentAggregateDO.getTotalCommentCount() + 1);
            // 根据评分设置好/中/差 评的数量
            if (commentInfoDTO.getCommentType().equals(CommentType.GOOD_COMMENT)) {
                commentAggregateDO.setGoodCommentCount(commentAggregateDO.getGoodCommentCount() + 1);
            } else if (commentInfoDTO.getCommentType().equals(CommentType.MEDIUM_COMMENT)) {
                commentAggregateDO.setMediumCommentCount(commentAggregateDO.getMediumCommentCount() + 1);
            } else if (commentInfoDTO.getCommentType().equals(CommentType.BAD_COMMENT)) {
                commentAggregateDO.setBadCommentCount(commentAggregateDO.getBadCommentCount() + 1);
            }

            if (commentInfoDTO.getIsShowPictures().equals(ShowPictures.YES)) {
                commentAggregateDO.setShowPicturesCommentCount(commentAggregateDO.getShowPicturesCommentCount() + 1);
            }

            aggregateManager.updateById(commentAggregateDO);
        }
    }
}
