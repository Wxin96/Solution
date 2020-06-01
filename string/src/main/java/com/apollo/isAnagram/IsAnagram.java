package com.apollo.isAnagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  242.有效的字母异位词(两个单词包含相同的字母，但是次序不同)
 *  本题目两种解决方法,
 *      1. 哈希表映射
 *      2. 排序
 *  其中, 哈希表映射方法是优于排序的. 排序算法时间复杂度n*log2(n)
 */
public class IsAnagram {
    // 1.哈希表(HashMap)
    // 思想: 字符串建立映射关系
    // 时间复杂度: O(n)  n:字符串长度
    // 空间复杂度: O(n)
    public boolean isAnagram(String s, String t) {
        // 0.过滤
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        // 1.初始化数据
        Map<Character, Integer> map = new HashMap<>();
        // 2.第一次遍历
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 3.第二次遍历
        for (char c : t.toCharArray()) {
            // a.是否有这个元素
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        // 4.第三次遍历
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    // 2.使用数组进行哈希映射
    // 此处体现了, 如果元素有穷，并且范围不大，那么可以用一个布尔数组来存储一个元素是否存在。
    // 例如对于只有小写字符的元素，就可以用一个长度为 26 的布尔数组来存储一个字符集合，使得空间复杂度降低为 O(1)。
    // 时间复杂度: O(n)  n:字符串长度
    // 空间复杂度: O(n)
    public boolean isAnagram02(String s, String t) {
        // 0.过滤
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        // 1.初始化数据
        int[] cnt = new int[26];
        // 2.第一次遍历
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        // 3.第二次遍历
        for (char c : t.toCharArray()) {
            cnt[c - 'a']--;
        }
        // 4.第三次遍历
        for (int num : cnt) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    // 3.排序
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(n)
    public boolean isAnagram03(String s, String t) {
        // 0.过滤
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        // 1.初始化数据
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        // 2.排序
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        // 3.返回
        // 优化
        // return Arrays.toString(sArray).equals(Arrays.toString(tArray));
        return Arrays.equals(sArray, tArray);
    }

    // 4.使用数组进行哈希映射
    // 时间复杂度: O(n)  n:字符串长度
    // 空间复杂度: O(1)
    public boolean isAnagram04(String s, String t) {
        // 0.过滤
        if (s.length() != t.length()) {
            return false;
        }
        // 1.初始化数据
        int[] cnt = new int[26];
        // 2.两次遍历, 合二为一
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        // 3.Lambda表达式
        return Arrays.stream(cnt).allMatch(x -> x==0);
    }
}
