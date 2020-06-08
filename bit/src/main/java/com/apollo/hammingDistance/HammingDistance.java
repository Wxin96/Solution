package com.apollo.hammingDistance;

/**
 *  461. 汉明距离
 *  解题思路:
 *      异或, 求1的个数
 */
public class HammingDistance {
    // 1.位运算 + API
    // 异或运算中1的个数, 为它们之间的汉明距离.
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // 2.异或运算, 不使用API
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public int hammingDistance02(int x, int y) {
        // 1.异或运算
        int z = x ^ y;
        // 2.统计z中的"1"的个数
        int cnt = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                cnt++;
            }
            z = z >> 1;
        }

        return cnt;
    }

    // 3.异或运算, 不使用API
    // 通过z &= (z - 1);去除最后一位1
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public int hammingDistance03(int x, int y) {
        // 1.异或运算
        int z = x ^ y;
        // 2.统计z中的"1"的个数
        int cnt = 0;
        while (z != 0) {
            z &= (z - 1);
            cnt++;
        }

        return cnt;
    }
}
