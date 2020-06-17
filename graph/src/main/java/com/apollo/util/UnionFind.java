package com.apollo.util;

/**
 *  采用路径压缩效率高
 */
public class UnionFind {
    // 前导数组
    private int[] pre;

    public UnionFind(int n) {
        // 初始化前导数组
        this.pre = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            pre[i] = i;
        }
    }

    public int find(int x) {
        // 1.查找头
        int head = x;
        while (head != pre[head]) {
            head = pre[head];
        }
        // 2.路径压缩
        int indexRecord = 0;
        while (pre[x] != head) {
            indexRecord = pre[x];
            pre[x] = head;
            x = indexRecord;
        }
        return head;
    }

    public void union(int x, int y) {
        // 1.查找各自的头
        int headX = find(x), headY = find(y);
        // 2.连接与否
        if (headX != headY) {
            pre[headX] = headY;
        }
    }

    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}
