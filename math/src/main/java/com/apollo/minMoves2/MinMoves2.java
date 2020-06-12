package com.apollo.minMoves2;

import java.util.Arrays;

/**
 *  462. 最少移动次数使数组元素相等 II
 *  解题思想:
 *      这题不用想什么中位数：设 a <= x <= b，将 a 和 b 都变化成 x 为最终目的，
 *      则需要步数为 x-a+b-x = b-a，即两个数最后相等的话步数一定是他们的差，x 在 a 和 b 间任意取；
 *      所以最后剩的其实就是中位数；那么直接排序后首尾指针计算就好：
 *  问题实质, 中位数是最优, 对于偶数数列, [pivot-1, pivot+1]区间任意整数都可以
 */
public class MinMoves2 {
    // 1.排序
    // 时间复杂度: O(nlog2(n))
    // 空间复杂度: O(log2(n))`   排序所需要的空间
    public int minMoves2(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.排序
        Arrays.sort(nums);
        // 2.迭代
        int l = 0, h = nums.length - 1;
        int cnt = 0;
        while (l < h) {
            cnt += nums[h--] - nums[l++];
        }
        return cnt;
    }

    // 2.快速选择, 寻找中位数
    // 时间复杂度: O(n)  最差O(n^2)
    // 空间复杂度: O(log2(n))
    public int minMoves2o2(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.寻找中位数
        int mid = findKthNum(nums, nums.length / 2);
        // 2.遍历
        int cnt = 0;
        for (int num : nums) {
            cnt += Math.abs(num - mid);
        }
        return cnt;
    }

    public int findKthNum(int[] nums, int k) {
        // 1.初始化指针
        int l = 0, h = nums.length - 1;
        // 2.二分寻找
        while (l < h) {
            // a.查找
            int temp = pivot(nums, l, h);
            if (temp == k) {
                break;
            } else if (temp < k) {
                l = temp + 1;
            } else if (temp > k) {
                h = temp -1;
            }
        }
        return nums[k];
    }

    public int pivot(int[] nums, int l, int h) {
        // 1.初始化变量
        int low = l, high = h + 1;
        // 2.快速排序
        while (true) {
            // a.左侧寻找比nums[l]大的元素
            while (nums[++low] < nums[l] && low < h);
            // b.右侧寻找比nums[l]小的元素
            while (nums[--high] > nums[l] && high > l);
            // c.low比high大
            if (low >= high) {
                break;
            }
            // b.满足交换条件
            swap(nums, low, high);
        }
        // 3.轴归位
        // high是比l小的
        swap(nums, l, high);
        return high;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
