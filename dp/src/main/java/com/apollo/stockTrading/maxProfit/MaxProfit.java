package com.apollo.stockTrading.maxProfit;

/**
 *  309. 最佳买卖股票时机含冷冻期
 *  状态转移方程:
 *      dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]);
 *      dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i]);
 *      第i天持有股票买入情况, 选择i-2天卖出无货;可能i-1也是无货状态dp[i]-1[0]=dp[i-2][0], 与前天状态相同, 直接考虑i-2天就可以
 */
public class MaxProfit {
    // 1.动态规划
    public int maxProfit(int[] prices) {
        // 0.预处理
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.初始化状态|BASE CASE
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_pre_i_0 = 0;
        // 2.动态规划
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_pre_i_0;
            dp_pre_i_0 = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        return dp_i_0;
    }
}
