package com.apollo.findRedundantConnection;

import com.apollo.util.UnionFind;

import java.util.*;

/**
 *  684. 冗余连接
 *      并查集的巧妙应用
 *      并查集: 查找函数(路径压缩) 联合函数
 *  思路:
 *      1-N节点的树, 那个任意两个节点只有一条路径相同
 *
 */
public class FindRedundantConnection {
    // 1.并查集1
    public int[] findRedundantConnection(int[][] edges) {
        // 0.过滤
        if (edges == null) {
            return new int[]{};
        }
        // 1.初始化数据
        UF uf = new UF(edges.length);
        // 2.遍历
        for (int[] edge : edges) {
            // a.已经连接
            if (uf.connect(edge[0], edge[1])) {
                return edge;
            }
            // b.连接
            uf.union(edge[0], edge[1]);
        }

        return new int[]{};
    }

    private class UF {
        private int[] pre;  // 前导数组

        public UF(int n) {
            // 初始化前导数组
            // n+1 => 0, 1-n
            this.pre = new int[n + 1];
            for (int i = 0; i < pre.length; i++) {
                pre[i] = i;
            }
        }

        public void union(int x, int y) {
            // 1.首先判断是否本来就是联通的
            if (find(x) == find(y)) {
                return;
            }
            // 2.联通操作
            // 所有x连接到y
            int target = find(x);
            for (int i = 0; i < pre.length; i++) {
                if (pre[i] == target) {
                    pre[i] = find(y);
                }
            }
        }

        public int find(int x) {
            return pre[x];
        }

        public boolean connect(int x, int y) {
            return find(x) == find(y);
        }

    }

    // 2.并查集2
    // 时间复杂度: O(N)  N:图中顶点数目以及边的数目
    // 空间复杂度: O(N)
    public int[] findRedundantConnection02(int[][] edges) {
        // 0.过滤
        if (edges == null) {
            return new int[]{};
        }
        // 1.初始化数据
        UnionFind uf = new UnionFind(edges.length);
        // 2.遍历
        for (int[] edge : edges) {
            // a.已经连接
            if (uf.connect(edge[0], edge[1])) {
                return edge;
            }
            // b.连接
            uf.union(edge[0], edge[1]);
        }

        return new int[]{};
    }

    // 3.拓扑结构
    // 思想:
    //     将无向图看作有向图, a-b -> a->b 和 a<-b
    //     清除入度为1的, 直至无法清除, 剩下为环, 入度都为2
    // 时间复杂度: O(E+V)
    // 空间复杂度: O(E+V)
    public int[] findRedundantConnection03(int[][] edges) {
        // 0.过滤
        if (edges == null) {
            return new int[]{};
        }
        // 1.初始化数据(入度表|邻接表)
        int n = edges.length + 1;
        int[] inDegrees = new int[n];
        List<Integer>[] adjacent = new List[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adjacent[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            inDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
            adjacent[edge[0]].add(edge[1]);
            adjacent[edge[1]].add(edge[0]);
        }
        // 2.第一次迭代收集 入度=1 顶点
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                queue.offer(i);
            }
        }
        // 3.第二次遍历
        while (!queue.isEmpty()) {
            // a.当前点
            Integer curVertex = queue.poll();
            // b.查找对应连接点
            for (Integer conn : adjacent[curVertex]) {
                if (--inDegrees[conn] == 1) {
                    queue.offer(conn);
                }
            }

        }
        // 4.第三次遍历寻找入度=2的顶点
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 2) {
                set.add(i);
            }
        }

        // 5.第四次遍历寻找冗余的边
        for (int i = edges.length-1; i >=0 ; i--) {
            if (set.contains(edges[i][0]) && set.contains(edges[i][1])) {
                return edges[i];
            }
        }

        return new int[]{};
    }


}
