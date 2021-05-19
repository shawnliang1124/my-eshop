package com.shawnliang.eshop.auth.visitor;

import com.shawnliang.eshop.auth.domain.PriorityDO;
import com.shawnliang.eshop.auth.domain.PriorityNode;
import com.shawnliang.eshop.auth.manager.PriorityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import utils.BeanUtil;

/**
 * Description 权限树节点的关联检查访问者 :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/9
 */
public class PriorityRelateCheckVisitor implements PriorityNodeVisitor{

    private Boolean relateCheckResult;

    @Autowired
    private PriorityManager priorityManager;

    @Override
    public void visit(PriorityNode node) {
        List<PriorityDO> priorityDOs = priorityManager
                .listChildPriorities(node.getId());
        if (!CollectionUtils.isEmpty(priorityDOs)) {
            for (PriorityDO priorityDO : priorityDOs) {
                PriorityNode priorityNode = BeanUtil
                        .copyPropertiesJson(priorityDO, PriorityNode.class);
                // 递归查询所有的子节点
                priorityNode.accept(this);
            }
        }
    }

    private Boolean relateCheck() {
        return null;
    }
}
