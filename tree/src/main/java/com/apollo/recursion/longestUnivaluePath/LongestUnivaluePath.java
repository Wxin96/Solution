package com.apollo.recursion.longestUnivaluePath;

import com.apollo.TreeNode;

public class LongestUnivaluePath {
    // 1.递归
    // 时间复杂度: O(n)  n:节点数目
    // 空间复杂度: O(h)  h:树的深度
    private int longestUnivaluePath = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longestUnivaluePath;
    }
    // 分清当前节点和上一级节点的区别
    // 分清边的个数
    private int dfs(TreeNode root) {
        // 0.递归截至
        if (root == null) {
            return 0;
        }

        // 1.左右节点相同
        int left = dfs(root.left);
        int right = dfs(root.right);

        // 2.判断是否有连续节点
        if (root.left != null) {
            left = (root.val == root.left.val) ? left + 1 : 0;
        }
        if (root.right != null) {
            right = (root.val == root.right.val) ? right + 1 : 0;
        }

        // 3.记录值
        // 当前值
        if (left+right > longestUnivaluePath) {
            longestUnivaluePath = left+right;
        }

        // 4.返回值
        // 给上一节点的值
        return Math.max(left, right);
    }

}
