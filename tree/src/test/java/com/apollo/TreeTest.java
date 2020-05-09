package com.apollo;

import com.apollo.maxDepth.MaxDepth;
import com.apollo.utils.TreeUtil;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testGenerateTree() {
        // 输入
        Integer[] nums = new Integer[] {3,9,20,null,null,15,7};
        // 输出
        TreeNode treeNode = TreeUtil.generateTree(nums);
        TreeUtil.printTree(treeNode);
    }

    @Test
    public void testMaxDepth() {
        // 输入
        Integer[] nums = new Integer[] {3,9,20,null,null,15,7};
        TreeNode treeNode = TreeUtil.generateTree(nums);
        // 输出
        MaxDepth solution = new MaxDepth();
        int maxDepth = solution.maxDepth(treeNode);
        // 检验
        System.out.println(maxDepth);
    }
}
