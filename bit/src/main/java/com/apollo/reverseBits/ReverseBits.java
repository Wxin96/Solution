package com.apollo.reverseBits;

import java.util.HashMap;
import java.util.Map;

/**
 *  190. 颠倒二进制位
 *      位运算有很多, 异或 算数左移 算数右移 无符号右移 与或非
 *      多次调用, 查表思想[static关键字]
 *      分治算法-局部与整体旋转思想
 */
public class ReverseBits {
    // you need treat n as an unsigned value

    // 1.利用API
    // 2转, 4转, 8转, 4个8反转
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    // 2.位运算取反
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public int reverseBits02(int n) {
        // 1.初始化变量
        int ret = 0;
        // 2.遍历
        for (int i = 0; i < 32; i++) {
            // ret = ret << 1;
            ret <<= 1;
            ret |= (n & 1);
            n >>>= 1;
        }

        return ret;
    }


    // a.进阶 如果多次调用这个函数，你将如何优化你的算法？
    // 如果该函数需要被调用很多次，可以将 int 拆成 4 个 byte，然后缓存 byte 对应的比特位翻转，最后再拼接起来。
    // 另外建表, 方便以后查询提高效率
    // 使用static随类加载创建
    // 时间复杂度: O(1)
    // 空间复杂度: O(2^8=265) -> O(1)
    private static Map<Byte, Integer> cache = new HashMap<>();

    public int reverseBits03(int n) {
        // 1.初始化变量
        int ret = 0;
        // 2.遍历
        for (int i = 0; i < 4; i++) {
            ret <<= 8;
            ret |= reverseByte((byte) (n & 0b11111111));
            n >>>= 8;
        }
        return ret;
    }

    private int reverseByte(byte b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        }
        // 1.初始化变量
        int ret = 0;
        // 2.遍历
        for (int i = 0; i < 8; i++) {
            ret <<= 1;
            ret |= (b & 1);
            b >>>= 1;
        }
        return ret;
    }

    // 3.乾坤大挪移(分治算法)
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public int reverseBits04(int n) {
        n = (n >>> 16) & 0x0000ffff | (n << 16) & 0xffff0000;
        n = (n >>> 8)  & 0x00ff00ff | (n << 8)  & 0xff00ff00;
        n = (n >>> 4)  & 0x0f0f0f0f | (n << 4)  & 0xf0f0f0f0;
        n = (n >>> 2)  & 0x33333333 | (n << 2)  & 0xcccccccc;
        n = (n >>> 1)  & 0x55555555 | (n << 1)  & 0xaaaaaaaa;
        return n;
    }
}