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
    // 实际模拟: 递归过程
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
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

    // 3.递归
    // 新的递归函数, 加入传递的中间变量
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public List<Integer> inorderTraversal03(TreeNode root) {
        // 0. 数据初始化
        List<Integer> list = new ArrayList<>();
        // 1.递归
        getAns(root, list);
        // 2.返回结果
        return list;
    }

    // 递归
    private void getAns(TreeNode root, List<Integer> list) {
        // 0.递归终止
        if (root == null) {
            return;
        }
        // 1.左
        getAns(root.left, list);
        // 2.中
        list.add(root.val);
        // 3.右
        getAns(root.right, list);

    }

    // 4.解法三: Morris Traversal(看别人代码写)
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 个人认为空间复杂度: O(n) => ans数组
    // 体会: 大三角 套 小三角
    public List<Integer> inorderTraversal04(TreeNode root) {
        // 0.数据初始化
        List<Integer> ans = new ArrayList<>();
        // 1.遍历节点
        TreeNode cur = root;
        // 2.迭代
        while (cur != null) {
            // 情况1
            // cur.left为null, 保存cur的值, 更新cur=cur.right[利用之前形成的线索树结构, 回溯上一节点]
            // 此处也是遍历的结束点
            // 左叶子节点
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                // 情况二: cur.left不为null, 找到左子树最右边的节点
                TreeNode last = cur.left;
                while (last.right != null && last.right != cur) {
                    last = last.right;
                }
                // 情况2.1:  last.right为null, 那么将last.right=cur, 更新cur=cur.left
                // 第一次遍历形成线索树
                if (last.right == null) {
                    last.right = cur;
                    cur = cur.left;
                }

                // 情况2.2: last.right不为null, 说明之前已经访问过, 第二次来到这里, 表明[当前子树的左子树]遍历完成,
                // 保存cur的值, 更新cur=cur.right
                if (last.right == cur) {
                    last.right = null;  // 恢复树结构(妙)
                    ans.add(cur.val);
                    cur = cur.right;
                }

            }
        }
        return ans;
    }

}
