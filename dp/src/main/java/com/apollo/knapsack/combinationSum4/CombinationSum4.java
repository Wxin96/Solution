package com.apollo.knapsack.combinationSum4;

/**
 *  377. 组合总和 Ⅳ
 */
public class CombinationSum4 {
    // 1.动态规划
    public int combinationSum4(int[] nums, int target) {
        // 0.预处理
        if (nums == null || nums.length <= 0 || target <= 0) {
            return 0;
        }
        // 1.初始化dp数组
        int[] dp = new int[target + 1];
        // 2.BASE CASE
        dp[0] = 1;
        // 3.动态规划
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i-num];
                }
            }
        }

        return dp[target];
    }

}
