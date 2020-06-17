package com.apollo;

import com.apollo.canFinish.CanFinish;
import com.apollo.findOrder.FindOrder;
import com.apollo.findRedundantConnection.FindRedundantConnection;
import com.apollo.isBipartite.IsBipartite;
import org.junit.Test;

import java.util.Arrays;

public class GraphTest {

    @Test
    public void testIsBipartite() {
        // 输入
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        // 输出
        IsBipartite solution = new IsBipartite();
        boolean flag = solution.isBipartite03(graph);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testCanFinish() {
        // 输入
        int numCourses = 10;
        int[][] prerequisites = {{1, 0}};
        // 输出
        CanFinish solution = new CanFinish();
        boolean canFinish = solution.canFinish02(numCourses, prerequisites);
        // 验证
        System.out.println(canFinish);
    }

    @Test
    public void testFindOrder() {
        // 输入
        int numCourses = 1;
        int[][] prerequisites = {};
        // 输出
        FindOrder solution = new FindOrder();
        int[] order = solution.findOrder02(numCourses, prerequisites);
        // 验证
        System.out.println(Arrays.toString(order));
    }

    @Test
    public void testFindRedundantConnection() {
        // 输入
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        // 输出
        FindRedundantConnection solution = new FindRedundantConnection();
        int[] redundantConnection = solution.findRedundantConnection03(edges);
        // 验证
        System.out.println(Arrays.toString(redundantConnection));

    }
}
