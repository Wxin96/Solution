package com.apollo.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 */
public class ContainsDuplicate {
    // 1.HashSet方法
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public boolean containsDuplicate(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return false;
        }
        // 1.数据初始化
        Set<Integer> set = new HashSet<>();
        // 2.遍历
        Arrays.stream(nums)
                .forEach(set::add);

        return set.size() != nums.length;
    }
}
