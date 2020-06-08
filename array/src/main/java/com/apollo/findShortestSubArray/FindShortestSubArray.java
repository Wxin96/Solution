package com.apollo.findShortestSubArray;

import java.util.HashMap;
import java.util.Map;

/**
 *  697. 数组的度
 *  利用三个哈希表(HashMap):
 *      第一个记录: 元素出现次数
 *      第二个记录: 元素第一次出现的位置
 *      第三个记录: 元素最后一次出现的位置
 */
public class FindShortestSubArray {
    // 1.哈希记录
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int findShortestSubArray(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 1.初始化数据
        Map<Integer, Integer> elementNum = new HashMap<>();
        Map<Integer, Integer> firstLoc = new HashMap<>();
        Map<Integer, Integer> lastLoc = new HashMap<>();

        // 2.一次遍历
        for (int i = 0; i < nums.length; i++) {
            // a.记录元素个数
            elementNum.put(nums[i], elementNum.getOrDefault(nums[i], 0) + 1);
            // b.记录元素最后位置
            lastLoc.put(nums[i], i);
            // c.记录元素起始位置
            if (!firstLoc.containsKey(nums[i])) {
                firstLoc.put(nums[i], i);
            }
        }

        // 3.第二次遍历寻找度的最短连续子数组
        int ret = nums.length;
        // Optional<Integer> max = elementNum.values().stream().max(Integer::compareTo);
        // int maxDegree = max.get();
        int maxDegree = 0;
        for (Integer value : elementNum.values()) {
            maxDegree = Math.max(maxDegree, value);
        }

        for (Integer num : elementNum.keySet()) {
            if (elementNum.get(num) == maxDegree) {
                ret = Math.min(lastLoc.get(num) - firstLoc.get(num) + 1, ret);
            }
        }

        return ret;
    }
}
