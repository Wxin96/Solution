package com.apollo.longestIncreasingSubsequence.findLongestChain;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  646. 最长数对链
 */
public class FindLongestChain {
    // 1.动态规划(需要对数对先进行排序)
    // 按照区间头和区间尾排序都能保证最长子序列顺序不变 [a,b]
    // 状态转移方程: dp[i] = max{1, dp[j] + 1 | pairs[i][0] > pairs[j][1], 0<= j <i}
    // BASE CASE: Arrays.fill(dp, 1);
    // 对pairs[0]和pairs[1]排序都可以, 最长子序列的顺序不会改变
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public int findLongestChain(int[][] pairs) {
        // 0.过滤
        if (pairs == null || pairs.length < 1) {
            return 0;
        }
        // E.排序
        Arrays.sort(pairs, Comparator.comparingInt(num -> num[0]));
        // 1.动态规划数组
        int[] dp = new int[pairs.length];
        int res = 1;
        // 2.BASE CASE
        Arrays.fill(dp, 1);
        // 3.动态规划
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 2.动态规划+二分查找法

    // 3.贪心算法
    // 排序, 需要以pair[1]排序
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)
    public int findLongestChain03(int[][] pairs) {
        // 0.预处理
        if (pairs == null || pairs.length < 1) {
            return 0;
        }
        // 1.排序
        Arrays.sort(pairs, Comparator.comparingInt(num -> num[1]));
        // 2.初始化参数
        int count = 1, end = pairs[0][1];
        // 3.遍历
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }

        return count;
    }
}
