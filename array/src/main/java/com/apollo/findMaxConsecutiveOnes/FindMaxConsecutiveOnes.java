package com.apollo.findMaxConsecutiveOnes;

/**
 *  485. 最大连续1的个数
 */
public class FindMaxConsecutiveOnes {
    // 1.一次遍历
    // 时间复杂度: O(n)   n: 数组元素数
    // 空间复杂度: O(1)
    // 问题:
    //      最后一个数需要多加一次处理, 不都优雅
    public int findMaxConsecutiveOnes(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.初始化变量
        int curLen = 0;
        int maxLen = 0;
        // 2.遍历
        for (int num : nums) {
            if (num == 1) {
                curLen++;
            } else {
                maxLen = Math.max(curLen, maxLen);
                curLen = 0;
            }
        }
        maxLen = Math.max(curLen, maxLen);
        return maxLen;
    }

    // 改善一
    // 末尾进行最后一次比较
    public int findMaxConsecutiveOnes02(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.初始化变量
        int curLen = 0;
        int maxLen = 0;
        // 2.遍历
        for (int num : nums) {
            if (num == 1) {
                curLen++;
            } else {
                maxLen = Math.max(curLen, maxLen);
                curLen = 0;
            }
        }
        return Math.max(curLen, maxLen);
    }

    // 改善二
    // 每一次都进行比较
    public int findMaxConsecutiveOnes03(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
