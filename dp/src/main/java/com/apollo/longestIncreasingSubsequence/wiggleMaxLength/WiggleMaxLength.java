package com.apollo.longestIncreasingSubsequence.wiggleMaxLength;

/**
 * 376. 摆动序列
 *  动态规划:
 *      暴力求解    =>      动态规划(一步步优化)
 *  贪心算法:
 *      找规律
 */
public class WiggleMaxLength {
    // 1.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 问题: 思考问题不全面, 分析了大于小于, 忽略了等于(类似'零'的情况), 对于动态规划问题要情况分支要考虑清楚
    // '零'的情况:
    // 1.初始导数 为 '零'
    // 2.中间导数 为 '零'
    public int wiggleMaxLength(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 1.初始化dp数组
        int[] dp = new int[nums.length];
        // 2.BASE CASE
        int symbol = nums[1] - nums[0];
        dp[1] = (symbol == 0) ? 1 : 2;
        // 3.动态规划
        for (int i = 2; i < nums.length; i++) {
            // a.无变化
            if (nums[i] - nums[i - 1] == 0) {
                dp[i] = dp[i - 1];
            } else if (symbol == 0) {
                // b.初始到现在刚有起伏
                dp[i] = dp[i - 1] + 1;
                symbol = nums[i] - nums[i - 1];
            } else if ((nums[i] - nums[i - 1] ^ symbol) >>> 31 == 0) {
                // c.同号
                dp[i] = dp[i - 1];
                symbol = nums[i] - nums[i - 1];
            } else {
                // b.异号
                dp[i] = dp[i - 1] + 1;
                symbol = nums[i] - nums[i - 1];
            }
        }

        return dp[nums.length - 1];
    }


    // 2.动态规划
    public int wiggleMaxLength02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 1.初始化dp数组
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        // 2.动态规划
        for (int i = 1; i < nums.length; i++) {
            // 在[0,i)中寻找当前最大的递增/递减
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                } else {
                    up[i] = up[i - 1];
                    down[i] = down[i - 1];
                }
            }

        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    // 3.线性动态规划


    // 4.空间复杂度O(1) 的线性动态规划

    // 5.贪心算法



}
