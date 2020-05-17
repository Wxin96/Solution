package com.apollo.reconstructQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {
    // 1.贪心算法
    // 时间复杂度:   O(n2)
    // 排序: O(nlog2(n))
    // 插入队列: O(k) k:当前队列元素书, k从1到n, 插入n此(查找+插入)
    // 空间复杂度: O(1)
    // 思路核心: 个子矮的人相对于个子高的人是看不见的
    // 按照身高 降序, k升序排列
    // 先排高的, 再排矮的, 矮的人不影响高的人的排序
    public int[][] reconstructQueue(int[][] people) {
        // 0.过滤
        if (people == null || people.length < 1) {
            return people;
        }
        // 1.数据初始化
        List<int[]> list = new ArrayList<>();

        // 2.排序
        Arrays.sort(people, (x, y) -> (x[0] != y[0]) ? -(x[0] - y[0]) : x[1] - y[1]);

        // 3.迭代
        for (int[] person : people) {
            list.add(person[1], person);
        }
        // 4.list.toArray(T[] a)是一个变量(形参), 不是字节码, 返回的值放进去
        return list.toArray(new int[list.size()][]);
    }

}
