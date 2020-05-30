package com.apollo.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 *  1.两数之和
 *
 */
public class TwoSum {
    // 1.HashSet法
    // 时间复杂度: O(n)  n:数组元素个数
    // 空间复杂度: O(n)
    // 思考: 带着元素走
    public int[] twoSum(int[] nums, int target) {
        // 0.过滤
        if (nums == null || nums.length < 2) {
            return null;
        }
        // 1.初始化数据
        // Map<当前数, 索引>
        Map<Integer, Integer> map = new HashMap<>();
        // 2.迭代
        for (int i = 0; i < nums.length; i++) {
            // a.当前数的目标数
            int another = target - nums[i];
            // b. map中是否存在此数
            if (map.containsKey(another)) {
                return new int[]{map.get(another), i};
            } else {
                map.put(nums[i], i);
            }
        }
        // 3.返回
        return null;
    }
}
