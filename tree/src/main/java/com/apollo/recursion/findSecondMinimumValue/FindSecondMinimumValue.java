package com.apollo.recursion.findSecondMinimumValue;

import com.apollo.TreeNode;

public class FindSecondMinimumValue {
    // 1.递归
    // 时间复杂度: O(n)  n:节点个数
    // 空间复杂度: O(h)  h:树的高度
    // 思考:
    // 递归最小单位: /\ 三个节点的二叉树
    // 对于这个递归最小单位, 我们获取左右子节点的值.
    // 左右子节点都不等于根节点, 由题意知道, 大于根节点, 我们能得到递归结果了, 无需继续递归了
    // 如果有子节点等于根节点, 说明存在未知, 需要继续递归
    // 递归回溯判断左右节点的值, 是否是-1
    public int findSecondMinimumValue(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return -1;
        }
        // 没有子节点了
        if (root.left == null) {
            return -1;
        }
        // 1.当前值
        int leftNodeValue = root.left.val;
        int rightNodeValue = root.right.val;

        // 2.判断左右节点和根节点的关系, 进而需不需要进一步递归
        if (leftNodeValue == root.val) {
            leftNodeValue = findSecondMinimumValue(root.left);
        }
        if (rightNodeValue == root.val) {
            rightNodeValue = findSecondMinimumValue(root.right);
        }

        // 3.如果左右都不是-1
        if (leftNodeValue != -1 && rightNodeValue != -1) {
            return Math.min(leftNodeValue, rightNodeValue);
        }
        if (leftNodeValue != -1) {
            return leftNodeValue;
        }
        return rightNodeValue;

    }


}
