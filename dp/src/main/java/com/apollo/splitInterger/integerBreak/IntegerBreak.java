package com.apollo.splitInterger.integerBreak;

/**
 *  343. 整数拆分
 */
public class IntegerBreak {
    // 1.动态规划
    // 错误原因: 最大值并不是中间数的乘积
    public int integerBreak(int n) {
        // 0.初始化
        if (n < 1) {
            return 0;
        }
        // 1.状态转移数组
        int[] dp = new int[n + 1];
        // BASE CASE
        // dp[1] = 0
        // 2.动态规划
        for (int i = 2; i <= n; i++) {
            // a.中间索引
            int mid = i / 2;
            int anotherMid = i - mid;
            // b.判断索引与数值大小
            mid = Math.max(mid, dp[mid]);
            anotherMid = Math.max(anotherMid, dp[anotherMid]);
            // c.状态转移
            dp[i] = mid * anotherMid;
        }
        return dp[n];
    }

    // 2.动态规划修正
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public int integerBreak02(int n) {
        // 0.初始化
        if (n < 1) {
            return 0;
        }
        // 1.状态转移数组
        int[] dp = new int[n + 1];
        // BASE CASE
        // dp[1] = 0
        // 2.动态规划
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // a.中间索引
                int another = i - j;
                // b.判断索引与数值大小
                j = Math.max(j, dp[j]);
                another = Math.max(another, dp[another]);
                // c.状态转移
                dp[i] = Math.max(dp[i], j * another);
            }
        }
        return dp[n];
    }


    // 3.动态规划3
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 反思: 为什么没想到可以更优, 更优雅
    public int integerBreak03(int n) {
        // 0.初始化
        if (n < 1) {
            return 0;
        }
        if (n <= 3) {
            return n - 1;
        }
        // 1.状态转移数组
        int[] dp = new int[n + 1];
        // BASE CASE
        dp[0] = 1;
        dp[2] = 2;
        dp[3] = 3;
        // 2.动态规划
        for (int i = 4; i <= n; i++) {
            // a.3的倍数
            if (i % 3 == 0) {
                dp[i] = dp[i - 3] * 3;
            } else if (i % 3 == 1) {
                dp[i] = dp[i - 4] * 4;
            } else if (i % 3 == 2) {
                dp[i] = dp[i - 2] * 2;
            }
        }
        return dp[n];
    }

    // 4.数学
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public int integerBreak04(int n) {
        // 0.初始化
        if (n <= 3) {
            return n - 1;
        }
        // 1.初始化数据
        // a有几个3, b余数
        int a = n / 3, b = n % 3;
        // 2.三种情况
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }

        return (int) Math.pow(3, a) * 2;
    }

}
