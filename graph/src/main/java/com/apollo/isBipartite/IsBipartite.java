package com.apollo.isBipartite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  785. 判断二分图
 *      考察: 图的深度优先遍历和广度优先遍历
 */
public class IsBipartite {
    // 1.深度优先遍历
    // graph是邻接表
    // 思想:
    //      使用图的深度优先搜索遍历, 对节点进行染色, 检查是否存在冲突
    // 细节:
    //      1. 图是否几个集合
    //      2. 深度遍历遇到颜色不同的点不需要继续向下遍历, 因为之前染色已没问题
    // 时间复杂度: O(n+e), n:节点数目;e:边的数目. 遍历每个节点, 需遍历每条边
    // 空间复杂度: O(n)
    public boolean isBipartite(int[][] graph) {
        // 0.过滤
        if (graph == null) {
            return false;
        }
        // 1.初始化数据
        // color数组记录对应点的颜色, -1:为染色, 0:一种颜色 1:另一种颜色
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // 初始化
        // 2.DFS
        for (int i = 0; i < graph.length; i++) {
            // 当前节点未染色
            if (color[i] == -1) {
                // a.初始化数据
                Stack<Integer> stack = new Stack<>();
                color[i] = 0;   // 染色
                stack.push(i);

                // b.利用栈深度遍历
                while (!stack.isEmpty()) {
                    int curNode = stack.pop();
                    // 与curNode相连的节点
                    for (int conn : graph[curNode]) {
                        // i conn节点未染色
                        if (color[conn] == -1) {
                            color[conn] = color[curNode]^1;
                            stack.push(conn);
                        } else if (color[conn] == color[curNode]) {
                            // ii conn节点染色, 并不同
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // 2.另一种方式(递归)深度优先遍历
    // 时间复杂度: O(v+e)
    // 空间复杂度: O(v)
    public boolean isBipartite02(int[][] graph) {
        //0.过滤
        if (graph == null) {
            return false;
        }
        //1.初始化数据
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        //1.深度遍历
        //图: 连通图和非连通图
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1 && !isBipartite02(i, 0, color, graph)) {
                return false;
            }
        }
        return true;
    }

    // 递归
    /**
     * 深度优先遍历: 递归
     * @param curNode 当前节点
     * @param curColor 当前节点分配的颜色
     * @param color   节点颜色记录向量
     * @param graph 图的邻接表
     * @return  当前点颜色|当前点后更深层地点是否颜色冲突
     */
    public boolean isBipartite02(int curNode, int curColor, int[] color, int[][] graph) {
        //1.已经分配颜色
        // 递归截至
        if (color[curNode] != -1) {
            return color[curNode]==curColor;
        }
        //2.分配颜色
        color[curNode] = curColor;
        //3.深度遍历[邻接表]
        for (int conn : graph[curNode]) {
            // 递归正向传递
            if (!isBipartite02(conn, curColor ^ 1, color, graph)) {
                return false;
            }
        }

        return true;
    }


    // 3.广度优先遍历(BFS)
    // 此处需一层|层
    // 时间复杂度: O(v+e)
    // 空间复杂度: O(v)
    public boolean isBipartite03(int[][] graph) {
        //0.过滤
        if (graph == null || graph.length < 1) {
            return false;
        }
        //1.初始化数据
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // 初始化
        //2.广度优先遍历
        // 连通图 和 非连通图
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1 && !isBipartite03(i, color, graph)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 广度优先遍历
     * @param startNode 起始节点
     * @param color 节点颜色标识
     * @param graph 图的邻接表
     * @return 当前点颜色|当前点后更深层地点是否颜色冲突
     */
    public boolean isBipartite03(int startNode, int[] color, int[][] graph) {
        // 1.初始化数据
        Queue<Integer> queue = new LinkedList<>();
        color[startNode] = 0; // 初始化颜色
        queue.offer(startNode);
        // 2.广度优先遍历
        // 考虑器二分性质, 此处采用一层|层遍历
        while (!queue.isEmpty()) {
            //a.队列中元素的个数
            int size = queue.size();
            //b.处理这一层元素
            for (int i = 0; i < size; i++) {
                // i.当前点
                int curVertex = queue.poll();
                // ii.遍历该节点的连接点
                for (int conn : graph[curVertex]) {
                    if (color[conn] == -1) {
                        color[conn] = color[curVertex] ^ 1;
                        queue.offer(conn);
                    } else if (color[conn] == color[curVertex]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
