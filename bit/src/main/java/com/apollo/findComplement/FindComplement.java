package com.apollo.findComplement;

/**
 *  476. 数字的补数
 *      1.掩码
 *      2.n^1s=~n   (1s位数是可以变的)
 */
public class FindComplement {
    // 1.位运算(掩码操作) + API
    // 先求掩码, 再求反码, 二者相与
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public int findComplement(int num) {
        // 1.掩码
        int highestOneBit = Integer.highestOneBit(num);
        int mask = (highestOneBit << 1) -1;

        return (~num)&mask;
    }

    // 2.位运算(掩码操作) + 自己寻找掩码
    public int findComplement02(int num) {
        // 1.掩码
        int mask = 1 << 30;
        // 2.迭代寻找
        while ((mask & num) == 0) {
            mask >>= 1;
        }
        mask = (mask << 1) -1;
        // [巧妙]
        return num^mask;
    }

    // 3.位操作(掩码操作) + 仿源码
    public int findComplement03(int num) {
        // 1.掩码
        int mask = num;
        // 2.迭代寻找
        mask |= mask>>1;
        mask |= mask>>2;
        mask |= mask>>4;
        mask |= mask>>8;
        mask |= mask>>16;

        // [巧妙]
        return num^mask;
    }
}
