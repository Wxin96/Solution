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
    // 空间复杂度: O(n)  n:节点个数 list
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

    // 3.Morris遍历
    // 时间复杂度: O(n)  n:节点个数
    // 空间复杂度: O(n)  n:节点个数 list
    public List<Integer> preorderTraversal03(TreeNode root) {
        // 0.数据/变量初始化
        List<Integer> list = new ArrayList<>();
        TreeNode curTreeNode = root;
        // 1.过滤: 无需过滤,因为while()帮忙实现了
        // 2.迭代
        while (curTreeNode != null) {
            // a.第一种情况
            if (curTreeNode.left == null) {
                list.add(curTreeNode.val);
                curTreeNode = curTreeNode.right;
            } else {
                // b.第二种情况
                // 首先, 我们需要找到当前节点的左子树的最右边的节点
                TreeNode last = curTreeNode.left;
                while (last.right != null && last.right != curTreeNode) {
                    last = last.right;
                }
                // 2.1 last==null
                // last.right为null, 那么将last.right=cur, 更新cur=cur.left
                // 第一次来这里, 建立线索化二叉树, 左三角 => 右三角
                if (last.right == null) {
                    list.add(curTreeNode.val);
                    last.right = curTreeNode;
                    curTreeNode = curTreeNode.left;
                } else if (last.right == curTreeNode) {
                    // 第二次来到这里
                    curTreeNode = curTreeNode.right;
                    last.right = null;  // 恢复树结构
                }
            }
        }
        return list;
    }


}
