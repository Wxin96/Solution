package com.apollo.generateTrees;


import com.apollo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  95. 不同的二叉搜索树 II
 *      二叉搜索树的性质: 左小, 右大
 */
public class GenerateTrees {
    // 1.分治算法
    // 思想:
    //      1.分解: 一个元素作为根节点, 作为左右两部分
    //      2.解决: 实现一个递归函数, 输入树的的范围, 返回所有可能情况
    //      3.合并: 根节点合并所有左右的树的情况
    // 时间复杂度: O(4^n/n^{1/2})    卡特兰数
    // 空间复杂度: O(4^n/n^{1/2})
    public List<TreeNode> generateTrees(int n) {
        // 0.过滤
        if (n < 1) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int low, int high) {
        // 1.数据初始化
        List<TreeNode> list = new ArrayList<>();
        // 2.递归终止
        if (low > high) {
            list.add(null);
            return list;
        }
        // 3.迭代
        for (int i = low; i <= high; i++) {
            // a.左树
            List<TreeNode> leftSubTrees = generateTrees(low, i - 1);
            // b.右树
            List<TreeNode> rightSubTrees = generateTrees(i + 1, high);
            // c.组合
            for (TreeNode leftSubTree : leftSubTrees) {
                for (TreeNode rightSubTree : rightSubTrees) {
                    list.add(new TreeNode(i, leftSubTree, rightSubTree));
                }
            }
        }

        return list;
    }

    // 2.动态规划
    // 思想:
    //  dp[n]: 输入n时, 生成所有可能的二叉树
    //  dp[i] => dp[i+1], 0-i+1作为顶点生成二叉树, 使用结构同构方法[妙]
    //  状态方程起始: dp[0] = null
    public List<TreeNode> generateTrees02(int n) {
        // 0.过滤
        if (n < 1) {
            return new ArrayList<>();
        }
        // 1.初始化数据
        List<TreeNode>[] dp = new List[n + 1];
        // 2.状态转移数组初始化
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        // 3.状态转移, 动态规划
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();
            // 不同节点
            for (int root = 1; root <= len; root++) {
                // 左右节点
                int left = root - 1;
                int right = len - root;
                for (TreeNode leftNode : dp[left]) {
                    for (TreeNode rightNode : dp[right]) {
                        TreeNode curNode = new TreeNode(root);
                        curNode.left = leftNode;
                        curNode.right = copyTree(rightNode, root);
                        dp[len].add(curNode);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode copyTree(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode curNode = new TreeNode(root.val + offset);
        curNode.left = copyTree(root.left, offset);
        curNode.right = copyTree(root.right, offset);
        return curNode;
    }


}
