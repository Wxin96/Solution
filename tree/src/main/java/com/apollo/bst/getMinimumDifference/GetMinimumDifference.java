package com.apollo.bst.getMinimumDifference;

import com.apollo.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 *  通过中序遍历二叉搜索树得到的关键码序列是一个递增序列.
 *  这是二叉树搜索树的一个重要性质, 巧妙利用这一性质可以解决一系列二叉搜索树问题.
 *
 */
public class GetMinimumDifference {
    // 1.递归(中序遍历)
    // 时间复杂度: O(n)  n: 树的节点个数
    // 空间复杂度: O(h)  h: 树的高度
    private int minDiff = Integer.MAX_VALUE;
    private int preValue = -1;  // 题目所有点都为非负值
    public int getMinimumDifference(TreeNode root) {
        // 1.递归终止
        if (root == null) {
            return 0;
        }
        // 2.中序遍历
        // 左
        getMinimumDifference(root.left);
        // 中
        if (preValue != -1) {
            minDiff = Math.min(minDiff, Math.abs(root.val - preValue));
        }
        preValue = root.val;
        // 右
        getMinimumDifference(root.right);
        // 3.返回
        return minDiff;
    }

    // 2.DFS遍历(栈)
    // 时间复杂度: O(n)  n: 树的节点个数
    // 空间复杂度: O(h)  h: 树的高度

}
