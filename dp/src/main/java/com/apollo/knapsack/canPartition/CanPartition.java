package com.apollo.knapsack.canPartition;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
public class CanPartition {
    // 1.动态规划
    public boolean canPartition(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 2) {
            return false;
        }
        // 1.求背包容量
        int size = 0;
        for (int num : nums) {
            size += num;
        }
        // 奇数
        if ((size & 1) == 1) {
            return false;
        }
        // 背包容量
        size >>= 1;
        // 2.初始化dp数组
        int[][] dp = new int[nums.length + 1][size + 1];
        // 3.动态规划
        for (int i = 1; i <= nums.length; i++) {
            int w = nums[i - 1];
            for (int j = 1; j <= size; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + w);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][size] == size;
    }

    // 2.动态规划(装满背包)
    public boolean canPartition02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 2) {
            return false;
        }
        // 1.求背包容量
        int size = 0;
        for (int num : nums) {
            size += num;
        }
        // 奇数
        if ((size & 1) == 1) {
            return false;
        }
        // 背包容量
        size >>= 1;
        // 2.初始化dp数组
        boolean[][] dp = new boolean[nums.length + 1][size + 1];
        // 3.BASE CASE
        dp[0][0] = true;
        // 4.动态规划
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= size; j++) {
                // a.初始化dp[i][j]
                dp[i][j] = dp[i - 1][j];
                // b.是否能装满
                if (j >= nums[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][size];
    }

    // 3.动态规划(装满背包+空间压缩)
    public boolean canPartition03(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 2) {
            return false;
        }
        // 1.求背包容量
        int size = 0;
        for (int num : nums) {
            size += num;
        }
        // 奇数
        if ((size & 1) == 1) {
            return false;
        }
        // 背包容量
        size >>= 1;
        // 2.初始化dp数组
        boolean[] dp = new boolean[size + 1];
        // 3.BASE CASE
        dp[0] = true;
        // 4.动态规划
        for (int num : nums) {
            for (int i = size; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[size];
    }

    // 4.动态规划(装满背包+空间压缩+优化)
    // 错误原因: 不只是看最后的判断, 中间有过程传递, 这种策略贪心策略有问题
    public boolean canPartition04(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 2) {
            return false;
        }
        // 1.求背包容量
        int size = 0;
        for (int num : nums) {
            size += num;
        }
        // 奇数
        if ((size & 1) == 1) {
            return false;
        }
        // 背包容量
        size >>= 1;
        // 2.初始化dp数组
        boolean[] dp = new boolean[size + 1];
        // 3.BASE CASE
        dp[0] = true;
        // 4.动态规划
        for (int num : nums) {
            for (int i = size; i >= num && !dp[i]; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[size];
    }

}
