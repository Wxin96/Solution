package com.apollo.canFinish;

import java.util.*;

/**
 * 207.课程表
 *  拓扑排序是对[有向无圈]图的顶点的一种排序, 使得如果存在一条边从vi到vj的路径, 那么再排序中vj就出现在vi的后边.
 *  例子:
 *      课程表(先选某些课, 才能选别的)
 *  此题考察的是:
 *      能否完成课程, 并不是给出选修名单, 两种方式解决:
 *          1.拓扑排序
 *          2.深度遍历检查是否有圈
 *  此处的输入:
 *      图的表示为: 边缘列表
 */
public class CanFinish {
    // 1.拓扑结构
    // 思想:
    //  如果存在圈, 入度表是始终有对应的顶点的值不为0, 存在顶点遍历不到
    // numCourses: 相当于顶点个数
    // 时间复杂度: O(v+e)
    // 空间复杂度: O(v+e)    邻接表
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 0.过滤
        if (prerequisites == null || prerequisites.length < 1) {
            return true;
        }
        // 1.初始化数据
        int[] indegrees = new int[numCourses];  // 入度表
        List<Integer>[] adjacent = new List[numCourses];    // 邻接表
        Queue<Integer> queue = new LinkedList<>();  // 队列
        for (int i = 0; i < numCourses; i++) {
            adjacent[i] = new ArrayList<>();
        }

        // 2.初始化邻接表/入度矩阵
        for (int[] prerequisite : prerequisites) {
            // 入度矩阵
            indegrees[prerequisite[0]]++;
            // 邻接表
            adjacent[prerequisite[1]].add(prerequisite[0]);
        }

        // 3.遍历
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                // 进队列
                queue.offer(i);
            }

        }
        // 4.迭代
        while (!queue.isEmpty()) {
            // i.出队列, 可以修一门
            int curNode = queue.poll();
            numCourses--;
            // ii.对应边减度
            for (int connNode : adjacent[curNode]) {
                // 度为0加入
                if (--indegrees[connNode] == 0) {
                    queue.offer(connNode);
                }
            }
        }

        return numCourses == 0;

    }

    // 2.深度优先遍历(DFS)
    // 原理: 通过深度优先遍历判断图中是否有环
    // 数组flag标记, -1被别的访问, 0未被访问, 1当前已访问
    // 时间复杂度: O(V+E)    V:顶点数 E:边数  遍历一个图, 需要访问所有的节点和边
    // 空间复杂度: O(V+E)    为建立临界表所需要的额外空间, adjacent长度为V, 并存储E条边
    // 思路: 判断有没有环, 递归有进有退是一条鞭, 递归到重复元素是由环. 递归退的时候改变flag为-1代表已访问, 这是深度遍历中的一支, 没有圈没有问题
    public boolean canFinish02(int numCourses, int[][] prerequisites) {
        // 0.过滤
        if (prerequisites == null || prerequisites.length < 1) {
            return true;
        }
        // 1.初始化数据
        List<Integer>[] adjacent = new List[numCourses];    // 邻接表
        int[] flag = new int[numCourses];   // 深度优先遍历标识
        Arrays.fill(flag, 0);   // 初始化
        for (int i = 0; i < numCourses; i++) {
            adjacent[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {  // 邻接表初始化
            adjacent[prerequisite[1]].add(prerequisite[0]);
        }
        // 2.深度优先遍历
        for (int i = 0; i < numCourses; i++) {
            if (flag[i] == 0 && !dfs(i, adjacent, flag)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, List<Integer>[] adjacent, int[] flag) {
        // 1.递归截至
        if (flag[i] == 1) {
            return false;
        }
        if (flag[i] == -1) {
            return true;
        }
        // 2.当前点已访问
        flag[i] = 1;
        // 3.深度优先遍历
        for (Integer conn : adjacent[i]) {
            if (!dfs(conn, adjacent, flag)) {
                return false;
            }
        }
        // 4.递归回城
        flag[i] = -1;

        // 5.递归传递
        return true;
    }

}
