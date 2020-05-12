package com.apollo;

import com.apollo.diameterOfBinaryTree.DiameterOfBinaryTree;
import com.apollo.hasPathSum.HasPathSum;
import com.apollo.invertTree.InvertTree;
import com.apollo.isBalanced.IsBalanced;
import com.apollo.maxDepth.MaxDepth;
import com.apollo.mergeTrees.MergeTrees;
import com.apollo.utils.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testGenerateTree() {
        // 输入
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        // 输出
        TreeNode treeNode = TreeUtil.generateTree(nums);
        TreeUtil.printTree(treeNode);
    }

    @Test
    public void testMaxDepth() {
        // 输入
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeUtil.generateTree(nums);
        // 输出
        MaxDepth solution = new MaxDepth();
        int maxDepth = solution.maxDepth03(treeNode);
        // 检验
        System.out.println(maxDepth);
    }

    @Test
    public void testIsBalanced() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        // 输出
        IsBalanced solution = new IsBalanced();
        boolean result = solution.isBalanced03(root);
        // 验证
        System.out.println(result);
        Assert.assertFalse(result);
    }

    @Test
    public void testDiameterBinaryTree() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, 2, 3, 4, 5});
        // 输出
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println(diameter);
        // 验证
        Assert.assertEquals(diameter, 3);
    }

    @Test
    public void testInvertTree() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{4,2,7,1,3,6,9});
        // 输出
        InvertTree solution = new InvertTree();
        TreeNode treeNode = solution.invertTree02(root);
        // 验证
        TreeUtil.printTree(treeNode);

    }

    @Test
    public void testMergeTrees() {
        // 输入
        TreeNode root1 = TreeUtil.generateTree(new Integer[]{1,3,2,5});
        TreeUtil.printTree(root1);
        System.out.println("------------");
        TreeNode root2 = TreeUtil.generateTree(new Integer[]{2,1,3,null,4,null,7});
        System.out.println("------------");
        TreeUtil.printTree(root2);
        // 输出
        MergeTrees solution = new MergeTrees();
        TreeNode treeNode = solution.mergeTrees04(root1, root2);
        // 验证
        System.out.println("------------");
        TreeUtil.printTree(treeNode);

    }

    @Test
    public void testHasPathSum() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        // 输出
        HasPathSum solution = new HasPathSum();
        boolean result = solution.hasPathSum03(root, 22);
        // 验证
        System.out.println(result);
        Assert.assertTrue(result);
    }
}
