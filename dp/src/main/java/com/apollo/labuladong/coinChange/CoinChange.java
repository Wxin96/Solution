package com.apollo.labuladong.coinChange;

import java.util.Arrays;

/**
 *  322. 零钱兑换
 */
public class CoinChange {
    // 1.动态规划
    // 时间复杂度: O(kn) k:硬币数目 n=amount
    // 空间复杂度: O(n)
    // amount+1设置的很巧妙
    // 细节: 组合不出的怎么处理
    public int coinChange(int[] coins, int amount) {
        // 0.过滤
        if (amount < 0) {
            return -1;
        }
        // 1.初始化数据
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 2.迭代
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // a.前状态
                int preStatus = i - coin;
                // b.判断是否合法
                if (preStatus < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[preStatus] + 1);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
