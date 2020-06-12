package com.apollo.other.isPerfectSquare;

/**
 *  367. 有效的完全平方数
 *      完全平方数性质: 完全平方数=sqrt(n)个奇数相加
 *      处理int溢出: long*int, 有一个数需要先进制转换(long)
 */
public class IsPerfectSquare {
    // 1.利用完全平方数的性质: 完全平方数=sqrt(n)个奇数相加
    // 时间复杂度: O(sqrt(n))
    // 空间复杂度: O(1)
    public boolean isPerfectSquare(int num) {
        // 0.过滤
        if (num < 0) {
            return false;
        }
        // 1.初始化数据
        int odd = 1;
        // 2.迭代
        while (num > 0) {
            num -= odd;
            odd += 2;
        }
        return num == 0;
    }

    // 2.二分查找
    // 处理整数溢出问题
    // 时间复杂度: O(log2(n))
    // 效率优于前者
    // 空间复杂度: O(1)
    public boolean isPerfectSquare02(int num) {
        // 0.过滤
        if (num < 0) {
            return false;
        }
        // 1.初始化数据
        int l = 0, h = num;
        // 2.迭代
        while (l <= h) {
            int mid = (l + h) >>> 1;
            // int*int => int
            // long*int => long
            // 强制转换符() 优先级 > *优先级
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square < num){
                l = mid + 1;
            } else if (square > num) {
                h = mid -1;
            }
        }
        return false;
    }

    // 3.牛顿迭代法
    // 时间复杂度: O(log2(n))
    // 空间复杂度: O(1)
    public boolean isPerfectSquare03(int num) {
        // 0.过滤
        if (num < 2) {
            return true;
        }
        // 1.初始化数据
        // int可能存在整数溢出
        long x = num / 2;
        // 2.迭代
        while (x * x > num) {
            x = (x + num/x)/2;
        }

        return x*x==num;
    }

}
