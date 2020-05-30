package com.apollo.bst.lowestCommonAncestor2;

import com.apollo.TreeNode;

/**
 *  236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor2 {
    // 1.递归法
    // 时间复杂度: O(n)  n:树的节点个数
    // 空间复杂度: O(h)  h:树的深度
    // 思考:
    // 把一颗树, 提取关节信息, 去除我们不要的信息, 再来分析问题, 会找到如何解决该类问题的方法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 情况一: 当前节点为null或p或q, 返回当前节点
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 2. 获取左右节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 3. 情况二: 左右节点的值不同
        if (left != right) {
            if (left != null && right != null) {
                // a.左右节点的值都不等于null, 当前节点是最近公共祖先
                return root;
            } else {
                // b.左右节点的值有一个值等于null, 返回不等于null的值
                return (left != null) ? left : right;
            }
        }
        // 4. 情况二: 左右节点的值相同(null), 返回null
        return null;
    }

    // 2.递归法(CyC2018)
    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 情况一: 当前节点为null或p或q, 返回当前节点
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 2. 获取左右节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 3. 情况二: 左右节点的值不同
        // 4. 情况二: 左右节点的值相同(null), 返回null
        return (left == null) ? right : (right == null) ? left : root;  // [优雅]
    }

    // 3.存储父节点(HashMap)
}
