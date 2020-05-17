package com.apollo.findContentChildren;

import java.util.Arrays;

public class FindContentChildren {
    // 1.贪心算法
    // 时间复杂度: O(nlog2(n)) 排序算法  n: max{g, s}
    // 空间复杂度: O(1)
    // 此处贪心算法策略
    // 1. 给一个孩子的饼干应当尽量小并且又能满足孩子, 这样大饼干才能拿来满足较大的孩子
    // 2. 因为满足最小的孩子, 最容易得到满足, 所以先满足满足度最小的孩子
    // 验证贪心算法能得到最优解
    // 实际操作:
    // 1.先排序两个数组
    // 2.最小的饼干, 先给饭量最小的人, 迭代(验证当前饼干能否满足当前孩子, 孩子满足, 孩子+1到下个孩子, 无论孩子满足与否, 饼干都要下一个)
    // 3.直到饼干没有了或者孩子都满足了
    public int findContentChildren(int[] g, int[] s) {
        // 0.过滤
        if (g == null || s == null) {
            return 0;
        }
        // 1.数据初始化
        int gIndex = 0;
        int sIndex = 0;
        // 2.排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 3.迭代
        while (gIndex < g.length && sIndex < s.length) {
            // a.把第 sIndex 个Cookie给孩子
            if (g[gIndex] <= s[sIndex]) {
                // 孩子吃饱了
                gIndex++;
            }
            // b.无论这个饼干是否被吃掉, 都要进行下一块
            // 因为是排序的
            sIndex++;
        }

        return gIndex;
    }
}
