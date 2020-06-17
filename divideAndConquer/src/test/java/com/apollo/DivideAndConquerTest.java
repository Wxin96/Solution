package com.apollo;

import com.apollo.diffWaysToCompute.DiffWaysToCompute;
import com.apollo.generateTrees.GenerateTrees;
import com.apollo.utils.TreeUtil;
import org.junit.Test;

import java.util.List;

public class DivideAndConquerTest {

    @Test
    public void testDiffWaysToCompute() {
        // 输入
        String input = "2*1-4*5-1+2";
        // 输出
        DiffWaysToCompute solution = new DiffWaysToCompute();
        List<Integer> list = solution.diffWaysToCompute02(input);
        // 验证
        list.forEach(System.out::println);
        System.out.println("--------------");
        System.out.println(list.size());
    }

    @Test
    public void testGenerateTrees() {
        // 输入
        int n = 3;
        // 输出
        GenerateTrees solution = new GenerateTrees();
        List<TreeNode> treeNodes = solution.generateTrees02(n);
        // 验证
        treeNodes.forEach(curNode-> {
            TreeUtil.prePrintTree(curNode);
            System.out.println("----------------");
        });
    }
}
