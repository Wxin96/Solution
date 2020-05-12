package com.apollo.maxDepth;

import com.apollo.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MaxDepth {
    // 时间复杂度: O(n)  => 每个节点都要遍历一次(n为树的节点的数量)
    // 空间复杂度: 递归的最大深度
    // 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是 O(N)。
    // 但在最好的情况下（树是完全平衡的），树的高度将是 log2(N)。因此，在这种情况下的空间复杂度将是 O(log2(N))。

    public int maxDepth(TreeNode root) {
        // 0.过滤/递归终点
        if (root == null) {
            return 0;
        }
        // 1.递归程序
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    // 2. 迭代, BFS(Breadth-First Search)
    // 使用队列数据结构 一层层 进行广度优先搜索
    // 时间复杂度: O(n)
    // 每个节点都遍历到了
    // 空间复杂度: 平衡树的情况O(n), 线性表 O(1)
    public int maxDepth02(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return 0;
        }

        // 1.初始化
        int maxDepth = 0;   // 返回最大长度
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        // 2.迭代
        while (!queue.isEmpty()) {
            // a.深度+1
            maxDepth++;
            // b.二次迭代
            // 排除当前层, 添加下一层的所有元素
            for (int i = queue.size(); i > 0; i--) {
                // i.删除并返回第一个元素
                TreeNode curTreeNode = queue.poll();
                // ii.添加当前节点的左右节点
                if (curTreeNode.left != null) {
                    queue.add(curTreeNode.left);
                }
                if (curTreeNode.right != null) {
                    queue.add(curTreeNode.right);
                }
            }
        }

        return maxDepth;
    }

    // 3.迭代方法 DFS(Depth-First Search)
    // 时间复杂度: O(n)
    // 利用深度优先遍历, 遍历了所有节点
    // 空间复杂度: O(depth) depth:深度的深度
    public int maxDepth03(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.初始化
        int maxDepth = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        // 栈的初始化
        stack.push(new Pair<>(root, 1));
        // 2.迭代
        while (!stack.isEmpty()) {
            // a. push出Pair
            Pair<TreeNode, Integer> curPair = stack.pop();
            TreeNode curTreeNode = curPair.getKey();
            Integer curDepth = curPair.getValue();

            // b.计算总的深度
            maxDepth = Math.max(maxDepth, curDepth);

            // c.下一层迭代
            if (curTreeNode.right != null) {
                stack.push(new Pair<>(curTreeNode.right, curDepth + 1));
            }
            if (curTreeNode.left != null) {
                stack.push(new Pair<>(curTreeNode.left, curDepth + 1));
            }

        }


        return maxDepth;
    }


}
