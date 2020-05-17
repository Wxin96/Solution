package com.apollo.maxSubArray;

/**
 * 53. 最大子序和
 *  分治算法[怎么写?]
 */
public class MaxSubArray {
    // 1.贪心算法(动态规划)
    // 想到了是前n项和, 但是不知道怎么处理, 怎么保证最大序列.
    // 从索引0开始累加序列, 当累加<0时, 重新选择新的序列; 迭代中记录序列累加最大值
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int maxSubArray(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.变量初始化
        int curPathSum = nums[0];
        int maxSum = curPathSum;
        // 2.迭代
        for (int i = 1; i < nums.length; i++) {
            curPathSum = (curPathSum > 0) ? curPathSum + nums[i] : nums[i];
            maxSum = Math.max(curPathSum, maxSum);
        }
        // 3.返回值
        return maxSum;
    }
}
