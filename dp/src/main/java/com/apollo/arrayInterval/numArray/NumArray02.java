package com.apollo.arrayInterval.numArray;
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 * 更优雅的代码
 *  dp增加一长度
 *
 *  状态转移方程:
 *      dp[i] = dp[i-1] + nums[i-1]
 *  BASE CASE
 *      dp[0] = 0
 *
 *  (i, j) = dp[j+1] - dp[i]
 *
 *  时间复杂度: O(n)
 *  空间复杂度: O(n)
 */
public class NumArray02 {

    private int[] dp;
    public NumArray02(int[] nums) {
        if (nums != null && nums.length > 0) {
            this.dp = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        // 0.过滤
        if (dp == null || i>j || i < 0 || j >= dp.length) {
            return -1;
        }

        return dp[j+1] - dp[i];
    }

}
