package com.apollo.merge;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 0.过滤
        if (n == 0 || nums2 == null || nums2.length == 0) {
            return;
        }
        // 1.初始化指针
        int nums1_right = m - 1;
        int nums2_right = n - 1;
        int final_right =m + n -1;
        // 2.遍历
        while (final_right >= 0) {
            while (nums2_right >= 0 && (nums1_right==-1 || nums2[nums2_right] >= nums1[nums1_right])) {
                nums1[final_right--] = nums2[nums2_right--];
            }
            while (nums1_right >= 0 && (nums2_right==-1 || nums2[nums2_right] < nums1[nums1_right])) {
                nums1[final_right--] = nums1[nums1_right--];
            }
        }

        // for (int i = final_right; i >= 0; i--) {
        //     if (nums2[nums2_right] >= nums1[nums1_right]) {
        //         nums1[final_right--] = nums2[nums2_right--];
        //     } else {
        //         nums1[final_right--] = nums1[nums1_right--];
        //     }
        // }

    }
}
