package com.shawnliang.eshop.commodity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyDO;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyDTO;
import com.shawnliang.eshop.commodity.domain.CommodityPropertyQuery;
import com.shawnliang.eshop.commodity.manager.CommodityPropertyManager;
import com.shawnliang.eshop.commodity.service.CommodityPropertyService;
import java.util.List;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shawnliang.eshop.utils.BeanUtil;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/19
 */
@Service
public class CommodityPropertyServiceImpl implements CommodityPropertyService {

    @Autowired
    private CommodityPropertyManager commodityPropertyManager;

    @Override
    public IPage<CommodityPropertyDTO> findByPageAndQuery(CommodityPropertyQuery query) {
        Page<CommodityPropertyDO> page = new Page<>(query.getPage(),
                query.getSize());

        IPage<CommodityPropertyDO> result = commodityPropertyManager
                .findByPageAndQuery(page, query);
        IPage<CommodityPropertyDTO> pageResult = new Page<>();
        BeanUtils.copyProperties(result, pageResult);

        List<CommodityPropertyDTO> records = Lists.newArrayList();
        for (CommodityPropertyDO propertyDO : result.getRecords()) {
            CommodityPropertyDTO commodityPropertyDTO = BeanUtil
                    .copyPropertiesJson(propertyDO, CommodityPropertyDTO.class);

            records.add(commodityPropertyDTO);
        }

        return pageResult;
    }

    @Override
    public CommodityPropertyDTO findById(Long id) {
        CommodityPropertyDO commodityPropertyDO = commodityPropertyManager.getById(id);
        return BeanUtil.copyPropertiesJson(commodityPropertyDO, CommodityPropertyDTO.class);
    }

    @Override
    public void saveProperty(CommodityPropertyDTO commodityPropertyDTO) {
        commodityPropertyManager.save(BeanUtil
                .copyPropertiesJson(commodityPropertyDTO, CommodityPropertyDO.class));
    }

    @Override
    public void updateProperty(CommodityPropertyDTO commodityPropertyDTO) {
        commodityPropertyManager.updateById(BeanUtil
                .copyPropertiesJson(commodityPropertyDTO, CommodityPropertyDO.class));
    }
}
