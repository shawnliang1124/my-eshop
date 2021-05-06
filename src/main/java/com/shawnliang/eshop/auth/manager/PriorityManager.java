package com.shawnliang.eshop.auth.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shawnliang.eshop.auth.dao.PriorityDAO;
import com.shawnliang.eshop.auth.domain.PriorityDO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/23
 */
@Repository
public class PriorityManager extends ServiceImpl<PriorityDAO, PriorityDO> {

    /**
     * 查询所有的根权限
     * @return
     */
    public List<PriorityDO> listRootPriorities() {
        LambdaQueryWrapper<PriorityDO> queryWrapper = new QueryWrapper<PriorityDO>()
                .lambda()
                .eq(PriorityDO::getParentId, null);

        return this.baseMapper.selectList(queryWrapper);
    }


    /**
     * 根据父权限查询子权限
     * @param parentId
     * @return
     */
    public List<PriorityDO> listChildPriorities(Long parentId) {
        LambdaQueryWrapper<PriorityDO> queryWrapper = new QueryWrapper<PriorityDO>()
                .lambda()
                .eq(PriorityDO::getParentId, parentId);

        return this.baseMapper.selectList(queryWrapper);
    }


    /**
     * 根据ID 查询权限
     * @param id
     * @return
     */
    public PriorityDO getPriorityById(Long id) {
        LambdaQueryWrapper<PriorityDO> queryWrapper = new QueryWrapper<PriorityDO>()
                .lambda()
                .eq(PriorityDO::getId, id)
                .last("limit 1");

        return this.baseMapper.selectOne(queryWrapper);
    }


}
