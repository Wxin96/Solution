package com.apollo.hierarchy.findBottomLeftValue;

import com.apollo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
    // 1.BFS迭代
    // 时间复杂度: O(n)  n:节点数
    // 空间复杂度: O(w)  w:树的最大宽度
    public int findBottomLeftValue(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return -1;
        }
        // 1.初始化数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        queue.add(root);

        // 2.迭代
        while (!queue.isEmpty()) {
            // a.标志位
            boolean left = true;
            // 一层层进行遍历的
            for (int i = queue.size(); i >0 ; i--) {
                // a.出队列
                TreeNode curNode = queue.poll();
                // b.取出最左边的数值
                if (left) {
                    result = curNode.val;
                    left = false;
                }
                // c.队列加下一行节点
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

        }
        return result;
    }

    // 2.别人写的递归
    // 采用BFS一层层一个个遍历
    // 遍历顺序: 从右到左(妙!)
    // 时间复杂度: O(n)  n:节点数
    // 空间复杂度: O(w)  w:树的最大宽度
    public int findBottomLeftValue02(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
