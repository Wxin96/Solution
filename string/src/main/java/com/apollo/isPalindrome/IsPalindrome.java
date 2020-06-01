package com.apollo.isPalindrome;

/**
 *  9.回文数
 *      转换为"字符串"操作无脑
 *      利用回文数的特点, 采用右转置, 需要考虑数字中包含0的情况
 *
 *      整数的特点, 数中有0, 会降位数
 *      此处不需要处理溢出问题, 因为x是回文串, 它一定不会溢出
 */
public class IsPalindrome {
    // 1.数字转换为字符串
    // 时间复杂度: O(n)  n:数x占的位置(包括 (-))
    // 空间复杂度: O(n)
    public boolean isPalindrome(int x) {
        // 0.过滤
        if (x < 0) {
            return false;
        }
        // 1.数据初始化
        char[] chars = Integer.toString(x).toCharArray();
        int left = 0, right = chars.length - 1;
        // 2.遍历
        while (left < right) {
            // 判断左右是否相等
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }

        return true;
    }

    // 2.对数字进行取尾数和头数, 比较, 直至剩最后一个数字
    // 对于有零数字有问题, 比如 100041
    // 其实没有问题, 有位数的限制, 能保证首尾是对应的数字
    // 自己出问题的是: digit应该降低两位 /100
    // 时间复杂度: O(n)  n: x数的位数
    // 空间复杂度: O(1)
    public boolean isPalindrome02(int x) {
        // 0.过滤
        if (x < 0) {
            return false;
        }
        // 1.初始化变量
        int high = 0, low = 0;
        int digit = (int) Math.pow(10, (int)Math.log10(x));
        // 2.迭代
        // 判断为 x>0
        while (x > 0) {
            // a.找高位 低位
            high = x/digit;
            low = x%10;
            // b.判断
            if (high != low) {
                return false;
            }
            // c.变量更新
            x = x % digit;
            x /= 10;
            // 此处是处100
            digit /= 100;
        }

        return true;
    }

    // 3.根据回文数特性, 生成一个新的数字
    // 测试中, 10 100测试为true, 代码有bug
    // 要求不能使用额外空间, 也就不能将整数转化为字符串进行判断
    // 将整数分成左右两部分, 右边那部分需要转置, 然后判断这两部分是否相等
    // 时间复杂度: O(lg(x))
    // 空间复杂度: O(1)
    public boolean isPalindrome03(int x) {
        // 1.过滤(特殊情况处理)
        // a. 由于处理10的整数倍会涉及到0,因此需要提前处理
        if (x == 0) {
            return true;
        }
        // b.负数处理和10的整数倍处理(不包含0)
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        // 2.另一个数增长
        int num = 0;
        while (x > num) {
            // a.x减, num加
            num = num * 10 + x % 10;
            x /= 10;
        }

        // 3.比较
        // 偶数相等, 奇数num大
        return x == num || num / 10 == x;
    }
}
