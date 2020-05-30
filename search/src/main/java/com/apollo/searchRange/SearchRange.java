package com.apollo.searchRange;

public class SearchRange {
    // 1.二分查找
    // 时间复杂度: O(n) 最差情况 数组的n个元素都相同
    // 空间复杂度: O(1)
    public int[] searchRange(int[] nums, int target) {
        // 0.过滤
        if (nums == null || nums.length <1) {
            return new int[]{-1, -1};
        }
        // 1.查找左边第一个元素
        // first可能等于target, 也可能不等于
        int first = findFirst(nums, target);
        if (target == nums[first]) {
            int last = first;
            while (last+1<nums.length && nums[last + 1] == target) {
                last++;
            }
            return new int[] {first, last};
        }
        // fist位置不等于target
        return new int[] {-1, -1};
    }

    // 寻找元素的第一个值
    // a. 若元素存在, 寻找左第一索引
    // b. 若元素不存在, 位于数组中第一次大于该元素
    // c. [x,y,z]为升序数组, 0 -(-∞, x] 1 -(x, y] 2-(y, +∞)
    private int findFirst(int[] nums, int target) {
        // 1.左右指针
        int left = 0, right = nums.length - 1;
        // 2.查找
        while (left < right) {
            // a.中间指针(偏左)
            int mid = left + (right - left) / 2;
            // b.右指针站住
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 3.返回
        return left;
    }

    // 2.二分法
    // 时间复杂度: O(log2(n))
    // 空间复杂度: O(1)
    public int[] searchRange02(int[] nums, int target) {
        // 0.过滤
        if (nums == null || nums.length <1) {
            return new int[]{-1, -1};
        }
        // 1.查询
        int first = findFirst02(nums, target);
        int last = findFirst02(nums, target + 1) - 1;
        // 2.判断
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[] {first, Math.max(first, last)};
        }
    }

    // 寻找元素的第一个值
    // a. 若元素存在, 寻找左第一索引
    // b. 若元素不存在, 位于数组中第一次大于该元素
    // c. [x,y,z]为升序数组, 0 -(-∞, x] 1 -(x, y] 2-(y, z] 3-(z, +∞)
    private int findFirst02(int[] nums, int target) {
        // 1.左右指针
        int left = 0, right = nums.length;
        // 2.查找
        while (left < right) {
            // a.中间指针(偏左)
            int mid = left + (right - left) / 2;
            // b.右指针站住
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 3.返回
        return left;
    }
}
