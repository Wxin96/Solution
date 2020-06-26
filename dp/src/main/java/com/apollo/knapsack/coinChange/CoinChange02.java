package com.apollo.knapsack.coinChange;

import java.util.Arrays;

/**
 *  零钱兑换
 */
public class CoinChange02 {
    // 1.动态规划
    public int coinChange(int[] coins, int amount) {
        // 0.预处理
        if (coins == null || coins.length <= 0 || amount < 0) {
            return -1;
        }
        // 1.初始化dp数组
        int[] dp = new int[amount + 1];
        // 2.BASE CASE
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 3.动态规划
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // a.当前金额是不是非负数
                if (i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
