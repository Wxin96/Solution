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

}
