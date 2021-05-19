package com.shawnliang.eshop.comment.service.impl;

import com.shawnliang.eshop.comment.domain.CommentPictureDO;
import com.shawnliang.eshop.comment.manager.CommentPictureManager;
import com.shawnliang.eshop.comment.properties.BizCommentProperties;
import com.shawnliang.eshop.comment.service.CommentPicService;
import java.io.File;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
@Service
@Slf4j
public class CommentPicServiceImpl implements CommentPicService {

    @Autowired
    private CommentPictureManager commentPictureManager;

    @Autowired
    private BizCommentProperties bizCommentProperties;

    @Override
    public void saveCommentPictures(String appBasePath, Long commentInfoId, MultipartFile[] files) {
        String picUpload = bizCommentProperties.getPic().getPicUpload();
        picUpload = picUpload + appBasePath;

        try {
            File uploadDir  = new File(picUpload);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            for (MultipartFile file : files) {
                if (file == null) {
                    continue;
                }

                String targetFilePath = picUpload + file.getOriginalFilename();
                File targetFile = new File(targetFilePath);

                // 如果文件存在，则需要删除文件
                if (targetFile.exists()) {
                    targetFile.delete();
                }

                // 将上传的文件存到对应的文件夹中
                file.transferTo(targetFile);

                // 将评论晒图信息保存到数据库中去
                CommentPictureDO commentPictureDO = new CommentPictureDO();
                commentPictureDO.setCommentInfoId(commentInfoId);
                commentPictureDO.setCommentPicturePath(targetFilePath);
                commentPictureDO.setGmtCreate(LocalDateTime.now());

                // 保存到数据库中
                commentPictureManager.save(commentPictureDO);
            }
        } catch (Exception e) {
            log.error("上传图片发生异常", e);

        }

    }
}
