package com.apollo.labuladong.fibonacci;

/**
 *  509. 斐波那契数
 */
public class Fibonacci {

    // 1.原始递归
    // 时间复杂度: O(2^n)
    // 空间复杂度: O(n)
    public int fib(int n) {
        // 1.递归头
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 2.带备忘录的递归解法
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int fib02(int n) {
        // 1.初始化数据
        int[] dp = new int[n+1];
        // 2.递归
        int fib = helper(n, dp);

        return fib;
    }

    private int helper(int n, int[] dp) {
        // 1.递归头
        if (n == 1 || n == 2) {
            return 1;
        }
        // 2.查看备忘录
        if (dp[n] != 0) {
            return dp[n];
        }
        // 3.没有记录, 建立记录
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }

    // 3.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int fib03(int n) {
        // 1.初始化数据
        int[] dp = new int[n+1];
        // 2.base case
        dp[1] = 1;
        dp[2]=1;
        // 3. 迭代
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 4.动态规划2
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int fib04(int n) {
        // 0.特别情况
        if (n == 1 || n == 2) {
            return 1;
        }
        // 1.初始化变量
        // base case
        int pre = 1;
        int cur = 1;
        // 2.迭代
        for (int i = 3; i <= n; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }



}
