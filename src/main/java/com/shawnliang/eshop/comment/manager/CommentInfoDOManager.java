package com.shawnliang.eshop.auth.manager;

import com.shawnliang.eshop.auth.domain.CommentInfoDO;
import com.shawnliang.eshop.auth.dao.CommentInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 评论信息表 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-05-18
 */
@Repository
public class CommentInfoManager extends ServiceImpl<CommentInfoMapper, CommentInfoDO>{

}
