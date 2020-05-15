package com.apollo.recursion.isSubtree;

import com.apollo.TreeNode;

public class IsSubtree {
    // 1.双重递归
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 0.递归结束
        if (s == null) {
            return false;
        }
        // 1.当前树
        boolean isSame = isSameTree(s, t);

        // 2.返回
        return isSame || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 2.判断是否是相同树
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        // 0.递归返回
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }

        // 1.值判断
        if (t1.val!=t2.val) {
            return false;
        }

        // 2.递归返回
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

}
