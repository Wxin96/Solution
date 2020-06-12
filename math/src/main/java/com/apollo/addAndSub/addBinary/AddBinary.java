package com.apollo.addAndSub.addBinary;

/**
 *  67. 二进制求和
 *      考察: 数学 字符串 整数溢出
 */
public class AddBinary {
    // 1.直接操作字符串
    // 时间复杂度: O(n)  n:a,b字符串中, 长的
    // 空间复杂度: O(n)
    public String addBinary(String a, String b) {
        // 0.先决条件, 字符串的长度大于等于1
        // 1.初始化数据
        // 指针
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        StringBuilder sbd = new StringBuilder();
        int count = 0;  // 进位
        // 2.迭代
        while (count == 1 || pointerA >= 0 || pointerB >= 0) {
            // a.初始化
            int x = 0, y = 0;
            if (pointerA >= 0) {
                x = a.charAt(pointerA--) == '1' ? 1 : 0;
            }
            if (pointerB >= 0) {
                y = b.charAt(pointerB--) == '1' ? 1 : 0;
            }
            sbd.append((x + y + count) & 1);
            count = (x + y + count) >> 1;
        }
        return sbd.reverse().toString();
    }

    // 2.使用API
    // 存在整数溢出的问题
    public String addBinary02(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}
