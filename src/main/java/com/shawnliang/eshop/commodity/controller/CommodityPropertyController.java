package com.shawnliang.eshop.commodity.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyDTO;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyQuery;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyVO;
import com.shawnliang.eshop.commodity.service.CommodityPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.BeanUtil;

/**
 * Description :  商品控制器 .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/20
 */
@RestController
@RequestMapping("/commodity")
public class CommodityPropertyController {

    @Autowired
    private CommodityPropertyService commodityPropertyService;

    @GetMapping("/query")
    public IPage<CommodityPropertyDTO> findByPageAndQuery(CommodityPropertyQuery query) {
        return commodityPropertyService.findByPageAndQuery(query);
    }

    @GetMapping("/id")
    public CommodityPropertyDTO findById(Long id) {
        return commodityPropertyService.findById(id);
    }

    @PostMapping("/save")
    public void saveProperty(CommodityPropertyVO commodityPropertyVO) {
        commodityPropertyService.saveProperty(BeanUtil
                .copyPropertiesJson(commodityPropertyVO, CommodityPropertyDTO.class));
    }


    @PostMapping("/update")
    public void updateProperty(CommodityPropertyVO commodityPropertyVO) {
        commodityPropertyService.updateProperty(BeanUtil
                .copyPropertiesJson(commodityPropertyVO, CommodityPropertyDTO.class));
    }
}
