package com.apollo.nextGreatestLetter;

public class NextGreatestLetter {
    // 二分法
    // 时间复杂度: O(log2(n))    n:为letters的数目
    // 空间复杂度的: O(1)
    // 寻找结束: l > r
    // 分析: 此处二分查找比target大的元素, 即使等于target也不能停留
    public char nextGreatestLetter(char[] letters, char target) {
        // 0.过滤
        if (letters == null) {
            return ' ';
        }
        // 1.指针初始化
        int left = 0;
        int right = letters.length - 1;
        // 2.查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left>right);
        return letters[left%letters.length];
    }

    public char nextGreatestLetter02(char[] letters, char target) {
        // 0.过滤
        if (letters == null) {
            return ' ';
        }
        // 1.指针初始化
        int left = 0;
        int right = letters.length - 1;
        // 2.查找
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left=right);
        return letters[left%letters.length];
    }
}
