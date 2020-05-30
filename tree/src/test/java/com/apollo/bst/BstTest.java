package com.apollo.bst;

import com.apollo.ListNode;
import com.apollo.TreeNode;
import com.apollo.bst.findMode.FindMode;
import com.apollo.bst.findTarget.FindTarget;
import com.apollo.bst.getMinimumDifference.GetMinimumDifference;
import com.apollo.bst.kthSmallest.KthSmallest;
import com.apollo.bst.lowestCommonAncestor.LowestCommonAncestor;
import com.apollo.bst.lowestCommonAncestor2.LowestCommonAncestor2;
import com.apollo.bst.sortedArrayToBST.SortedArrayToBST;
import com.apollo.bst.sortedListToBST.SortedListToBST;
import com.apollo.bst.trimBST.TrimBST;
import com.apollo.utils.ListUtil;
import com.apollo.utils.TreeUtil;
import org.junit.Test;

import java.util.Arrays;

public class BstTest {

    @Test
    public void testTriBST() {
        // 输入
        TreeNode treeNode = TreeUtil.generateTree(new Integer[]{1, 0, 2});
        // 输出
        TrimBST solution = new TrimBST();
        TreeNode trimBST = solution.trimBST(treeNode, 1, 2);
        // 验证
        TreeUtil.inPrintTree(trimBST);
    }

    @Test
    public void testKthSmallest() {
        // 输入
        TreeNode treeNode = TreeUtil.generateTree(new Integer[]{3, 1, 4, null, 2});
        // 输出
        KthSmallest solution = new KthSmallest();
        int kthSmallest = solution.kthSmallest04(treeNode, 4);
        // 验证
        System.out.println(kthSmallest);
    }

    @Test
    public void testLowestCommonAncestor() {
        // 输入
        TreeNode treeNode = TreeUtil.generateTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        // 输出
        LowestCommonAncestor solution = new LowestCommonAncestor();
        TreeNode commonAncestor = solution.lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4));
        // 验证
        System.out.println(commonAncestor.val);
    }

    @Test
    public void testLowestCommonAncestor2() {
        // 输入
        TreeNode treeNode = TreeUtil.generateTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        // 输出
        LowestCommonAncestor2 solution = new LowestCommonAncestor2();
        TreeNode commonAncestor = solution.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4));
        // 验证
        System.out.println(commonAncestor.val);
    }

    @Test
    public void testSortedArrayToBST() {
        // 输入
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        // 输出
        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode bst = solution.sortedArrayToBST(nums);
        // 验证
        TreeUtil.inPrintTree(bst);
    }

    @Test
    public void testSortedListToBST() {
        // 输入
        ListNode head = ListUtil.generateList(new Integer[]{-10, -3, 0, 5, 9});
        // 输出
        SortedListToBST solution = new SortedListToBST();
        TreeNode bst = solution.sortedListToBST(head);
        // 验证
        TreeUtil.inPrintTree(bst);
    }

    @Test
    public void testFindTarget() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        // 输出
        FindTarget solution = new FindTarget();
        boolean flag = solution.findTarget(root, 9);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testGetMinimumDifference() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, null, 3, 2});
        // 输出
        GetMinimumDifference solution = new GetMinimumDifference();
        int minimumDifference = solution.getMinimumDifference(root);
        // 验证
        System.out.println(minimumDifference);
    }

    @Test
    public void testFindMode() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, null, 2, 2});
        // 输出
        FindMode solution = new FindMode();
        int[] mode = solution.findMode(root);
        // 验证
        System.out.println(Arrays.toString(mode));
    }
}
