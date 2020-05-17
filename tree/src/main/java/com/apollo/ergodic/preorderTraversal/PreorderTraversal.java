package com.apollo.ergodic.preorderTraversal;

import com.apollo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 */
public class PreorderTraversal {
    // 1.DFS迭代算法
    // 时间复杂度: O(n)  n:节点个数
    // 空间复杂度: O(n)  n:节点个数 list和stack
    public List<Integer> preorderTraversal(TreeNode root) {
        // 0.过滤
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 1.初始化数据结构
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 2.迭代
        while (!stack.isEmpty()) {
            // a.出栈
            TreeNode curTreeNode = stack.pop();
            list.add(curTreeNode.val);

            // b.进栈
            // 右节点先进栈
            if (curTreeNode.right != null) {
                stack.push(curTreeNode.right);
            }
            if (curTreeNode.left != null) {
                stack.push(curTreeNode.left);
            }
        }

        return list;

    }

    // 2.递归
    // 时间复杂度: O(n)  n:节点个数
    // 空间复杂度: O(h)  h:h的深度
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal02(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return list;
        }

        // 1.添加值
        list.add(root.val);
        // 2.左递归
        preorderTraversal02(root.left);
        // 3.右递归
        preorderTraversal02(root.right);

        return list;
    }


}
