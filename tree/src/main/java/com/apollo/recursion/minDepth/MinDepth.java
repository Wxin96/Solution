package com.apollo.recursion.minDepth;

import com.apollo.TreeNode;

public class MinDepth {
    // 1.递归
    // 时间复杂度: O(n)  n: 树节点的个数
    // 空间复杂度: O(n) O(log2(n))   与树的深度有关
    public int minDepth(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.当前节点最小深度
        int leftHigh = minDepth(root.left);
        int rightHigh = minDepth(root.right);

        // 2.判断叶节点
        if (leftHigh == 0) {
            return rightHigh + 1;
        } else if (rightHigh == 0) {
            return leftHigh + 1;
        } else {
            return Math.min(leftHigh, rightHigh) + 1;
        }
    }

    // 2.递归(改良)
    // 一个意思, 标准答案处理的更好
    public int minDepth02(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth02(root.left);
        int right = minDepth02(root.right);
        if (left == 0 || right == 0) return left + right + 1;
        return Math.min(left, right) + 1;
    }
}
