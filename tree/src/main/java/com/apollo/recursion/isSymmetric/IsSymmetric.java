package com.apollo.recursion.isSymmetric;

import com.apollo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    // 1.递归(从根节点左右节点开始遍历)
    // 复杂度: O(n/2)  [满二叉树, 父子树的关系]
    // 空间复杂度: O(log2(n))
    // 体会: 一个方法要认真考虑才知道能不能实行, 用笔去算去推演, 空想误人子弟
    public boolean isSymmetric(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return true;
        }
        // 返回值
        return isSymmetric(root.left, root.right);
    }

    // 双节点递归, 检查是否是镜像对称的二叉树
    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        // 0.递归截至
        if (leftNode==null&&rightNode==null) {
            return true;
        } else if (leftNode==null || rightNode==null) {
            return false;
        }

        // 1.值判断
        if (leftNode.val != rightNode.val) {
            return false;
        }

        // 2.递归返回
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }




    // 2.迭代方法
    // 体会: 往常BFS是一层层遍历, 此处采用一个一个按照原层级顺序输出, 不同题目, 算法变换, 妙绝
    // 时间复杂度: O(n)  n:树的节点数目
    // 空间复杂度: O(hn) hn: 树的深度, log2(n), 最坏情况下: 平衡二叉树
    public boolean isSymmetric02(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return true;
        }
        // 1.数据初始化
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        // 2.迭代
        while(!queue.isEmpty()) {
            // a.出队列
            TreeNode curTreeNode = queue.poll();
            TreeNode nodeTreeCur = queue.poll();
            // b.判断
            if (curTreeNode == null && nodeTreeCur==null) {
                continue;
            }
            if (curTreeNode == null || nodeTreeCur==null) {
                return false;
            }
            if (curTreeNode.val != nodeTreeCur.val) {
                return false;
            }

            // c.装入两队镜像节点
            queue.add(curTreeNode.left);
            queue.add(nodeTreeCur.right);
            queue.add(curTreeNode.right);
            queue.add(nodeTreeCur.left);

        }

        return true;
    }


}
