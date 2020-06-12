package com.apollo.majorityElement;

import java.util.Arrays;

/**
 *  169. 多数元素
 *      解法:
 *          1.暴力解法
 *          2.哈希表
 *          3.随机化(统计学)
 *          4.分治算法
 *          5.摩尔投票
 */
public class MajorityElement {
    // 1.排序
    // 问题没有利用 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素 性质。
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)
    public int majorityElement(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length <1) {
            return -1;
        }
        // 1.排序
        Arrays.sort(nums);
        // 2.遍历
        int curLen = 1;
        int maxLen = 0;
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // a.当前元素和前一元素相等
            if (nums[i - 1] == nums[i]) {
                curLen++;
            } else {
                // b.不相等重置
                curLen = 1;
            }
            // c.如果当前长度超过最大长度
            if (curLen > maxLen) {
                maxLen = curLen;
                target = nums[i];
            }
        }
        return target;
    }

    // 2.Boyer-Moore Majority Vote Algorithm
    // 充分利用多数元素过半数的性质   [妙]
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int majorityElement02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length <1) {
            return -1;
        }
        // 1.初始化变量
        int cnt = 0;
        int target = 0;
        // 2.遍历
        for (int num : nums) {
            target = cnt == 0 ? num : target;
            cnt = target == num ? cnt + 1 : cnt - 1;
        }

        return target;
    }
}
