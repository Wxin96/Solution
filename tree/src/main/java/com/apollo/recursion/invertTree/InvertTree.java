package com.apollo.recursion.invertTree;

import com.apollo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    // 1.递归法
    // 时间复杂度: O(n)
    // 空间复杂度: O(h) h => 树的高度
    public TreeNode invertTree(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return null;
        }
        // 1.交换左右子树
        TreeNode leftTree = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(leftTree);

        // 2.返回树
        return root;
    }

    // 2.BFS
    // 时间复杂度: O(n)
    // 空间复杂度: O(width) 最宽一列同等级节点 O(n)
    public TreeNode invertTree02(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return null;
        }
        // 1.初始化
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 2.遍历
        while (!queue.isEmpty()) {
            // a.开始迭代交换
            for (int i = queue.size(); i > 0; i--) {
                // 当前节点
                TreeNode curTreeNode = queue.poll();
                // 交换左右子树
                TreeNode temp = curTreeNode.left;
                if (curTreeNode.right != null) {
                    queue.add(curTreeNode.right);
                }
                curTreeNode.left = curTreeNode.right;
                if (temp != null) {
                    queue.add(temp);
                }
                curTreeNode.right = temp;
            }
        }

        return root;

    }




}
