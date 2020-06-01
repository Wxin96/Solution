package com.apollo.bst.kthSmallest;

import com.apollo.TreeNode;

import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    // 1.中序遍历
    // n: 二叉树的元素个数
    // 时间复杂度: O(n)  n: 树的元素数目
    // 空间复杂度: O(h)  h: 树的高度
    // 思考: 代码不够优雅
    private int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        // 0.递归终止
        if (root == null) {
            return -1;
        }
        // 1.中序遍历
        int leftValue = kthSmallest(root.left, k);
        cnt++;  // 递归次数
        // 2.递归次数判断
        if (cnt == k) {
            leftValue = root.val;
        }
        int rightValue = kthSmallest(root.right, k);
        // 3.递归传递
        if (leftValue != -1) {
            return leftValue;
        }
        if (rightValue != -1) {
            return rightValue;
        }
        return -1;
    }

    // 2.中序遍历解法(Cyc2018)
    // 既然上解法已经使用一个成员变量,我们不妨使用两个
    // 时间复杂度: O(n)  n: 树的元素数目
    // 空间复杂度: O(h)  h: 树的高度
    private int count = 0;
    private int kTarget = 0;
    public int kthSmallest02(TreeNode root, int k) {
        // 0.递归终止
        if (root == null) {
            return -1;
        }
        // 1.中序遍历
        // a.左
        kthSmallest02(root.left, k);
        // b.中
        count++;    // 递归次数
        if (count == k) {
            kTarget = root.val;
        }
        // c.右
        kthSmallest02(root.right, k);
        return kTarget;
    }

    // 3.递归(分治算法)
    // 思想: 我们的目的是找到第k个最小值, 找到了我们就结束递归
    // 1.对于一颗排序二叉树, 对于根节点第k个最小值, 对于左子树第k个最小元素, 对于右子树第k-1-left个最小值
    // 2.如何判断是当前节点, k-1等于当前节点的左节点数目,
    // 3.当前节点的左子节点数目>k-1, 目标节点在左子树
    // 4.当前节点的左子节点数目<k-1, 目标节点在右子树
    // 时间复杂度: n*log2(n) n:树的元素树
    // 空间复杂度: O(h)  h:树的高度
    public int kthSmallest03(TreeNode root, int k) {
        // 0.递归终止
        if (root == null) {
            return -1;
        }
        // 1.计算左子树节点数
        int leftNum = count(root.left);
        // 2.左子树节点数目 = k-1
        if (leftNum == k - 1) {
            return root.val;
        }
        // 3.左子树节点数目 > k-1
        else if (leftNum > k - 1) {
            return kthSmallest03(root.left, k);
        }
        // 4.左子树节点数目 < k-1
        else if (leftNum < k - 1) {
            return kthSmallest03(root.right, k - 1 - leftNum);
        } else {
            throw new RuntimeException("出现异常");
        }
    }
    private int count(TreeNode root) {
        // 0.递归终止
        if (root == null) {
            return 0;
        }
        // 1.递归
        return count(root.left) + count(root.right) + 1;
    }

    // 4.迭代法 DFS(栈)
    // 时间复杂度: O(h+k)  h:树的高度,
    // 空间复杂度: O(h+k)
    public int kthSmallest04(TreeNode root, int k) {
        // 1.过滤
        if (root == null) {
            return -1;
        }
        // 2.初始化变量
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        int cnt = 0;
        // 3.迭代
        while (curNode != null || !stack.isEmpty()) {
            // a.迭代左子树
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            // b.栈出元素
            TreeNode temp = stack.pop();
            cnt++;
            if (cnt == k) {
                return temp.val;
            }
            curNode = temp.right;
        }

        return -1;

    }
}
