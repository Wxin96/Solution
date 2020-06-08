package com.apollo.isPowerOfFour;

/**
 *  342. 4的幂
 *      灵活使用掩码操作
 */
public class IsPowerOfFour {
    // 1.位运算
    // num > 0
    // num能被2整除
    // num-1中1的个数能被2整除
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0 && Integer.bitCount(num - 1) % 2 == 0);
    }

    // 2.位运算+ 掩码
    // 修改第三个条件
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean isPowerOfFour02(int num) {
        return num > 0 && ((num & (num - 1)) == 0 && (num&0b01010101010101010101010101010101) != 0);
    }

    // 3.暴力法+预计算(查表)
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)

    // 4.数学运算, log2(num) 是2的整数倍
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)

    // 5.正则表达式
    public boolean isPowerOfFour03(int num) {
        String string = Integer.toString(num, 4);
        return string.matches("10*");
    }

}
