package com.apollo.longestPalindrome;

import java.util.Map;
import java.util.stream.Collectors;

/**
 *  409.最长回文串
 *  分析题目得, 最长回文串为: 每个字母的最大偶数值相加, 如果有剩余元素, 可+1放在中间.
 *  解决题目的方式, 哈希映射.
 */
public class LongestPalindrome {
    // 1.哈希映射
    // 时间复杂度: O(n)  n:字符串的长度
    // 空间复杂度: O(s)  s:字符集大小
    // 小技巧: i - (i&1)
    public int longestPalindrome(String s) {
        // 0.过滤
        if (s == null || s.length() < 1) {
            return 0;
        }
        // 1.映射表
        int[] cnt = new int[58];
        int length = 0;
        // 2.遍历字符串
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        // 3.遍历数组
        for (int i : cnt) {
            // a.第一种方式
            // length += (i%2==0) ? i : i-1;
            // b.第二种方式
            length += i - (i&1);
        }
        // 4.返回
        return (length == s.length()) ? length : length + 1;
    }

    public int longestPalindrome02(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length() ? ans + 1 : ans;
    }

}
