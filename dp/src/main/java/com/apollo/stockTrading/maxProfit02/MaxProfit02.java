package com.apollo.stockTrading.maxProfit02;

/**
 *  714. 买卖股票的最佳时机含手续费
 *  dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]-fee);
 *  dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]);
 */
public class MaxProfit02 {
    // 1.动态规划
    // fee放在上边, 整数溢出了
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int maxProfit(int[] prices, int fee) {
        // 0.预处理
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.初始化状态 | BASE CASE
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        // 2.动态规划
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }

        return dp_i_0;
    }

}
