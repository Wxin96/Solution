package com.apollo.singleNumber;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 */
public class SingleNumber {
    // 1.三个数异或
    // 利用`x^x=0`的特点, 可以将三个数中重复的两个数去除, 只留下另一个数.
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (x, y) -> x ^ y);
    }

    // 2.三数异或
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int singleNumber02(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.遍历
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        return ret;
    }

    // 3.排序
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)
}
