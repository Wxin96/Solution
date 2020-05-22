package com.apollo.ergodic.postorderTraversal;

import com.apollo.TreeNode;

import java.util.*;

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

    // 2.迭代法
    // 思想一: set记录遍历过的点
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)  list
    public List<Integer> postorderTraversal02(TreeNode root) {
        // 1.数据初始化
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = root;
        // 2.迭代
        while (cur != null || !stack.isEmpty()) {
            // a.左节点遍历到null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            // 右子树为空或者第二次来到这里
            if (cur.right == null || set.contains(cur)) {
                list.add(cur.val);
                stack.pop();
                cur = null; // 不需要继续左遍历
            } else {
                // 右子树不为空, 第一次来这里
                // 集合中添加cur节点
                set.add(cur);
                cur = cur.right;
            }

        }
        return list;
    }

    // 3.迭代法
    // 思想二: 记录上此遍历的点
    // 遍历次序: 左 -> (根节点) -> 右 ->根节点
    // 思考 /\ 结构(根左右)
    // 我们可以根据上次节点是不是右节点来判断是否需要向右递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)  list
    public List<Integer> postorderTraversal03(TreeNode root) {
        // 1.数据初始化
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        // 2.遍历
        while (cur != null || !stack.isEmpty()) {
            // a.左节点迭代
            // cur出循环时, cur=null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // b.栈顶判断
            cur = stack.peek();
            // i.左叶子节点
            if (cur.right == null || cur.right == pre) {
                list.add(cur.val);
                stack.pop();
                pre = cur;  // 记录上次迭代值
                cur = null;
            } else {
                // ii.存在右子节点, 并且右子节点未曾遍历过
                cur = cur.right;
            }
        }

        // 3.返回
        return list;
    }

    // 4.迭代法
    // 思想三: 每个节点压栈两次, 根据是否存在重复, 判断右节点归去
    // 双栈作用: 第一个次目的添加左右节点, 第二次打印当前值
    // 时间复杂度: O(n)
    // 空间复杂度: O(2h) h:树的深度
    public List<Integer> postorderTraversal04(TreeNode root) {
        // 0.数据初始化
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        // 1.过滤 (while已完成)
        // 2.迭代
        while (!stack.isEmpty()) {
            // a.栈顶元素出栈
            TreeNode curTreeNode = stack.pop();
            // b.空元素(跳过, 出栈)
            if (curTreeNode == null) {
                continue;
            }
            // c.第一次遍历该节点
            // 最后一个节点会出现 空栈问题
            if (!stack.isEmpty() && curTreeNode == stack.peek()) {
                // 先左后右 => 压栈先右后左
                stack.push(curTreeNode.right);
                stack.push(curTreeNode.right);
                stack.push(curTreeNode.left);
                stack.push(curTreeNode.left);
            } else {
                list.add(curTreeNode.val);
            }

        }
        return list;
    }

    // 5.Morris遍历法
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)  list
    public List<Integer> postorderTraversal05(TreeNode root) {
        // 0.数据初始化
        List<Integer> list = new ArrayList<>();
        TreeNode traversalNode = root;
        // 1.迭代
        while (traversalNode != null) {
            // a.第一种情况, 左子节点为null
            if (traversalNode.left == null) {
                traversalNode = traversalNode.right;
            } else {
                // b.第二种情况
                // 寻找左子树的最右节点
                TreeNode right= traversalNode.left;
                while (right.right != null && right.right != traversalNode) {
                    right = right.right;
                }

                // i.最右节点为null(初来乍到)
                if (right.right == null) {
                    right.right = traversalNode;
                    traversalNode = traversalNode.left;
                }

                if (right.right == traversalNode) {
                    // ii.最右节点为traversalNode(老马识途)
                    right.right = null;
                    insertList(traversalNode.left, list);
                    traversalNode = traversalNode.right;
                }

            }
        }
        // 2.根节点
        insertList(root, list);
        return list;
    }

    private void insertList(TreeNode root, List<Integer> list) {
        int len = list.size();
        while (root != null) {
            list.add(len, root.val);
            root = root.right;
        }
    }

}
