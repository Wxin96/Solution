package com.apollo.recursion.diameterOfBinaryTree;

import com.apollo.TreeNode;

/**
 * 二叉树的直径
 *  时间复杂度: O(n)
 *  空间复杂度:
 *      O(Height)，其中 HeightHeight 为二叉树的高度
 *      O(n) n为线性链表 O(log2(n)) n为平衡二叉树
 */
public class DiameterOfBinaryTree {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.递归寻找最大直径
        treeDepth(root);

        // 2.返回最大直径
        return diameter;
    }

    // 左右子树的长度
    private int treeDepth(TreeNode root) {
        // 0.递归终止
        if (root == null) {
            return 0;
        }
        // 1.左右子树的长度
        int leftHigh = treeDepth(root.left);
        int rightHigh = treeDepth(root.right);

        // 2.获取当前节点的直径
        diameter = Math.max(leftHigh + rightHigh, diameter);
        // 3.返回树的长度
        return Math.max(leftHigh, rightHigh) + 1;

    }

}
