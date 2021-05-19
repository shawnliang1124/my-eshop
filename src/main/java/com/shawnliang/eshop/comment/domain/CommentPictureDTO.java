package com.shawnliang.eshop.comment.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 * 评论的晒图
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-18
 */
@Data
public class CommentPictureDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 评论ID
     */
    private Long commentInfoId;

    /**
     * 图片顺序
     */
    private Integer sequence;

    /**
     * 晒图图片
     */
    private String commentPicturePath;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;


}
