package com.shawnliang.eshop.membership.service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/21
 */
public interface MembershipFacadeService {

    /**
     * 通知会员中心，“用户今日第一次登录”事件发生了
     * @param userAccountId 用户账号ID
     * @return 处理结果
     */
    Boolean informFirstLoginDailyEvent(Long userAccountId);

    /**
     * 通知会员中心，“支付订单”事件发生了
     * @param userAccountId 用户账号id
     * @param totalOrderAmount 订单总金额
     * @return 处理结果
     */
    Boolean informPayOrderEvent(Long userAccountId, Long totalOrderAmount);

    /**
     * 通知会员中心，“完成退货”事件发生了
     * @param userAccountId 用户账号id
     * @param totalOrderAmount 订单总金额
     * @return 处理结果
     */
    Boolean informFinishReturnGoodsEvent(Long userAccountId, Long totalOrderAmount);

    /**
     * 通知会员中心，“发表评论”事件发生了
     * @param userAccountId 用户账号id
     * @param showPictures 是否晒图
     * @return 处理结果
     */
    Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures);

    /**
     * 通知会员中心，“删除评论”事件发生了
     * @param userAccountId 用户账号id
     * @param showPictures 是否晒图
     * @return 处理结果
     */
    Boolean informRemoveCommentEvent(Long userAccountId, Boolean showPictures);


}
