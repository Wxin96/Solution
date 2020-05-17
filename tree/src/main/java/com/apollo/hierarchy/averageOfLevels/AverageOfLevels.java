package com.apollo.hierarchy.averageOfLevels;

import com.apollo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    // 1.BFS遍历
    // 时间复杂度: O(n)  n:节点数目
    // 空间复杂度: O(max(w, h))  w:树的宽度(queue) h:树的深度(list)
    // 两种方式迭代:
    // 1.一层一层
    // 2.按从左到右的顺序, 一个一个
    public List<Double> averageOfLevels(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return null;
        }
        // 1.初始化数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        queue.add(root);

        // 2.迭代
        while (!queue.isEmpty()) {
            // a.当前值初始化
            double curValue = 0;
            int count = 0;

            // b.一层迭代
            for (int i = queue.size(); i > 0; i--) {
                // i. 队列排出
                TreeNode curTreeNode = queue.poll();
                // ii. 累加/计数
                curValue += curTreeNode.val;
                count++;
                // iii. 队列加如下一层
                if (curTreeNode.left != null) {
                    queue.add(curTreeNode.left);
                }
                if (curTreeNode.right != null) {
                    queue.add(curTreeNode.right);
                }
            }

            // c.一层弄完, 处理
            list.add(curValue/count);
        }

        return list;
    }

    // 2.DFS递归
    // 时间复杂度: O(n)  n:节点数目
    // 空间复杂度: O(h)  h:树的深度
    public List<Double> averageOfLevels02(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return null;
        }
        // 1.数据初始化
        List<Double> list = new ArrayList<>();
        List<Double> count = new ArrayList<>();
        // 2. 递归(DFS)
        dfs(root, 0, list, count);
        // 3. 求的结果
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) / count.get(i));
        }

        return list;
    }

    // DFS递归
    private void dfs(TreeNode root, int index, List<Double> list, List<Double> count) {
        // 0.递归终止条件
        if (root == null) {
            return;
        }
        // 1.判断list的长度
        if (index >= list.size()) {
            list.add((double) root.val);
            count.add(1d);
        } else {
            list.set(index, list.get(index)+root.val);
            count.set(index, count.get(index)+1);
        }
        // 2.继续递归
        dfs(root.left, index+1,list, count);
        dfs(root.right, index+1,list, count);

    }


}
