package com.apollo;

import com.apollo.containsDuplicate.ContainsDuplicate;
import com.apollo.findLHS.FindLHS;
import com.apollo.longestConsecutive.LongestConsecutive;
import com.apollo.twoSum.TwoSum;
import org.junit.Test;

import java.util.Arrays;

public class HashSetTest {

    @Test
    public void testTwoSum() {
        // 输入
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        // 输出
        TwoSum solution = new TwoSum();
        int[] index = solution.twoSum(nums, target);
        // 验证
        System.out.println(Arrays.toString(index));
    }

    @Test
    public void testContainsDuplicate() {
        // 输入
        int[] nums = new int[]{1, 2, 3, 1};
        // 输出
        ContainsDuplicate solution = new ContainsDuplicate();
        boolean duplicate = solution.containsDuplicate(nums);
        // 验证
        System.out.println(duplicate);
    }

    @Test
    public void testFindLS() {
        // 输入
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        // 输出
        FindLHS solution = new FindLHS();
        int lhs = solution.findLHS02(nums);
        // 验证
        System.out.println(lhs);
    }

    @Test
    public void testLongestConsecutive() {
        // 输入
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        // 输出
        LongestConsecutive solution = new LongestConsecutive();
        int longestConsecutive = solution.longestConsecutive02(nums);
        // 验证
        System.out.println(longestConsecutive);
    }
}
