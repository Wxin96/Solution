package com.apollo.sortColors;

public class SortColors {
    public void sortColors(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return;
        }
        // 1.初始化三指针
        int zero = -1, one = 0, two = nums.length;
        // 2.迭代
        while (one < two) {
            if (nums[one] == 0 && one != zero) {    // a.
                swap(nums, one, ++zero);
            } else if (nums[one] == 2) {    // b.交换, two左移动, one不能移动要判断交换后的数
                swap(nums, one, --two);
            } else {
                one++;                      // c.前两者都不符合, one右移动
            }
        }


    }

    // 交换元素
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortColors02(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return;
        }
        // 1.初始化三指针
        int zero = -1, one = 0, two = nums.length;
        // 2.迭代
        while (one < two) {
            if (nums[one] == 0) {    // a.
                swap(nums, one++, ++zero);  // a.左边都已经扫描过, 不过存在有2的情况
            } else if (nums[one] == 2) {    // b.交换, two左移动, one不能移动要判断交换后的数
                swap(nums, one, --two);
            } else {
                one++;                      // c.前两者都不符合, one右移动
            }
        }


    }

}
