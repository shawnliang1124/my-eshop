package com.shawnliang.eshop.auth.service.impl;

import com.shawnliang.eshop.auth.domain.PriorityDO;
import com.shawnliang.eshop.auth.domain.PriorityDTO;
import com.shawnliang.eshop.auth.manager.PriorityManager;
import com.shawnliang.eshop.auth.service.PriorityService;
import com.shawnliang.eshop.exceptions.BizException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.BeanUtil;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/23
 */
@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    private PriorityManager priorityManager;

    /**
     * 查询根权限的集合
     * @return
     */
    @Override
    public List<PriorityDTO> listRootProperties() {
        List<PriorityDO> priorityDOS = priorityManager.listRootPriorities();
        List<PriorityDTO> priorityDTOS = BeanUtil
                .copyPropertiesJson(priorityDOS, PriorityDTO.class);

        return priorityDTOS;
    }

    @Override
    public List<PriorityDTO> listChildPriorities(Long parentId) {
        Optional.ofNullable(parentId).orElseThrow(() ->
                new BizException("请输入正确的参数"));

        List<PriorityDO> priorityDOS = priorityManager.listChildPriorities(parentId);
        return BeanUtil.copyPropertiesJson(priorityDOS, PriorityDTO.class);
    }

    @Override
    public PriorityDTO getPriorityById(Long id) {
        Optional.ofNullable(id).orElseThrow(() ->
                new BizException("请输入正确的参数"));

        PriorityDO priorityDO = priorityManager.getPriorityById(id);
        return BeanUtil.copyPropertiesJson(priorityDO, PriorityDTO.class);
    }

    @Override
    public Long insertPriority(PriorityDTO priorityVO) {
        Optional.ofNullable(priorityVO).orElseThrow(() ->
                new BizException("请输入正确的参数"));

        PriorityDO priorityDO = BeanUtil.copyPropertiesJson(priorityVO, PriorityDO.class);
        boolean result = priorityManager
                .save(priorityDO);
        return result ? priorityDO.getId() : null;
    }

    @Override
    public Long updatePriority(PriorityDTO priorityVO) {
        Optional.ofNullable(priorityVO).orElseThrow(() ->
                new BizException("请输入正确的参数"));

        PriorityDO priorityDO = BeanUtil.copyPropertiesJson(priorityVO, PriorityDO.class);
        boolean result = priorityManager
                .save(priorityDO);
        return result ? priorityDO.getId() : null;
    }
}
