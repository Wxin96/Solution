package com.apollo.conversion.convertToTitle;

/**
 *  168. Excel表列名称
 *      考察: 数学
 *      [因为是从 1 开始计算的，而不是从 0 开始，因此需要对 n 执行 -1 操作。]
 *      0-9进制与A-Z进制, 后者是没有0的进制, 二者转换需要加入-1操作
 *
 */
public class ConvertToTitle {
    // 1.迭代
    // 时间复杂度: O(log26(n))
    // 空间复杂度: O(log26(n))
    public String convertToTitle(int n) {
        // 0.过滤
        if (n <= 0) {
            return null;
        }
        // 1.初始化数据
        StringBuilder sbd = new StringBuilder();
        // 2.迭代
        while (n != 0) {
            sbd.append((char) (--n % 26 + 'A'));
            n /= 26;
        }
        return sbd.reverse().toString();
    }

    // 2.递归
    // 时间复杂度: O(log26(n))
    // 空间复杂度: O(log26(n))
    public String convertToTitle02(int n) {
        // 0.过滤
        if (n == 0) {
            return "";
        }
        // 1.减一
        --n;
        // 2.递归传递
        return convertToTitle02(n / 26) + (char) (n % 26 + 'A');
    }

}
