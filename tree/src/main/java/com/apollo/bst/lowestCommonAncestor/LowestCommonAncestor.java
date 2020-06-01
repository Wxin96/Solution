package com.apollo.bst.lowestCommonAncestor;

import com.apollo.TreeNode;

/**
 *  235.二叉搜索树的最近公共祖先
 *  题目给的条件:
 *      1.树 是 二叉搜索树
 *      2.题目说明:
 *          a.所有节点的值都是唯一的
 *          b.p、q为不同节点且均存在于给定的二叉搜索树中
 *  综上, 此处在考察BST的性质, 左子节点的值小于根节点的值, 右子节点的值大于根节点的值
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
    // 思想: 根据值的关系, 遍历, 无序使用栈和队列(这里我们不需要回溯, 可以一往无前的走[下]去)
    // 时间复杂度: O(h) h:树的高度
    // 空间复杂度: O(1)
}
