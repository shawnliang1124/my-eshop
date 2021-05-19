package com.shawnliang.eshop.auth.visitor;

import com.shawnliang.eshop.auth.domain.PriorityNode;

/**
 * Description :   .
 *权限树接待你的访问者接口
 * @author : Phoebe
 * @date : Created in 2021/5/9
 */
public interface PriorityNodeVisitor {

    void visit(PriorityNode priorityNode);

}
