package com.apollo.maxDepth;

import com.apollo.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // 0.过滤/递归终点
        if (root == null) {
            return 0;
        }
        // 1.递归程序
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }
}
