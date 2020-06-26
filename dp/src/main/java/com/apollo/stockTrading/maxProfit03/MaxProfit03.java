package com.apollo.stockTrading.maxProfit03;

/**
 *  123. 买卖股票的最佳时机 III
 *  dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *  dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 *  dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
 *  dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
 *
 *  dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
 *  dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
 *              = max(dp[i-1][1][1], - prices[i])
 *
 */
public class MaxProfit03 {
    // 1.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int maxProfit(int[] prices) {
        // 0.预处理
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.初始化状态 | BASE CASE
        int dp_2_0 = 0, dp_2_1 = Integer.MIN_VALUE, dp_1_0 = 0, dp_1_1 = Integer.MIN_VALUE;
        // 2.动态规划
        for (int i = 0; i < prices.length; i++) {
            dp_2_0 = Math.max(dp_2_0, dp_2_1 + prices[i]);
            dp_2_1 = Math.max(dp_2_1, dp_1_0 - prices[i]);
            dp_1_0 = Math.max(dp_1_0, dp_1_1 + prices[i]);
            dp_1_1 = Math.max(dp_1_1, -prices[i]);
        }

        return dp_2_0;
    }

}
