package com.apollo.conversion.convertToBase7;

/**
 *  504. 七进制数
 *      1.利用API
 *      2.根据进制的性质
 */
public class ConvertToBase7 {
    // 1.使用API
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    // 2.进制转换
    // 时间复杂度: O(log7(num))
    // 空间复杂度: O(log7(num))
    public String convertToBase7o2(int num) {
        // 0.零
        if (num == 0) {
            return "0";
        }
        // 1.初始化数据
        StringBuilder sbd = new StringBuilder();
        int value = num > 0 ? num : -num;
        // 2.迭代
        while (value != 0) {
            sbd.append(value % 7);
            value /= 7;
        }
        // 3.反转
        sbd.reverse();

        return num > 0 ? sbd.toString() : "-" + sbd.toString();
    }
}
