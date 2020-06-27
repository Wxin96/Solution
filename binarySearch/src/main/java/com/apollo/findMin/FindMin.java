package com.apollo.findMin;

public class FindMin {
    // 1.二分查找
    // 时间复杂度: O(log2(N))
    // 空间复杂度: O(1)
    // 思想: 二分法:二分区间, 舍弃一半, 目标在另一半
    public int findMin(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.初始化指针
        int left = 0, right = nums.length-1;    /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
        // 2.查找
        while (left < right) {                  /* 循环不变式，如果left == right，则循环结束 */
            // a.中间指针
            int mid = left + (right - left) / 2;/* 地板除，mid更靠近left */
            // b.中间值
            if (nums[mid] > nums[right]) {      /* 中值 > 右值，最小值在右半边，收缩左边界 */
                left = mid + 1;                 /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
            } else {                            /* 明确中值 < 右值，最小值在左半边，收缩右边界(原题目为升序数组旋转) */
                right = mid;                    /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
            }

        }
        // 3.返回结果
        return nums[left];                      /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */
    }

    // 2.遍历法
    // 时间复杂度: O(n)
    // 空间复杂度都: O(1)
}
