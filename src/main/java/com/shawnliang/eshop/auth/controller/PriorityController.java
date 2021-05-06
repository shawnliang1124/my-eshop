package com.shawnliang.eshop.auth.controller;

import com.shawnliang.eshop.auth.domain.PriorityDTO;
import com.shawnliang.eshop.auth.domain.PriorityVO;
import com.shawnliang.eshop.auth.service.PriorityService;
import com.shawnliang.eshop.common.ApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.BeanUtil;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/4/23
 */
@RestController
@RequestMapping("/auth/priority")
public class PriorityController {

    @Autowired
    private PriorityService priorityService;

    /**
     * 查询根权限的集合
     * @return
     */
    @GetMapping("/root")
    public ApiResponse<List<PriorityVO>> listRootProperties() {
        List<PriorityDTO> priorityDTOS = priorityService.listRootProperties();
        return new ApiResponse<>(BeanUtil.copyPropertiesJson(priorityDTOS, PriorityVO.class));
    }

    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     */
    @GetMapping("/child/{parentId}")
    public ApiResponse<List<PriorityVO>> listChildPriorities(@PathVariable("parentId") Long parentId) {
        List<PriorityDTO> priorityDTOS = priorityService.listChildPriorities(parentId);
        return new ApiResponse<>(BeanUtil.copyPropertiesJson(priorityDTOS, PriorityVO.class));
    }

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     */
    @GetMapping("/{id}")
    public ApiResponse<PriorityVO> getPriorityById(@PathVariable("id") Long id) {
        PriorityDTO priorityDTO = priorityService.getPriorityById(id);
        return new ApiResponse<>(BeanUtil.copyPropertiesJson(priorityDTO, PriorityVO.class));
    }

    /**
     * 新增权限
     * @param priorityVO 权限DO对象
     */
    @PostMapping("/")
    public ApiResponse savePriority(@RequestBody PriorityVO priorityVO) {
        priorityService.insertPriority(BeanUtil.copyPropertiesJson(priorityVO, PriorityDTO.class));
        return new ApiResponse();
    }

    /**
     * 更新权限
     * @param priorityVO 权限DO对象
     */
    @PostMapping("/id")
    public ApiResponse updatePriority(@RequestBody PriorityVO priorityVO) {
        priorityService.updatePriority(BeanUtil.copyPropertiesJson(priorityVO, PriorityDTO.class));
        return new ApiResponse();
    }

}
