package com.apollo.isBalanced;

import com.apollo.TreeNode;

public class IsBalanced {
    private boolean isBalanced = true;

    // 1.递归(自下而上)
    // 时间复杂度: O(n)
    // 空间复杂度: 先行列表: O(n) 平衡二叉树: O(log2(n))
    public boolean isBalanced(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return true;
        }

        // 1.左右树高差
        maxDepth(root);

        return isBalanced;
    }


    private int maxDepth(TreeNode root) {
        // 0.递归终点
        if (root == null) {
            return 0;
        }
        // 1.左右数的长度
        int leftHigh = maxDepth(root.left);
        int rightHigh = maxDepth(root.right);

        // 2.判断当前树 是否为平衡二叉树
        if (Math.abs(leftHigh - rightHigh) > 1) {
            isBalanced = false;
        }

        return Math.max(leftHigh, rightHigh) + 1;
    }

    // 2.递归(自顶而下)
    // 时间复杂度: O(nlog2(n)) n个节点 操作子节点log2(n)
    // 空间复杂度: 线性链表O(N)
    // 缺点: height多次计算
    public boolean isBalanced02(TreeNode root) {
        // 0.递归终止条件
        if (root == null) {
            return true;
        }
        // 1.递归
        // 平衡二叉树的条件:
        // i.左右子树的高度差, 小于等于1
        // ii.左右子树都是平衡二叉树
        return (Math.abs(height(root.left) - height(root.right)) < 2) && isBalanced02(root.left) && isBalanced02(root.right);

    }

    // 计算树的长度
    private int height(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.返回当前节点树的高度
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // 3.递归(自下而上)
    // 时间复杂度: O(n)
    // 空间复杂度: 平衡二叉树:O(log2(n)) 线性链表: O(n)
    public boolean isBalanced03(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return true;
        }
        // 1.根据长度判断是不是平衡二叉树
        return recur(root) != -1;

    }

    private int recur(TreeNode root) {
        // 0.递归终止条件
        if (null == root) {
            return 0;
        }
        // 1.判断左右子树是不是平衡二叉树并获取长度
        int leftHigh = recur(root.left);
        // 不是平衡二叉树
        if (leftHigh == -1) {
            return -1;
        }
        int rightHigh = recur(root.right);
        if (rightHigh == -1) {
            return -1;
        }
        // 2.根据左右子树长度判断当前树是不是平衡二叉树
        return Math.abs(leftHigh - rightHigh) < 2 ? Math.max(leftHigh, rightHigh) + 1 : -1;
    }


}
