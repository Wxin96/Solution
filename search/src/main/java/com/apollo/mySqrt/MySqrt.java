package com.apollo.mySqrt;

public class MySqrt {
    // 1.直接调用API
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    // 2.二分查找
    // 存在问题: int溢出问题(mid*mid)
    // 解法方法: 使用 除法(/)
    public int mySqrt02(int x) {
        // 0.过滤
        if (x < 0) {
            return -1;
        }
        // 1.指针初始化
        int left = 0;
        int right = x;
        // 2.查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid*mid <= x && (mid+1)*(mid+1) >x){
                return mid;
            }
            if (mid * mid < x) {
                left = mid+1;
            }
            if (mid * mid > x) {
                right = mid-1;
            }
        }
        return -1;
    }

    // 3.改造二分查找
    // 时间复杂度: O(log(x))
    // 空间复杂度: O(1)
    public int mySqrt03(int x) {
        // 0.特殊
        if (x < 2) {
            return x;
        }
        // 1.指针初始化
        int left = 0, right = x;
        // 2.查找
        while (left <= right) {
            int mid = left + (right - left)/2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            }
            if (mid > sqrt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public int mySqrt04(int x) {
        // 0.特殊
        if (x < 2) {
            return x;
        }
        // 1.指针初始化
        int left = 0, right = x;
        // 2.查找
        while (left < right-1) {
            int mid = left + (right - left)/2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            }
            if (mid > sqrt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
