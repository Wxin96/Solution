package com.apollo.fibonacci.rob;

/**
 *  198. 打家劫舍
 */
public class Rob {
    // 1.动态规划(状态压缩)
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 状态转移方程(三间房子): A B C, C=max{A+C, B}
    // dp[0] = 0, dp[1] = nums[0]
    public int rob(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 1.初始化数据
        int len = nums.length;
        int pre = 0, cur = nums[0];
        // 2.迭代
        for (int i = 1; i < len; i++) {
            int temp = cur;
            cur = Math.max(cur, nums[i] + pre);
            pre = temp;
        }

        return cur;
    }

}
