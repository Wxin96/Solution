package com.apollo.factorial.trailingZeroes;

/**
 *  172. 阶乘后的零
 *      考察: 数学问题
 *      思考:
 *          1.5*偶数=10,偶数足够多, 只考虑5即可
 *          2.25是5*5, 125是5*5*5
 *      总结:
 *          一个数含有5的倍数个数 + 含有25个数的倍数 + 含有125的个数.....
 */
public class TrailingZeroes {
    // 1.递归
    // 时间复杂度: O(log5(n))
    // 空间复杂度: O(log5(n))
    public int trailingZeroes(int n) {
        // 0.递归终止
/*        if (n == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);*/
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    // 2.迭代
    // 时间复杂度: O(log5(n))
    // 空间复杂度: O(1)
    public int trailingZeroes02(int n) {
        // 1.初始化变量
        int cnt = 0;
        // 2.迭代
        while (n > 0) {
            cnt += n/5;
            n = n / 5;
        }
        return cnt;
    }

}
