package com.apollo.recursion;

import com.apollo.TreeNode;
import com.apollo.recursion.diameterOfBinaryTree.DiameterOfBinaryTree;
import com.apollo.recursion.findSecondMinimumValue.FindSecondMinimumValue;
import com.apollo.recursion.hasPathSum.HasPathSum;
import com.apollo.recursion.invertTree.InvertTree;
import com.apollo.recursion.isBalanced.IsBalanced;
import com.apollo.recursion.isSubtree.IsSubtree;
import com.apollo.recursion.isSymmetric.IsSymmetric;
import com.apollo.recursion.longestUnivaluePath.LongestUnivaluePath;
import com.apollo.recursion.maxDepth.MaxDepth;
import com.apollo.recursion.mergeTrees.MergeTrees;
import com.apollo.recursion.minDepth.MinDepth;
import com.apollo.recursion.pathSum.PathSum;
import com.apollo.recursion.sumOfLeftLeaves.SumOfLeftLeaves;
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
        TreeNode root = TreeUtil.generateTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        // 输出
        InvertTree solution = new InvertTree();
        TreeNode treeNode = solution.invertTree02(root);
        // 验证
        TreeUtil.printTree(treeNode);

    }

    @Test
    public void testMergeTrees() {
        // 输入
        TreeNode root1 = TreeUtil.generateTree(new Integer[]{1, 3, 2, 5});
        TreeUtil.printTree(root1);
        System.out.println("------------");
        TreeNode root2 = TreeUtil.generateTree(new Integer[]{2, 1, 3, null, 4, null, 7});
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
        TreeNode root = TreeUtil.generateTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        // 输出
        HasPathSum solution = new HasPathSum();
        boolean result = solution.hasPathSum03(root, 22);
        // 验证
        System.out.println(result);
        Assert.assertTrue(result);
    }

    @Test
    public void testPathSum() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        // 输出
        PathSum solution = new PathSum();
        int result = solution.pathSum02(root, 22);
        // int result = solution.rootPathSum(root, 18);
        // 验证
        System.out.println(result);

    }

    @Test
    public void testIsSubtree() {
        // 输入
        TreeNode s = TreeUtil.generateTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode t = TreeUtil.generateTree(new Integer[]{4, 1, 2});
        // 输出
        IsSubtree solution = new IsSubtree();
        boolean subtree = solution.isSubtree(s, t);
        System.out.println(subtree);
        // 验证
        Assert.assertTrue(subtree);
    }

    @Test
    public void testIsSymmetric() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        // 输出
        IsSymmetric solution = new IsSymmetric();
        boolean result = solution.isSymmetric02(root);
        System.out.println(result);
        // 验证
        Assert.assertTrue(result);
    }

    @Test
    public void testMinDepth() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        // 输出
        MinDepth solution = new MinDepth();
        int minDepth = solution.minDepth(root);
        // 检验
        System.out.println(minDepth);
    }

    @Test
    public void testSumOfLeftLeaves() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        // 输出
        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        int sum = solution.sumOfLeftLeaves02(root);
        // 验证
        System.out.println(sum);
    }

    @Test
    public void testLongestUnivaluePath() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, null, 1, 1, 1, 1, 1, 1});
        // 输出
        LongestUnivaluePath solution = new LongestUnivaluePath();
        int longestUnivaluePath = solution.longestUnivaluePath(root);
        // 验证
        System.out.println(longestUnivaluePath);
    }

    @Test
    public void testFindSecondMinimumValue() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{2, 2, 2});
        // 输出
        FindSecondMinimumValue solution = new FindSecondMinimumValue();
        int secondMinimumValue = solution.findSecondMinimumValue(root);
        // 验证
        System.out.println(secondMinimumValue);

    }
}
