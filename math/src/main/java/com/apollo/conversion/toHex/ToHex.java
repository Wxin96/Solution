package com.apollo.conversion.toHex;

/**
 * 405. 数字转换为十六进制数
 * 1.第一个问题, a-f的映射问题
 * 解决方式: 建立数组映射 索引-十六进制
 * 2.十六进制的独特性质, 除法通过位运算(右移4位)实现
 * 3.逻辑右移和判断不等于0完成迭代(负数是用补码形式)
 */
public class ToHex {

    // 1.位运算
    // 映射
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    private static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        // 0.处理是零的情况
        if (num == 0) {
            return "0";
        }
        // 1.数据初始化
        StringBuilder sbd = new StringBuilder();
        // 2.迭代
        while (num != 0) {
            sbd.append(map[num & 0x0f]);
            num >>>= 4;
        }

        return sbd.reverse().toString();
    }

    // 2.使用API
    public String toHex02(int num) {
        return Integer.toHexString(num);
    }
}
