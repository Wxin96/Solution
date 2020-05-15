package com.apollo.recursion.sumOfLeftLeaves;

import com.apollo.TreeNode;

import java.util.Stack;

public class SumOfLeftLeaves {
    // 1.递归
    // 时间复杂度: O(n) n:树的节点数
    // 空间复杂度: O(h) h:树的深度
    // 难点: 如何判断是左节点
    // 1. 传参数
    // 2. 在父节点进行计算
    public int sumOfLeftLeaves(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.递归返回
        return sumOfLeftLeaves(root.left, true)
                + sumOfLeftLeaves(root.right, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeftNode) {
        // 0.递归终止
        if (root == null) {
            return 0;
        }
        // 1.是不是左节点
        int res = 0;
        if (isLeftNode && root.left==null && root.right==null) {
            res += root.val;
            return res;
        }
        // 2.递归
        res += sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        // 3.返回值
        return res;
    }
    // 2.迭代DFS
    // 时间复杂度: O(n) n:节点数目
    // 空间复杂度: O(h) h:树的深度
    public int sumOfLeftLeaves02(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.初始化数据
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;
        stack.push(root);

        // 2.开始迭代
        while (!stack.isEmpty()) {
            // a.数据出栈
            TreeNode curTreeNode = stack.pop();
            // b.进栈
            if (curTreeNode.left != null) {
                if (isLeaf(curTreeNode.left)) {
                    result += curTreeNode.left.val;
                } else {
                    stack.push(curTreeNode.left);
                }
            }
            if (curTreeNode.right != null) {
                stack.push(curTreeNode.right);
            }
        }


        return result;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left==null && root.right==null;
    }
}
