package com.apollo.recursion.mergeTrees;

import com.apollo.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MergeTrees {

    // 1.递归一
    // 时间复杂度: O(m+n)
    // 空间复杂度: O(h) h:两颗树的最大深度
    // 分析: 有冗余部分, 可以优化, 只剩一棵树时直接返回后续节点即可, 不破坏原有结构
    // 类似问题: 21.合并两个有序链表
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 0.过滤|递归终止条件
        if (t1 == null && t2 == null) {
            return null;
        }
        // 1.获取两树的当前值
        int value1 = t1 != null ? t1.val : 0;
        int value2 = t2 != null ? t2.val : 0;
        // 2.递归
        TreeNode curTreeNode = new TreeNode(value1 + value2);

        curTreeNode.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        curTreeNode.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);

        // 3.返回值
        return curTreeNode;

    }

    // 2.递归
    // 时间复杂度: O(m+n)
    // 空间复杂度: O(h) h:两颗树的最小深度
    public TreeNode mergeTrees02(TreeNode t1, TreeNode t2) {
        // 0.过滤|递归终止条件
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        // 1.递归
        TreeNode curTreeNode = new TreeNode(t1.val + t2.val);

        curTreeNode.left = mergeTrees02(t1.left, t2.left);
        curTreeNode.right = mergeTrees02(t1.right, t2.right);

        // 2.返回值
        return curTreeNode;

    }

    // 3.迭代 BFS Queue+Pair数据结构
    // 利用BFS算法遍历树2, 重塑树t1
    // 时间复杂度: O(n)  n为树t2的节点数
    // 空间复杂度: O(n)  n为树t2的节点数, 最差情况:t2为平衡二叉树, n/2
    public TreeNode mergeTrees03(TreeNode t1, TreeNode t2) {
        // 0.过滤 => t1和t2都不为null
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        // 1.数据结构初始化
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        // Queue<Pair<TreeNode, TreeNode>> queue = new ArrayDeque<>();//速度慢
        queue.add(new Pair<>(t1, t2));


        // 2.迭代
        while (!queue.isEmpty()) {

            for (int i = queue.size(); i > 0; i--) {
                // a.队列头排出元素
                Pair<TreeNode, TreeNode> curPair = queue.poll();
                TreeNode curTree1 = curPair.getKey();
                TreeNode curTree2 = curPair.getValue();

                // b.改造curTree1
                curTree1.val += curTree2.val;

                // c.队列装元素
                // 左节点
                if (curTree2.left != null) {
                    curTree1.left = curTree1.left != null ? curTree1.left : new TreeNode(0);
                    queue.add(new Pair<>(curTree1.left, curTree2.left));
                }

                // 右节点
                if (curTree2.right != null) {
                    curTree1.right = curTree1.right != null ? curTree1.right : new TreeNode(0);
                    queue.add(new Pair<>(curTree1.right, curTree2.right));
                }
            }
        }
        return t1;
    }

    // 4.迭代, DFS算法
    // 栈这种数据结构很好的实现了, 深度遍历一挖挖到底的思想
    // 挖到t2为空, 不挖了;挖到t1为空接上t2
    // 时间复杂度: O(k) k为t1和t2的交集节点
    // 空间复杂度: O(h) 最差情况, 满二叉树, h为树的层数-1
    public TreeNode mergeTrees04(TreeNode t1, TreeNode t2) {
        // 0.过滤
        if (t1 == null) {
            return t2;
        }
        // 1.初始化数据
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});

        // 2.遍历
        while (!stack.isEmpty()) {
            // a.数据出栈
            TreeNode[] pair = stack.pop();
            TreeNode tree1 = pair[0];
            TreeNode tree2 = pair[1];

            // b.判断
            if (tree2 == null) {
                continue;
            }

            // c.tree1重新赋值
            tree1.val += tree2.val;

            // c.左右节点判断
            // 左右节点都为null, tree1.left = null, 那右节点也为null
            if (tree1.left == null) {
                tree1.left = tree2.left;
            } else {
                stack.push(new TreeNode[]{tree1.left, tree2.left});
            }

            if (tree1.right == null) {
                tree1.right = tree2.right;
            } else {
                stack.push(new TreeNode[]{tree1.right, tree2.right});
            }
        }


        return t1;
    }


}
