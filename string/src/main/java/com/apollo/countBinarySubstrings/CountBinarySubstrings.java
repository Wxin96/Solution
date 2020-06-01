package com.apollo.countBinarySubstrings;

import java.util.ArrayList;
import java.util.List;

/**
 *  696.计数二进制子串
 */
public class CountBinarySubstrings {
    // 1.利用链表
    // 问题转化:
    //  相邻0和1元素的最小个数叠加
    // 时间复杂度: O(n)  n: 字符串元素个数
    // 空间复杂度: O(n)
    public int countBinarySubstrings(String s) {
        // 0.过滤
        if (s == null || s.length()==1) {
            return 0;
        }
        // 1.初始化变量
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        char ref = s.charAt(0);
        // 2.遍历字符串
        for (char c : s.toCharArray()) {
            if (c == ref) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                ref = c;
            }
        }
        list.add(cnt);
        // 3.遍历数组
        cnt = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            cnt += Math.min(list.get(i), list.get(i + 1));
        }
        return cnt;
    }

    // 与自己开始的想法一一致, leetcode官网写的很优雅
    public int countBinarySubstrings03(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }


    // 2.一次遍历
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 缺少一种直觉判断, 初始方法可以优化, 多次遍历化为一次遍历
    public int countBinarySubstrings02(String s) {
        // 0.过滤
        if (s == null || s.length()==1) {
            return 0;
        }
        // 1.初始化变量
        int preLen = 0, curLen = 1, cnt = 0;
        // 2.遍历
        for (int i = 1; i < s.length(); i++) {
            // a.判断当前元素和上一个元素是否相等
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            // b.如果上一次元素长度大于等于现有长度, cnt++
            if (preLen >= curLen) {
                cnt++;
            }
        }
        return cnt;
    }
}
