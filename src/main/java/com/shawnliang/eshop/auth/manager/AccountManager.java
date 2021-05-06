package com.shawnliang.eshop.auth.manager;

import com.shawnliang.eshop.auth.domain.AccountDO;
import com.shawnliang.eshop.auth.dao.AccountMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 账号表，电商公司里一个员工就对应着一个账号，每个账号给分配多个角色，同时这个账号也可以给分配多个权限 Manager层
 * </p>
 *
 * @author shawnLiang
 * @since 2021-04-23
 */
@Repository
public class AccountManager extends ServiceImpl<AccountMapper, AccountDO>{

}
