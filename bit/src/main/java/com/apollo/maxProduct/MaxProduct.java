package com.apollo.maxProduct;
/**
 * 318. 最大单词长度乘积
 *  利用位运算检查是否有重复元素
 *  小写字母有26个, int的长度为32位
 */
public class MaxProduct {
    // 1.位运算
    // 本题主要问题是判断两个字符串是否含有相同字符,
    // 由于字符串只含有小写字符, 总共26位, 因此可以用一个32位的整数来存储每个字符是否出现过
    // 时间复杂度: O(n^2) n:字符串的个数
    // 空间复杂度: O(n)
    public int maxProduct(String[] words) {
        // 0.过滤
        if (words == null || words.length < 2) {
            return 0;
        }
        // 1.数据初始化
        int[] ref = new int[words.length];
        // 2.第一次迭代
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                ref[i] |= 1 << (c-'a');
            }
        }
        // 3.第二次迭代
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((ref[i] & ref[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }

}
