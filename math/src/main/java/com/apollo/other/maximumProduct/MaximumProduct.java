package com.apollo.other.maximumProduct;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 628. 三个数的最大乘积
 *      教训: 一开始未考虑负数的问题, 错误判断找三个最大的数
 *      思路:
 *          最大三个数相乘 or 最小二数*最大一数(负负得正)
 *          1.排序
 *          2.一次遍历, 中间变量记录
 */
public class MaximumProduct {
    // 1.堆结构
    // 错误: 未考虑负数
    // 反思: 最大数为 三个最大相乘 | 两个最小*最大
    public int maximumProduct(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 3) {
            return -1;
        }
        // 1.初始化数据
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 2.遍历
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() >= 4) {
                heap.poll();
            }
        }

        return heap.stream().reduce(1, (x, y) -> x * y);
    }

    // 2.排序
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)
    public int maximumProduct02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 3) {
            return -1;
        }
        // 1.排序
        int lastIndex = nums.length - 1;
        Arrays.sort(nums);
        // 2.返回
        return Math.max(nums[lastIndex] * nums[lastIndex - 1] * nums[lastIndex - 2], nums[lastIndex] * nums[1] * nums[0]);
    }

    // 3.线性扫描
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int maximumProduct03(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 3) {
            return -1;
        }
        // 1.初始化指针
        int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max2;
        int min1 = Integer.MAX_VALUE, min2 = min1;
        // 2.线性遍历
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

}
