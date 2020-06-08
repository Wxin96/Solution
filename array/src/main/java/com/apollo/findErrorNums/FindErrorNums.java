package com.apollo.findErrorNums;

/**
 * 645. 错误的集合
 *  说明:
 *      1.给定数组的长度范围是 [2, 10000]。
 *      2.给定的数组是无序的。
 *
 *      数组: 0-(n-1)
 *      元素: 1-n
 *      数组索引和元素是线性关系
 *
 */
public class FindErrorNums {
    // 1.诸神归位
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int[] findErrorNums(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 2) {
            return null;
        }
        // 1.第一次遍历
        for (int i = 0; i < nums.length; i++) {
            // 此处是while, 因为可能置换的位置也不对, 恰好被重复元素阻挡
            while (i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 2.第二次遍历
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return new int[]{nums[i], i + 1};
            }
        }

        return null;
    }

    private void swap(int[] nums, int l1, int l2) {
        if (nums != null && l1 < nums.length && l2 < nums.length) {
            int temp = nums[l1];
            nums[l1] = nums[l2];
            nums[l2] = temp;
        }
    }

    // 2.排序
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)

}
