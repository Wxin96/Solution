package com.apollo.isPowerOfTwo;

/**
 *  231. 2的幂
 *      去除最后一位1的妙用, n & (n - 1)
 *      保留最后一位1, n&(n-1) == n
 */
public class IsPowerOfTwo {
    // 1.位运算 + API
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean isPowerOfTwo(int n) {
        // 0.n需要大于零
        if (n <= 0) {
            return false;
        }
        // 1.只有一个1
        return Integer.bitCount(n) == 1;
    }

    // 2.利用 1000 & 0111 == 0 这种性质，得到以下解法：
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean isPowerOfTwo02(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 3.保留最后一位1, n&(n-1) == n
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean isPowerOfTwo03(int n) {
        return n > 0 && (n & (-n)) == n;
    }

}
