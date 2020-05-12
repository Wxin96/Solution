package com.apollo.frequencySort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {

    public String frequencySort(String s) {
        // 0.过滤
        if (s == null || s.length()<3) {
            return s;
        }
        // 1.哈希表初始化
        // 空间复杂度: <O(n)
        Map<Character, Integer> map = new HashMap<>();
        // 空间复杂度: O(n)
        char[] chars = s.toCharArray();

        // 2.迭代, 存表
        // 时间复杂度: O(n)
        for (char aChar :chars){
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        // System.out.println(map);

        // 3.桶初始化
        // 空间复杂度: O(n)
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        // 4.装桶
        // 时间复杂度: <O(n)
        for (Character character : map.keySet()) {
            if (bucket[map.get(character)] == null) {
                bucket[map.get(character)] = new ArrayList<>();
            }
            bucket[map.get(character)].add(character);
        }

        // 5.出桶
        // 空间复杂度: O(n)
        char[] result = new char[s.length()];
        int count = 0;

        for (int i = s.length(); i >= 0; i--) {
            if (bucket[i]==null){
                continue;
            }
            for (Character character : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    result[count++] = character;
                }
            }
        }


        return new String(result);
    }
}
