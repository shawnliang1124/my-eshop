package com.shawnliang.eshop.auth.dao;

import com.shawnliang.eshop.auth.domain.AccountDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 账号表，电商公司里一个员工就对应着一个账号，每个账号给分配多个角色，同时这个账号也可以给分配多个权限 Mapper 接口
 * </p>
 *
 * @author shawnLiang
 * @since 2021-04-23
 */
public interface AccountMapper extends BaseMapper<AccountDO> {

}
