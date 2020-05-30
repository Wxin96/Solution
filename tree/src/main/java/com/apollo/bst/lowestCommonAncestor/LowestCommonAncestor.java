package com.apollo.bst.lowestCommonAncestor;

import com.apollo.TreeNode;

/**
 *  235.二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    // 1.递归法
    // 时间复杂度: O(h)  h:树的高度
    // 空间复杂度: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1.p值和q值都小于当前节点的值
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 2.p值和q值都大于当前节点的值
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 3.p值和q值在之间存在当前节点的值(闭区间)
        // 优化, 排除以上两种情况, 只剩第三种情况
/*        if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
            return root;
        }*/
        return root;
    }

    // 2.迭代法
    // 思想: 根据值的关系, 遍历, 无序使用栈和队列
    // 时间复杂度: O(h) h:树的高度
    // 空间复杂度: O(1)
}
