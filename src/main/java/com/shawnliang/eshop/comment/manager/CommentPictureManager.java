package com.shawnliang.eshop.comment.manager;

import com.shawnliang.eshop.comment.domain.CommentPictureDO;
import com.shawnliang.eshop.auth.dao.CommentPictureMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 评论的晒图 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-18
 */
@Repository
public class CommentPictureManager extends ServiceImpl<CommentPictureMapper, CommentPictureDO>{

}
