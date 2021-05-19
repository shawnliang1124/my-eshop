package com.shawnliang.eshop.comment.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
public interface CommentPicService {

    void saveCommentPictures(String appBasePath, Long commentInfoId, MultipartFile[] files);

}
