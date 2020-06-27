package com.apollo.singleNonDuplicate;

/**
 * 540.有序数组的单一元素
 */
public class SingleNonDuplicate {
    // 1.二分查找
    // 时间复杂度: O(log2(n))
    // 空间复杂度: O(1)
    // 核心: 单数在中间一对的奇数一边, 或者中间数就是单数
    public int singleNonDuplicate(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 1.左右指针
        int left = 0, right = nums.length - 1;
        // 2.查找
        while (left < right) {
            // a.指针变量
            int mid = left + (right - left) / 2;    // 中间值
            // b. mid和左值相等
            if (nums[mid - 1] == nums[mid]) {
                // i.左边
                if ((mid - 1 - left) % 2 == 1) {
                    right = mid - 2;
                } else {
                    // ii.右边
                    left = mid + 1;
                }
            } else if (nums[mid + 1] == nums[mid]) {
            // c. mid和右值相等
                // i.右边
                if ((right - (mid + 1)) % 2 == 1) {
                    left = mid + 2;
                } else {
                    // ii.左边
                    right = mid - 1;
                }
            }
            else {
                return nums[mid];
            }
        }
        // 3.输出
        return nums[left];
    }

    // 2.更优雅的二分算法
    // 仅对偶数索引进行二分搜索
    // 时间复杂度: O(log2(n))
    // 空间复杂度: O(1)
    // 核心思想:
    // 利用奇偶性值, 确定独数的位置, 直至找到
    public int singleNonDuplicate02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 1.初始化指针变量
        int left = 0, right = nums.length - 1;
        // 2.查找
        while (left < right) {
            // a.中指针
            int mid = left + (right - left) / 2;
            // b.判断是否是偶数
            // 是则罢了, 不是需改造
            mid = (mid % 2 == 0) ? mid : mid - 1;
            // c.mid 和 mid+1的关系
            if (nums[mid] == nums[mid + 1]) {
                // i.独数在mid+1后
                left = mid + 2;
            } else {
                // ii.独数在mid位置前或者就在mid位置
                right = mid;
            }
        }
        // 3.返回
        return nums[left];
    }
}
