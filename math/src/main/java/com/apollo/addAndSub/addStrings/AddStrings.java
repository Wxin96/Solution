package com.apollo.addAndSub.addStrings;

/**
 *  415. 字符串相加
 *      考察: 数学 字符串
 */
public class AddStrings {

    // 1.操作字符串
    // 时间复杂度: O(max(num1, num2))
    // 空间复杂度: O(max(num1, num2))
    public String addStrings(String num1, String num2) {
        // 0.过滤
        if (num1 == null && num2 == null) {
            return null;
        }
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        // 1.初始化数
        StringBuilder sbd = new StringBuilder();
        int pointerA = num1.length() - 1;
        int pointerB = num2.length() -1;
        int count = 0;
        // 2.迭代
        while (count == 1 || pointerA >= 0 || pointerB >= 0) {
            int x = 0, y = 0;
            if (pointerA >= 0) {
                x = num1.charAt(pointerA--) - '0';
            }
            if (pointerB >= 0) {
                y = num2.charAt(pointerB--) - '0';
            }
            sbd.append((x + y + count) % 10);
            count = (x + y + count) / 10;
        }

        return sbd.reverse().toString();
    }

}
