package com.apollo.findLHS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 */
public class FindLHS {
    // 1.HashSet法(哈希映射)
    //  两次扫描
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int findLHS(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.初始化数据结构
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        // 2.一次迭代
        Arrays.stream(nums)
                .forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        // 3.二次迭代
        for (Integer element : map.keySet()) {
            int curSum = 0;
            if (map.containsKey(element - 1)) {
                curSum = map.get(element)
                        + map.getOrDefault(element-1,0);
            }
            max = Math.max(max, curSum);
        }
        // 4.输出结果
        return max;
    }

    // 2.哈希映射 + 单次扫描
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 数据不完整, 需要左右逢源
    public int findLHS02(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.初始化数据
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        // 2.迭代
        for (int num : nums) {
            // a.填元素
            map.put(num, map.getOrDefault(num, 0) + 1);
            // b.左
            if (map.containsKey(num - 1)) {
                max = Math.max(max, map.get(num) + map.get(num - 1));
            }
            // c.右
            if (map.containsKey(num + 1)) {
                max = Math.max(max, map.get(num) + map.get(num + 1));
            }
        }
        // 3.输出结果
        return max;
    }

}
