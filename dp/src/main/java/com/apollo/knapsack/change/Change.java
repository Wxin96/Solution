package com.apollo.knapsack.change;

/**
 *  518. 零钱兑换 IICopy for Markdown
 */
public class Change {
    // 1.动态规划
    public int change(int amount, int[] coins) {
        // 0.预处理
        if (coins == null || amount < 0) {
            return -1;
        }
        // 1.初始化动态数组
        int[] dp = new int[amount + 1];
        // 2.BASE CASE
        dp[0] = 1;
        // 3.动态规划
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

}
