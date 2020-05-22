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

    // 2.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 思想: 当前节点dp[i]时当前数字, 要么是与前面的最大子序列和, 要么是当前节点
    // dp[i]表示nums中nums[i]结尾的最大子序列和
    // dp[i] = max(dp[i-1]+nums[i], nums[i])
    public int maxSubArray02(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.变量初始化
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        // 2.遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        // 3.结束, 返回最大值
        return max;
    }

    // 3.分治算法
    // 取数组中心点为中心
    // 最大子序要么全在中心左边
    // 要么在右边, 要么跨中心
    // 分三种情况进行考虑
    // 时间复杂度: O(nlog2(n))
    // 空间复杂度: O(log2(n))
    public int maxSubArray03(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.递归
        return maxSubArray(0, nums.length-1, nums);
    }

    private int maxSubArray(int start, int end, int[] nums) {
        // 0.递归终止
        if (start == end) {
            return nums[start];
        }
        // 1.最大子序列的几种情况
        int mid = (start + end) / 2;

        int left = maxSubArray(start, mid, nums);
        int right = maxSubArray(mid + 1, end, nums);
        int leftRight = getContainMidMax(start, end, mid, nums);

        // 2.返回值
        left = Math.max(left, leftRight);
        return Math.max(left, right);
    }


    private int getContainMidMax(int start, int end, int mid, int[] nums) {
        // 初始化为Integer.MIN_VALUE
        // int leftSum = Integer.MIN_VALUE;
        int leftSum = Integer.MIN_VALUE;
        // 找左边最大
        int sum = 0;
        for (int i = mid; i >=start ; i--) {
            sum += nums[i];
            leftSum = Math.max(sum, leftSum);
        }

        // 找右边最大
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid+1; i <= end; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

}
