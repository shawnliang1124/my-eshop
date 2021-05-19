package com.shawnliang.eshop.auth.service;

import com.shawnliang.eshop.auth.domain.PriorityDTO;
import java.util.List;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/23
 */
public interface PriorityService {

    /**
     * 查询根权限的集合
     * @return
     */
    List<PriorityDTO> listRootProperties();

    /**
     * 根据父权限查询子权限
     * @param parentId
     * @return
     */
    List<PriorityDTO> listChildPriorities(Long parentId);

    /**
     * 根据ID 查询权限
     * @param id
     * @return
     */
    PriorityDTO getPriorityById(Long id);

    /**
     * 新增权限
     * @param priorityVO
     * @return
     */
    Long insertPriority(PriorityDTO priorityVO);

    /**
     * 更新权限'
     * @param priorityVO
     * @return
     */
    Long updatePriority(PriorityDTO priorityVO);
}
