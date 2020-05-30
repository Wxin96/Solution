package com.apollo.bst.trimBST;

import com.apollo.TreeNode;

/**
 *  669.修剪二叉搜索树
 *      递归修建枝叶
 *      思想:
 *          1. 符合条件, 父子关系不变
 *          2. 不符合条件, 递归传递中跳过不符合条件的节点, 返回深层符合条件的节点, 实现BST的修枝剪叶
 *
 */
public class TrimBST {
    // 1.递归
    // 时间复杂度: O(n) n:树的节点数目
    // 空间复杂度: O(h) h:树的高度
    // 思想:
    //  1.当前节点的值 < L, 去右区间检查是否存在符合条件的节点
    //  2.当前节点的值 > R, 去左区间检查是否存在符合条件的节点
    //  3.当前结点的值 在[L, R]闭区间中, 符合条件正常传递
    public TreeNode trimBST(TreeNode root, int L, int R) {
        // 0.递归到null
        if (root == null) {
            return null;
        }
        // 1.当前点在[L, R]外, 返回新节点的过程在重新构造树
        // a.当前点.val < L, 看看左子树有没有符合要求的
        if (root.val  < L) return trimBST(root.right, L, R);
        // b.当前点.val > R, 看看右子树有没有符合要求的
        if (root.val > R) return trimBST(root.left, L, R);
        // 2.该点在区间范围内
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
