package com.apollo.ergodic;

import com.apollo.TreeNode;
import com.apollo.ergodic.inorderTraversal.InorderTraversal;
import com.apollo.ergodic.postorderTraversal.PostorderTraversal;
import com.apollo.ergodic.preorderTraversal.PreorderTraversal;
import com.apollo.utils.TreeUtil;
import org.junit.Test;

import java.util.List;

public class ErgodicTest {

    @Test
    public void testPreorderTraversal() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, null, 2, 3});
        // 输出
        PreorderTraversal solution = new PreorderTraversal();
        List<Integer> list = solution.preorderTraversal02(root);
        // 验证
        list.forEach(System.out::println);

    }

    @Test
    public void testPostorderTraversal() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, null, 2, 3});
        // 输出
        PostorderTraversal solution = new PostorderTraversal();
        List<Integer> list = solution.postorderTraversal(root);
        // 验证
        list.forEach(System.out::println);
    }

    @Test
    public void testInorderTraversal() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, null, 2, 3});
        // 输出
        InorderTraversal solution = new InorderTraversal();
        List<Integer> list = solution.inorderTraversal02(root);
        // 验证
        list.forEach(System.out::println);
    }
}
