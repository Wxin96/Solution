package com.apollo.bst.findMode;

import com.apollo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  501.二叉搜索树中的众数
 */
public class FindMode {
    // 1.DFS迭代
    // 时间复杂度: O(n)  n: 树的节点数目
    // 空间复杂度: O(n)  n是最差情况, DFS遍历: h:树的高度 List存储众数
    public int[] findMode(TreeNode root) {
        // 0.过滤
        if (root == null) {
            return new int[0];
        }
        // 1.初始化数据
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>(); // 存储众数
        TreeNode curNode = root;
        // 长度
        int maxLen = 0;
        int curLen = -1;
        // 上一个值
        int preValue = root.val;

        // 2.遍历
        while (curNode != null || !stack.isEmpty()) {
            // a.左至头
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            // b.出栈顶元素
            TreeNode temp = stack.pop();
            // i.元素相等, 长度+1
            if (temp.val == preValue) {
                curLen++;
            } else {
                // ii.元素不等
                // 1.此时长度和最大长度相等
                if (curLen == maxLen) {
                    list.add(preValue);
                } else if (curLen > maxLen) {
                    // 2.比最大长度大
                    list.clear();
                    list.add(preValue);
                    maxLen = curLen;
                }
                preValue = temp.val;
                curLen = 0;
            }
            curNode = temp.right;
        }
        // 3.处理最后一个元素
        if (curLen == maxLen) {
            list.add(preValue);
        } else if (curLen > maxLen) {
            list.clear();
            list.add(preValue);
        }
        // 4.返回
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
