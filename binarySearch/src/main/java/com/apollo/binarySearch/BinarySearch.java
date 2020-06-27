package com.apollo.binarySearch;

/**
 *  二分查找
 */
public class BinarySearch {

    public int binarySearch(int[] nums, int key) {
        int l = 0, h = nums.length-1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    // 二分查找的变形
    // 寻找最左边元素
    // 思路: high站稳脚跟在mid上, low突进mid+1,
    // 存在问题:
    //      无法检测不存在的数, 会出现错误
    // 结束条件: l = h
    public int binarySearch02(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= key) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    // 二分查找的变形
    // 寻找最右边元素
    // 结束条件: l=h
    public int binarySearch03(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l + 1) / 2;
            if (nums[m] <= key) {
                l = m;
            } else {
                h = m - 1;
            }
        }
        System.out.println(l==h);
        return h;
    }

    // 二分查找
    // 寻找最左边的元素(另一种形式)
    public int binarySearch04(int[] nums, int key) {
        // 1.指针初始化(闭区间)
        int left = 0, right = nums.length - 1;
        // 2.查找
        while (left <= right) {
            // a.中间指针
            int mid = left + (right - left) / 2;
            // b.mid值与target的三种不同情况
            if (nums[mid] == key) {
                right = mid -1;
            } else if (nums[mid] < key) {
                left = mid + 1;
            } else if (nums[mid] > key) {
                right = mid -1;
            }
        }
        // 3.left范围[0, nums.length]
        if (left == nums.length || nums[left] != key) {
            return -1;
        }
        return left;
    }

}
