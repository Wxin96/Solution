package com.apollo.missingNumber;

/**
 *  268. 缺失数字
 *      1.高斯求和(避免整数溢出问题)
 *      2.x^x=0 异或操作, 数组索引和元素组成重复
 *      不要因为与运算, 只想到与运算方法, 要扩展思路
 */
public class MissingNumber {
    // 1.总和-所有元素
    // 问题: 可能有整数溢出问题
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int missingNumber(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 1.计算总和
        int sum = (nums.length) * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

    // 2.与操作
    // 提示: 数组坐标索引也是数
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int missingNumber02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 1.计算总和
        int ret = 0;
        for (int i = 0; i <nums.length; i++) {
            ret ^= (i + 1) ^ nums[i];
        }

        return ret;
    }

    // 3.排序解法
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)

    // 4.哈希表映射
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
}
