package com.shawnliang.eshop.comment.controller;

import com.shawnliang.eshop.comment.constant.ShowPictures;
import com.shawnliang.eshop.comment.domain.CommentInfoDTO;
import com.shawnliang.eshop.comment.domain.CommentInfoVO;
import com.shawnliang.eshop.comment.service.CommentAggregateService;
import com.shawnliang.eshop.comment.service.CommentInfoService;
import com.shawnliang.eshop.comment.service.CommentPicService;
import com.shawnliang.eshop.membership.service.MembershipFacadeService;
import com.shawnliang.eshop.order.service.OrderFacadeService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.shawnliang.eshop.utils.BeanUtil;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentInfoService commentInfoService;

    @Autowired
    private CommentPicService commentPicService;

    @Autowired
    private CommentAggregateService commentAggregateService;

    @Autowired
    private OrderFacadeService orderFacadeService;

    @Autowired
    private MembershipFacadeService membershipFacadeService;

    /**
     * 手动发表评论
     * @param commentInfoVO 评论信息VO对象
     * @return 处理结果
     */
    @PostMapping("/")
    @Transactional(rollbackFor = Exception.class)
    public void publishComment(HttpServletRequest request,
            CommentInfoVO commentInfoVO, MultipartFile[] files) {
        Integer showPicture = ShowPictures.NO;
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                if (file != null) {
                    showPicture = ShowPictures.YES;
                    break;
                }
            }
        }

        // 保存评论的内容
        commentInfoVO.setIsShowPictures(showPicture);
        CommentInfoDTO commentInfoDTO = BeanUtil
                .copyPropertiesJson(commentInfoVO, CommentInfoDTO.class);
        commentInfoService.saveManualCommentInfo(commentInfoDTO);

        // 上传评论晒图图片
        String appBasePath = request.getSession().getServletContext().getRealPath("/");
        commentPicService.saveCommentPictures(appBasePath, commentInfoDTO.getId(), files);

        // 更新评论统计信息
        commentAggregateService.updateCommentAggregate(commentInfoDTO);

        orderFacadeService.informPublishCommentEvent(commentInfoDTO.getOrderInfoId());

        membershipFacadeService.informPublishCommentEvent(commentInfoDTO.getUserAccountId(),
                commentInfoDTO.getIsShowPictures());
    }

}
