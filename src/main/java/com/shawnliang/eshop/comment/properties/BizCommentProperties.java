package com.shawnliang.eshop.comment.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
@Data
@Component
@ConfigurationProperties("biz.comment")
public class BizCommentProperties {

    private Pic pic = new Pic();

    @Data
    public static class Pic {
        private String picUpload;
    }

}
