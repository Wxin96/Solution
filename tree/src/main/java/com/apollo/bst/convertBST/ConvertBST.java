package com.apollo.bst.convertBST;

import com.apollo.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 *      考察实质, 树的反中序遍历
 */
public class ConvertBST {
    // 1. 右-中-左递归
    // 时间复杂度: O(n)  n:树的元素数
    // 空间复杂度: O(h)  h:树的高度
    int num = 0;
    public TreeNode convertBST(TreeNode root) {
        // 0.递归终止
        if (root == null) {
            return null;
        }
        // 1.递归
        // a.右递归
        convertBST(root.right);
        // b.中处理
        num += root.val;
        root.val = num;
        // c.左递归
        convertBST(root.left);

        // 2.返回值
        return root;
    }

    // 2.DFS迭代
    // 时间复杂度: O(n)  n:树的元素数
    // 空间复杂度: O(h)  h:树的高度

    // 3.Morris遍历
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
}
