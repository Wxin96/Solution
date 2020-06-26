package com.apollo.knapsack.findTargetSumWays;

/**
 *  494.目标和
 */
public class FindTargetSumWays {
    // 1.DFS 解法
    // 时间复杂度: O(2^N)    N: 数组个数
    // 空间复杂度: O(N)
    public int findTargetSumWays(int[] nums, int S) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }

        return helper(nums, S, 0);
    }

    private int helper(int[] nums, int S, int start) {
        // 1.递归头
        if (start == nums.length) {
            return (S == 0) ? 1 : 0;
        }
        // 2.递归
        return helper(nums, S - nums[start], start + 1) + helper(nums, S + nums[start], start + 1);
    }

    // 2.动态规划
    // 注意: 当S大于sum时, 不存在
    // 时间复杂度: O(sum*n)
    // 空间复杂度: O(sum)
    public int findTargetSumWays02(int[] nums, int S) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.计算背包的容量
        int size = 0;
        for (int num : nums) {
            size += num;
        }
        if (S > size || (size+S & 1) == 1) {
            return 0;
        }
        size = (size + S) >> 1;
        // 2.初始化dp数组
        int[] dp = new int[size+1];
        // 3.BASE CASE
        dp[0] = 1;
        // 4.动态规划
        for (int num : nums) {
            for (int i = size; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }

        return dp[size];
    }


}
