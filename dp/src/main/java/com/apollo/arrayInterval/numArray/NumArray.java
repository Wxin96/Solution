package com.apollo.arrayInterval.numArray;
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
public class NumArray {
    // 空间复杂度: O(n)
    private int[] dp;
    // 时间复杂度: O(n)
    public NumArray(int[] nums) {
        if (nums != null && nums.length > 0) {
            this.dp = new int[nums.length];
            for (int i = 0, j = 0; i < nums.length; i++) {
                j += nums[i];
                dp[i] = j;
            }
        }
    }

    // 时间复杂度: O(1)
    public int sumRange(int i, int j) {
        // 0.过滤
        if (dp == null || i>j || i < 0 || j >= dp.length) {
            return -1;
        }

        // 1.i==0
        if (i == 0) {
            return dp[j];
        } else {
            return dp[j] - dp[i - 1];
        }

    }

}
