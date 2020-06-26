package com.apollo.stockTrading.maxProfit04;

/**
 *  188. 买卖股票的最佳时机 IV
 *  dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 *  dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 *  i == 0
 *  dp[0][k][0] = max(dp[-1][k][0], dp[-1][k][1] + prices[i])
 *  dp[0][k][1] = max(dp[-1][k][1], dp[-1][k-1][0] - prices[i])
 */
public class MaxProfit04 {
    // 1.动态规划
    public int maxProfit(int k, int[] prices) {
        // 0.预处理
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.分类讨论
        int n = prices.length;
        // 2.k >= n/2
        if (k >= n / 2) {
            // a.初始化状态
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            // b.动态规划
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }

            return dp_i_0;
        } else {
            // 3.k < n/2
            // a.初始化状态
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++) {
                // 从k->1,因为i用到i-1的数据
                for (int j = k; j >= 1; j--) {
                    if (i == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    } else {
                        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                    }
                }
            }
            return dp[n-1][k][0];
        }

    }

    public int maxProfit02(int k, int[] prices) {
        // 0.预处理
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.分类讨论
        int n = prices.length;
        // 2.k >= n/2
        if (k >= n / 2) {
            // a.初始化状态
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            // b.动态规划
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }

            return dp_i_0;
        } else {
            // 3.k < n/2
            // a.初始化状态
            int[][] dp = new int[k + 1][2];
            for (int i = 0; i < n; i++) {
                // 从k->1,因为i用到i-1的数据
                for (int j = k; j >= 1; j--) {
                    if (i == 0) {
                        dp[j][0] = 0;
                        dp[j][1] = -prices[i];
                    } else {
                        dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                        dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                    }
                }
            }
            return dp[k][0];
        }

    }

    public int maxProfit03(int k, int[] prices) {
        // 0.预处理
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.分类讨论
        int n = prices.length;
        // 2.k >= n/2
        if (k >= n / 2) {
            // a.初始化状态
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            // b.动态规划
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }

            return dp_i_0;
        } else {
            // 3.k < n/2
            // a.初始化状态
            int[][][] dp = new int[n][k + 1][2];
            for (int i = 0; i < n; i++) {
                // 从k->1,因为i用到i-1的数据
                for (int j = 1; j <= k; j++) {
                    if (i == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    } else {
                        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                    }
                }
            }
            return dp[n-1][k][0];
        }

    }

}
