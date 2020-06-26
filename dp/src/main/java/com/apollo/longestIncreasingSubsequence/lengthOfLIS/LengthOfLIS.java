package com.apollo.longestIncreasingSubsequence.lengthOfLIS;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 */
public class LengthOfLIS {
    // 1.动态规划
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public int lengthOfLIS(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 1.初始化 动态转移矩阵
        int[] dp = new int[nums.length];
        int res = 1;
        // 2.BASE CASE
        Arrays.fill(dp, 1);
        // 3.动态规划
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // 2.二分查找法
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(n)
    public int lengthOfLIS02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // 2.初始化数据
        int[] top = new int[nums.length];
        int piles = 0;
        // 3.迭代
        for (int i = 0; i < nums.length; i++) {
            // a.当前需要处理的数值
            int poker = nums[i];
            // b.二分查找, 插入的位置
            // [left, right)
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid;
                } else if (top[mid] == poker) {
                    right = mid;
                }
            }
            // c.判断是否需要增加栈
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }

        return piles;
    }

}
