package com.apollo.ergodic.postorderTraversal;

import com.apollo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    // 1.迭代法
    // 时间复杂度: O(n)  n:树的节点个数
    // 空间复杂度: O(n)  n:树的节点个数 list和stack
    // 后序遍历: 左 -> 右 -> 根
    // 改造前序: 根 -> 右 -> 左
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 0.过滤
        if (root == null) {
            return list;
        }
        // 1.数据初始化
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        // 2.迭代
        while (!stack.isEmpty()) {
            // a.出栈
            TreeNode curTreeNode = stack.pop();
            // b.添加值
            list.add(curTreeNode.val);
            // c.进栈
            if (curTreeNode.left != null) {
                stack.add(curTreeNode.left);
            }
            if (curTreeNode.right != null) {
                stack.add(curTreeNode.right);
            }
        }
        // Collections的API反转链表
        Collections.reverse(list);
        return list;
    }

}
