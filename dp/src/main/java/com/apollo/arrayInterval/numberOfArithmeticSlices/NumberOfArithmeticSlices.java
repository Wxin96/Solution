package com.apollo.arrayInterval.numberOfArithmeticSlices;

/**
 *  413. 等差数列划分
 *  解题的关键(剪枝叶):
 *      等差数列[0-(i-1)](增加x个子序列), => 等差数列[0-i] 增加x+1个子序列
 */
public class NumberOfArithmeticSlices {
    // 1.递归方式
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    private int sum;
    public int numberOfArithmeticSlices(int[] A) {
        helper(A, A.length - 1);
        return sum;
    }

    private int helper(int[] A, int end) {
        // 1.递归头
        if (end < 2) {
            return 0;
        }
        // 2.向下递归
        int ap = 0;
        if (A[end] - A[end - 1] == A[end - 1] - A[end - 2]) {
            ap = helper(A, end - 1) + 1;
            sum += ap;
        } else {
            helper(A, end - 1);
        }

        return ap;
    }

    // 2.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int numberOfArithmeticSlices02(int[] A) {
        // 0.过滤
        if (A == null || A.length < 2) {
            return 0;
        }
        // 1.状态转移矩阵
        int[] dp = new int[A.length];
        int sum = 0;
        // Base Case
        // dp[0]=0, dp[1]=0
        // 2.动态规划
        for (int i = 2; i < A.length; i++) {
            if (A[i] + A[i - 2] == 2 * A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    // 3.动态规划[状态压缩]
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int numberOfArithmeticSlices03(int[] A) {
        // 0.过滤
        if (A == null || A.length < 2) {
            return 0;
        }
        // 1.状态转移矩阵
        int curLength = 0;
        int sum = 0;
        // Base Case
        // dp[0]=0, dp[1]=0
        // 2.动态规划
        for (int i = 2; i < A.length; i++) {
            if (A[i] + A[i - 2] == 2 * A[i - 1]) {
                curLength += 1;
                sum += curLength;
            } else {
                curLength = 0;
            }
        }
        return sum;
    }

    // 4.公式法
}
