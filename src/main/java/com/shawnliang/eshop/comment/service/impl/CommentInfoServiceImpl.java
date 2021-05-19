package com.shawnliang.eshop.comment.service.impl;

import com.shawnliang.eshop.comment.constant.CommentStatus;
import com.shawnliang.eshop.comment.constant.CommentType;
import com.shawnliang.eshop.comment.constant.DefaultComment;
import com.shawnliang.eshop.comment.domain.CommentInfoDO;
import com.shawnliang.eshop.comment.domain.CommentInfoDTO;
import com.shawnliang.eshop.comment.manager.CommentInfoManager;
import com.shawnliang.eshop.comment.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentInfoManager commentInfoManager;

    @Override
    public Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO) {
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
}
