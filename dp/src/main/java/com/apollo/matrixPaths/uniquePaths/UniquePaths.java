package com.apollo.matrixPaths.uniquePaths;

/**
 * 62.不同路径
 * 状态转移方程:
 *     dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * BASE CASE
 *     dp[0][0] = 1
 *     dp[0][j] = dp[0][j-1] = 1
 *     dp[i][0] = dp[i-1][0] = 1
 * 只用到上和左状态, 可以动态压缩, dp[j] 倒叙遍历, 因为后会用到前, 前不会用到后
 */
public class UniquePaths {
    // 1.动态规划
    // 时间复杂度: O(m*n)
    // 空间复杂度: O(n)
    public int uniquePaths(int m, int n) {
        // 1.过滤
        if (m == 0 || n == 0) {
            return 0;
        }
        // 2.状态转移数组
        int[] dp = new int[n];
        dp[0] = 1;
        // 3.动态规划
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 三种情况
                if (j == 0) {   // 上 -> 下
                    // dp[j] = dp[j];
                } else if (i == 0) {    // 左 -> 右
                    dp[j] = dp[j - 1];
                } else{
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n - 1];
    }

    // 2.数学方法
    // C(m-1, m+n-2)
    // int和long都会溢出
    public int uniquePaths02(int m, int n) {
        // 1.过滤
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        // 2.返回
        return (int)(factorial(m + n - 2, m) / factorial(n - 1, 1));
    }

    private long factorial(int a, int b) {
        // 1.递归头
        if (a == b) {
            return a;
        }
        return (long) a * factorial(a - 1, b);
    }

    // 3.数学方法
    public int uniquePaths03(int m, int n) {
        // 1.过滤
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        // 2.初始化变量
        int a = m + n - 2;
        int b = 1;
        int cnt = n;
        double res = 1;
        // 3.求C(n-1, m+n-2)
        while (b != cnt) {
            res = res * a / b;
            b++;
            a--;
        }

        return (int)Math.ceil(res);
    }

    // 4.数学方法
    public int uniquePaths04(int m, int n) {
        int S = m + n - 2;  // 总共的移动次数
        int D = m - 1;      // 向下的移动次数
        long ret = 1;
        for (int i = 1; i <= D; i++) {
            ret = ret * (S - D + i) / i;
        }
        return (int) ret;
    }
}
