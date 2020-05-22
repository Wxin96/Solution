package com.apollo.partitionLabels;

import java.util.*;

public class PartitionLabels {
    // 1. 一点都不贪心的贪心算法
    // ​体会: 自己根据以前题目, 想出解法, 但要根据具体题目进一步优化.(具体问题, 具体分析, 不能盲目照搬)
    public List<Integer> partitionLabels(String S) {
        // 0.数据结构初始化
        List<Integer> list = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();
        // 1.过滤
        if (S == null) {
            return list;
        }
        // 2.迭代
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // a. map中没有chars[i]
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new int[]{i, i});
            } else {
                map.get(chars[i])[1] = i;
            }

        }
        // 3.转换为数组
        int[][] sections = new int[map.size()][];
        int index = 0;
        for (int[] value : map.values()) {
            sections[index++] = value;
        }
        // 4.数组排序
        Arrays.sort(sections, Comparator.comparingInt(x -> x[0]));
        // 5.迭代
        int start = sections[0][0];
        int end = sections[0][1];
        for (int[] section : sections) {
            // a.重叠
            if (section[0] <= end) {
                // 重新确定区间
                start = Math.min(start, section[0]);
                end = Math.max(end, section[1]);
            } else {
                list.add(end - start + 1);
                start = section[0];
                end = section[1];
            }
        }
        // 6.最后一组
        list.add(end - start + 1);

        return list;
    }

    // 1.贪心算法
    // 问题关键信息: 字母的开始位置(遍历时, 自然会找到), 字母的结束位置(一次遍历形成数组)
    // 终止条件: 在二次遍历中, 遍历值=end
    // 时间复杂度: O(n)  n:字符串s长度
    // 空间复杂度: O(n)  chars数组
    public List<Integer> partitionLabels02(String S) {
        // 0.数据结构初始化
        List<Integer> list = new ArrayList<>();
        int[] lastLocation = new int[26];
        // 1.过滤
        if (S == null) {
            return list;
        }
        // 2.遍历
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastLocation[chars[i] - 'a'] = i;
        }
        // 3.二次遍历
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, lastLocation[chars[i] - 'a']);
            if (end == i) {
                list.add(end - start + 1);
                start = i + 1;
            }
        }
        return list;
    }


}
