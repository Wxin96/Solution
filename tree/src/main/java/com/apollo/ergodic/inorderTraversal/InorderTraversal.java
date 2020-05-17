package com.apollo.ergodic.inorderTraversal;

import com.apollo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    // 1.迭代DFS
    public List<Integer> inorderTraversal(TreeNode root) {
        // 0.初始化
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curTreeNode = root;
        stack.add(root);
        // 1.过滤
        if (root == null) {
            return list;
        }
        // 2.迭代
        while (!stack.isEmpty()) {
            // a.查看栈顶节点
            // b.左添加节点到 节点为null
            while (curTreeNode != null && curTreeNode.left != null) {
                stack.push(curTreeNode.left);
                curTreeNode = curTreeNode.left;
            }

            // c.添加值
            TreeNode stackTop = stack.pop();
            list.add(stackTop.val);
            // d.添加右节点
            if (stackTop.right != null) {
                curTreeNode = stackTop.right;
                stack.push(curTreeNode);
            } else {
                curTreeNode = null;
            }

        }

        // 3.返回
        return list;
    }

    // 2.别人家的迭代
    public List<Integer> inorderTraversal02(TreeNode root) {
        // 0.数据初始化
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curTreeNode = root;    // 遍历节点
        // 1.过滤
        if (root == null) {
            return list;
        }
        // 2.迭代
        while (curTreeNode != null || !stack.isEmpty()) {
            // a.迭代到到没有左节点
            // 结束循环的curTreeNode为null
            while (curTreeNode != null) {
                stack.push(curTreeNode);
                curTreeNode = curTreeNode.left;
            }
            // b.弹出栈顶元素
            TreeNode node = stack.pop();
            list.add(node.val);
            curTreeNode = node.right;
        }

        // 3.返回
        return list;
    }

}
