package com.apollo.firstBadVersion;

public class FirstBadVersion extends VersionControl {
    // 1.二分查找
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 返回相同元素的最左边
    public int firstBadVersion(int n) {
        // 0.过滤
        if (n < 0) {
            return -1;
        }
        // 1.指针初始化
        int left = 0, right = n;
        // 2.查找
        while (left < right) {
            // a.中间指针
            int mid = left + (right - left) / 2;
            // b.mid是否是错误版本
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 3.返回结果
        return left;
    }
}
