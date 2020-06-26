package com.apollo.splitInterger.numSquares;

import java.util.Arrays;

/**
 *  279. 完全平方数
 */
public class NumSquares {
    // 1.动态规划
    // 时间复杂度: O(n*sqrt(n))
    // 空间复杂度: O(n)
    public int numSquares(int n) {
        // 1.过滤
        if (n < 1) {
            return 0;
        }
        // 2.初始化状态转移方程
        int[] dp = new int[n + 1];
        // BASE CASE
        Arrays.fill(dp, n);
        for (int i = 1; i*i <= n; i++) {
            dp[i * i] = 1;
        }

        // 3.动态性规划
        for (int i = 2; i <= n; i++) {
            // a.是不是平方数
            if (dp[i] == 1) {
                continue;
            }
            // b. i中最大平方数
            for (int j = 1; j*j <= i; j++) {
                // dp[j*j] = 1
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }

        return dp[n];
    }

    // 2.更优雅的动态规划
    // dp[i*i] = dp[i*i] +dp[0]
    // dp[0] = 0 (BASE CASE)
    public int numSquares02(int n) {
        // 1.状态转移方程
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }


}
