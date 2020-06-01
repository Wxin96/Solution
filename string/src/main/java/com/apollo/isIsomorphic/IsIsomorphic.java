package com.apollo.isIsomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 *  205.同构字符串
 *  说明:
 *      你可以假设 s 和 t 具有相同的长度。
 *  想法:
 *      一开始想记录字母的出现个数, 并对两字符串进行比较, 但是这种方式会出现不同构的也具有类似的性质.
 */
public class IsIsomorphic {
    // 1.哈希映射
    // 时间复杂度: O(n)  n:字符串长度
    // 空间复杂度: O(s)  s:字符集长度
    // 记录对应字符, 上次出现的位置
    public boolean isIsomorphic(String s, String t) {
        // 0.过滤
        if (s == null && t == null) {
            return true;
        }
        // 1.初始化数据
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        // 2.遍历
        for (int i = 0; i < s.length(); i++) {
            // a.找到i位置的字符
            char sIndex = s.charAt(i);
            char tIndex = t.charAt(i);
            // b.检查上次出现位置是否相同
            if (sMap[sIndex] != tMap[tIndex]) {
                return false;
            }
            // c.记录上次出现的位置
            sMap[sIndex] = i + 1;
            tMap[tIndex] = i + 1;
        }
        // 3.返回
        return true;
    }


    // 2.哈希键值映射
    // 注意: 左右对应, 一一对应, 一对多不对;
    // 时间复杂度: O(n)  n:字符串长度
    // 空间复杂度: O(n)
    public boolean isIsomorphic02(String s, String t) {
        // 0.过滤
        if (s == null && t == null) {
            return true;
        }
        // 1.左右都映射
        return isIsomorphicHelper(s, t)&&isIsomorphicHelper(t, s);
    }

    // s <=> t 需要互相对应
    // "abb" => "ccc"
    public boolean isIsomorphicHelper(String s, String t) {
        // 1.初始化数据
        Map<Character, Character> map = new HashMap<>();
        // 2.遍历
        for (int i = 0; i < s.length(); i++) {
            // a.提取对应元素
            char sElement = s.charAt(i);
            char tElement = t.charAt(i);
            // b.检查是否粗在映射关系
            if (map.containsKey(sElement)) {
                // 映射是否一致
                if (map.get(sElement) != tElement) {
                    return false;
                }
            } else {
                map.put(sElement, tElement);
            }
        }
        // 3.返回
        return true;
    }

}
