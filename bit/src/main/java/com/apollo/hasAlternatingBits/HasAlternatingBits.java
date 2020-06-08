package com.apollo.hasAlternatingBits;

/**
 *  693. 交替位二进制数
 *
 */
public class HasAlternatingBits {
    // 1.位运算
    // 思想: 充分利用交替二进制数的性质, 错位异或, 构成末尾全1
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean hasAlternatingBits(int n) {
        // 1.构造互补数
        int m = n >> 1;
        // 2.二者异或
        int mnXor = m ^ n;
        return Integer.bitCount(mnXor + 1) == 1;
    }

    // 2.位运算
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean hasAlternatingBits02(int n) {
        // 1.构造互补数
        int m = n >> 1;
        // 2.二者异或
        int mnXor = m ^ n;
        return (mnXor + 1 & mnXor) == 0;
    }

    // 3.转化为字符串

    // 4.数学方法, %2 /2 不相等, 右移数直至为0
}
