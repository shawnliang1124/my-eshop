package com.shawnliang.eshop.auth.domain;

import com.shawnliang.eshop.auth.visitor.PriorityNodeVisitor;
import java.util.List;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/9
 */
@Data
public class PriorityNode {

    /**
     * id
     */
    private Long id;
    /**
     * 权限编号
     */
    private String code;
    /**
     * 权限URL
     */
    private String url;
    /**
     * 权限备注
     */
    private String priorityComment;
    /**
     * 权限类型
     */
    private Integer priorityType;
    /**
     * 父权限id
     */
    private Long parentId;

    private List<PriorityNode> children;

    public void accept(PriorityNodeVisitor priorityNodeVisitor) {
        priorityNodeVisitor.visit(this);
    }

}
