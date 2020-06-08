package com.apollo.getSum;

/**
 * 371. 两整数之和
 *  思路：
 *      1.当位相加 =》 &操作
 *      2.计算进位 =》 先^后<<
 *      3.不停迭代直至 进位==0
 */
public class GetSum {
    // 1.位操作
    // 时间复杂度: O(n)  a和b的初始进位数目
    // 空间复杂度: O(1)
    public int getSum02(int a, int b) {
        // 1.初始化变量

        // 2.迭代
        while (b != 0) {
            a = a ^ b;
            b = ((a ^ b) & b) << 1;
        }

        return a;
    }

    // 2.递归     [妙]
    // 时间复杂度: O(n)  a和b的初始进位数目
    // 空间复杂度: O(1)
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
