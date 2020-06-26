package com.apollo.stringEditing.minSteps;

/**
 *  650. 只有两个键的键盘
 */
public class MinSteps {
    // 1.递归
    // 时间复杂度: O(sqrt(n))    当n时素数的平方
    // 空间复杂度: O(sqrt(n))
    public int minSteps(int n) {
        // 1.递归头
        if (n <= 1) {
            return 0;
        }
        // 2.递归体
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }

        return n;
    }

    // 2.动态规划
    // 状态转移方程: dp[i] = Math.min(dp[i], dp[j] + dp[i/j]) j为i的因子
    // 时间复杂度: O(n*sqrt(n))
    // 空间复杂度: O(n+1)
    public int minSteps02(int n) {
        // 0.预处理
        if (n <= 1) {
            return 0;
        }
        // 2.初始化dp数组
        int[] dp = new int[n + 1];
        // 3.动态规划
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i/j];
                }
            }
        }

        return dp[n];
    }

}
