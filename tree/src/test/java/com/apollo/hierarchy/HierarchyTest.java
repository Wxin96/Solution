package com.apollo.hierarchy;

import com.apollo.TreeNode;
import com.apollo.hierarchy.averageOfLevels.AverageOfLevels;
import com.apollo.hierarchy.findBottomLeftValue.FindBottomLeftValue;
import com.apollo.utils.TreeUtil;
import org.junit.Test;

import java.util.List;

public class HierarchyTest {
    @Test
    public void testAverageOfLevels() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        // 输出
        AverageOfLevels solution = new AverageOfLevels();
        List<Double> result = solution.averageOfLevels02(root);
        // 验证
        result.stream().forEach(System.out::println);
    }

    @Test
    public void testFindBottomLeftValue() {
        // 输入
        TreeNode root = TreeUtil.generateTree(new Integer[]{2, 1, 3});
        // 输出
        FindBottomLeftValue solution = new FindBottomLeftValue();
        int leftValue = solution.findBottomLeftValue(root);
        // 验证
        System.out.println(leftValue);

    }
}
