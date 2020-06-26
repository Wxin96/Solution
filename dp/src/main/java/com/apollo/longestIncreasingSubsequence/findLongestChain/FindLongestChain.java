package com.apollo.longestIncreasingSubsequence.findLongestChain;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  646. 最长数对链
 */
public class FindLongestChain {
    // 1.动态规划
    // 按照区间头和区间尾排序都能保证最长子序列顺序不变 [a,b]
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

}
