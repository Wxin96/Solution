package com.apollo.bst.findTarget;

import com.apollo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  653. 两数之和 IV - 输入 BST
 */
public class FindTarget {
    // 1.二叉树 (转化)=> 数组(ArrayList) 双指针法
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public boolean findTarget(TreeNode root, int k) {
        // 0.过滤
        if (root == null) {
            return false;
        }
        // 1.BST=>数组
        List<Integer> list = new ArrayList<>();
        tree2Array(root, list);
        // 2.初始化左右指针
        int left = 0, right = list.size() - 1;
        // 3.遍历
        while (left < right) {
            // 1.结果
            int value = list.get(left) + list.get(right);
            // 2.三种情况
            if (value == k) {
                return true;
            } else if (value > k) {
                right--;
            } else if (value < k) {
                left++;
            }
        }
        return false;
    }

    // 中序遍历
    private void tree2Array(TreeNode root, List<Integer> array) {
        // 1.递归终止
        if (root == null) {
            return;
        }
        // 2.中序遍历
        tree2Array(root.left, array);
        array.add(root.val);
        tree2Array(root.right, array);
    }

    // 2.HashSet方法
    // 思想: 一边遍历, 一边验证/添加, 寻找target-curTreeNode.val
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)

    // 3.BST查找法
    // 利用BST的性质(遍历一个, 查找需要的另一个)
    // 时间复杂度: n*log2(n) BST要是退化为链表，时间复杂度就是最糟糕的情况n^2
    // 空间复杂度: O(1)
    // 查找函数 + 遍历函数
}
