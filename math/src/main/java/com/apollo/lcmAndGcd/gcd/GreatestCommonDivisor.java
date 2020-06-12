package com.apollo.lcmAndGcd.gcd;

/**
 *  2.最大公约数
 *      1.辗转相除法. 欧几里得算法
 *      2.九章算术,辗转相减法
 *      3.位操作(右移, 除以质数(2))
 */
public class GreatestCommonDivisor {
    // 1.辗转相除法
    // x = ky + b => x与y最大公约数 和 y与b最大公约数相同
    // a.除数, 余数
    // b.直至余数=0, 返回此时的除数
    // 模运算消耗计算机资源大
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 2.辗转相减法
    // 原理: x与y最大公约数 和 (x-y)和y的最大公约数相同
    // 省去了模运算, 但是递归次数比前者大
    public int gcd02(int a, int b) {
        if (a < b) {
            return gcd02(b, a);
        }
        return b == 0 ? a : gcd02(a- b, b);
    }

    // 3.使用位操作和减法求解最大公约数
    // 思想:
    //  f(y, x) = k*f(y1, x1)
    //  f(x, y) = f(p*x1, y) = f(x1, y) p为素数
    //  在这里p取2, 采用算数右移表示除法
    public int gcd03(int a, int b) {
        // 1.避免负数产生
        if (a < b) {
            return gcd03(b, a);
        }
        // 2.递归终止
        if (b == 0) {
            return a;
        }
        // 3.a为偶数/奇数
        if (isEven(a)) {
            //b的两种情况
            if (isEven(b)) {
                return gcd03(a >> 1, b >> 1) << 1;
            } else {
                return gcd03(a >> 1, b);
            }
        } else {
            //b的两种情况
            if (isEven(b)) {
                return gcd03(a, b >> 1);
            } else {
                return gcd03(a-b, b);
            }
        }
    }
    // 位运
    private boolean isEven(int n) {
        return (n & 1) != 1;
    }
}
