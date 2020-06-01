package com.apollo.bst.lowestCommonAncestor2;

import com.apollo.TreeNode;

/**
 *  236. 二叉树的最近公共祖先
 *      与之间 BST最近公共祖先不同, 普通二叉树没有排序性质
 *  题目条件:
 *      a.所有节点的值都是唯一的
 *      b.p、q为不同节点且均存在于给定的二叉搜索树中
 *  个人理解:
 *      与669修剪二叉搜索树, 有一定的相似性, 在树中寻找我们感兴趣的节点, 并返回;
 *
 */
public class LowestCommonAncestor2 {
    // 1.递归法
    // 时间复杂度: O(n)  n:树的节点个数
    // 空间复杂度: O(h)  h:树的深度
    // 思考:
    // 把一颗树, 提取关节信息, 去除我们不要的信息, 再来分析问题, 会找到如何解决该类问题的方法
    // (1） 如果当前结点 root 等于 NULL，则直接返回 NULL
    // (2) 如果 root 等于 p 或者 q ，那这棵树一定返回 p 或者 q
    // (3) 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 left 和 right 表示
    // (4) 此时若left为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left[此情况包含已经找到最近公共祖先]
    // (5) 如果 left 和 right 都非空，因为只给了 p 和 q 两个结点，都非空，说明一边一个，因此 root 是他们的最近公共祖先
    // (6) 如果 left 和 right 都为空，则返回空（其实已经包含在前面的情况中了）
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

    // 3.存储父节点(HashMap HashSet)
    // 利用Map的映射关系 子=>父
    // 利用HashSet查找最近公共祖先
}
