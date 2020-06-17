package com.apollo.findOrder;

import java.util.*;

/**
 *  210. 课程表 II
 */
public class FindOrder {
    // 1.拓扑排序(类似BFS)
    // 时间复杂度: O(E+V)
    // 空间复杂度: O(E+V)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 0.过滤
        if (prerequisites == null) {
            return new int[]{};
        }
        // 1.初始化数据
        // 初始化邻接表
        List<Integer>[] adjacent = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacent[i] = new ArrayList<>();
        }
        // 初始化入度向量
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adjacent[prerequisite[1]].add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        // 初始化返回值
        List<Integer> result = new ArrayList<>();
        // 初始化队列
        Queue<Integer> queue = new LinkedList<>();

        // 2.初始化队列
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        // 3.遍历
        while (!queue.isEmpty()) {
            // a.出队列
            int curVertex = queue.poll();
            result.add(curVertex);
            numCourses--;
            // b.修改相连接顶点的入度向量
            for (int connn : adjacent[curVertex]) {
                if (--indegrees[connn] == 0) {
                    queue.offer(connn);
                }
            }
        }

        // int[] res = new int[result.size()];
        // for (int i = 0; i < res.length; i++) {
        //     res[i] = result.get(i);
        // }

        return numCourses == 0 ?  result.stream().mapToInt(Integer::valueOf).toArray(): new int[]{};

    }


    // 2.DFS
    // DFS遍历反向输出
    // 证明：对于任何先序关系：v->w，后序遍历结果可以保证 w 先进入栈中，因此栈的逆序结果中 v 会在 w 之前。
    // 时间复杂度: O(E+V)
    // 空间复杂度: O(E+V)
    public int[] findOrder02(int numCourses, int[][] prerequisites) {
        // 0.过滤
        if (prerequisites == null) {
            return new int[]{};
        }
        // 1.初始化数据(邻接矩阵|栈|标识向量)
        List<Integer>[] adjacent = new List[numCourses];
        Stack<Integer> stack = new Stack<>();
        int[] flag = new int[numCourses];
        Arrays.fill(flag, 0);
        for (int i = 0; i < numCourses; i++) {
            adjacent[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            adjacent[prerequisite[1]].add(prerequisite[0]);
        }

        // 2.DFS
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adjacent, flag, stack)) {
                return new int[]{};
            }
        }

        // 3.返回
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean dfs(int i, List<Integer>[] adjacent, int[] flag, Stack<Integer> stack) {
        // 0.递归终止
        if (flag[i] == 1) {
            return true;
        }
        if (flag[i] == -1) {
            return false;
        }
        // 1.初始化
        flag[i] = 1;
        // 2.DFS
        for (Integer conn : adjacent[i]) {
            if (dfs(conn, adjacent, flag, stack)) {
                return true;
            }
        }
        // 3.递归回城
        flag[i] = -1;
        stack.push(i);
        return false;
    }
}
