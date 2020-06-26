package com.apollo.fibonacci.rob2;

/**
 *  213. 打家劫舍 II
 */
public class Rob2 {
    // 1.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 既然位置0和len-1相邻, 两个只能取一个, 求0-(len-2)和1-(len-1)的最大值
    // 复杂问题 => 子问题 思想
    public int rob(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    private int rob(int[] nums, int start, int end) {
        // 0.特殊
        if (start == end) {
            return nums[start];
        }
        // 1.初始化数据
        int pre = 0;
        int cur = nums[start];
        // 2.迭代
        for (int i = start + 1; i <= end; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
