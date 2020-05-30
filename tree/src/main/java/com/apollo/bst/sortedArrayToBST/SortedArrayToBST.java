package com.apollo.bst.sortedArrayToBST;

import com.apollo.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    // 1.递归
    // 时间复杂度: O(n)  n: 数组的元素数目
    // 空间复杂度: O(h)  h: log2(n)
    public TreeNode sortedArrayToBST(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return null;
        }
        // 1.遍历
        TreeNode bstTree = sortedArrayToBST(nums, 0, nums.length - 1);
        // 2.返回
        return bstTree;
    }


    // 分治算法
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        // 1.递归终止条件
        if (start > end) {
            return null;
        }
        // 2.中间值
        int mid = start + (end - start)/2;
        TreeNode curTreeNode = new TreeNode(nums[mid]);
        // 3.左右
        curTreeNode.left = sortedArrayToBST(nums, start, mid - 1);
        curTreeNode.right = sortedArrayToBST(nums, mid + 1, end);
        // 4.返回值
        return curTreeNode;
    }

    // 其他非递归解法
}
