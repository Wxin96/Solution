package com.apollo.recursion.hasPathSum;

import com.apollo.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

/**
 * 112. 路径总和
 */
public class HasPathSum {
    // 1. 初始版本
    // isEqual时没有必要的, 写代码时要分析是否冗余
    public boolean hasPathSum(TreeNode root, int sum) {
        // 0.过滤
        if (root == null) {
            return false;
        }
        // 1.判断当前节点是否相等
        boolean isEqual = (sum == root.val) && root.left == null && root.right == null;

        // 2.递归返回
        return isEqual || hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    // 2.官方答案
    // 时间复杂度: O(n) n: 节点数目
    // 空间复杂度: O(h) h: 树的高度
    public boolean hasPathSum02(TreeNode root, int sum) {
        // 0.过滤
        if (root == null) {
            return false;
        }
        // 1.判断当前节点是否相等
        if ((sum == root.val) && root.left == null && root.right == null) {
            return true;
        }

        // 2.递归返回
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // 3. 使用栈
    // 时间复杂度: O(n) n: 节点数目
    // 空间复杂度: O(h) h: 树的高度 最差情况平衡二叉树, 最好情况单链表O(1)
    public boolean hasPathSum03(TreeNode root, int sum) {
        // 0.过滤
        if (root == null) {
            return false;
        }

        // 1.初始化数据
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, sum));

        // 2.迭代
        while (!stack.isEmpty()) {
            // a.栈排出
            Pair<TreeNode, Integer> curPair = stack.pop();
            TreeNode curTreeNode = curPair.getKey();
            int curValue = curPair.getValue();
            if (curTreeNode.val==curValue && curTreeNode.left==null && curTreeNode.right==null) {
                return true;
            }
            if (curTreeNode.left != null) {
                stack.push(new Pair<>(curTreeNode.left, curValue - curTreeNode.val));
            }
            if (curTreeNode.right != null) {
                stack.push(new Pair<>(curTreeNode.right, curValue - curTreeNode.val));
            }

        }
        return false;

    }

}
