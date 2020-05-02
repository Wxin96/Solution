package com.apollo;

import com.apollo.judgeSquareSum.JudgeSquareSum;
import com.apollo.merge.Merge;
import com.apollo.reverseVowels.ReverseVowels;
import com.apollo.twoSum.TwoSum;
import com.apollo.validPalindrome.ValidPalindrome;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testTwoSum() {
        // 输入
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        //
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testTwoSum02() {
        // 输入
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        //
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum02(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testJudgeSquareSum() {
        int c = 50;
        JudgeSquareSum solution = new JudgeSquareSum();
        boolean flag = solution.judgeSquareSum(c);
        System.out.println(flag);
    }

    @Test
    public void testReverseVowels() {
        // 输入
        String s = "leetcode";
        // 输出
        ReverseVowels solution = new ReverseVowels();
        String result = solution.reverseVowels(s);
        // 判断
        assertEquals(result, "leotcede");
    }

    @Test
    public void testReverseVowels02() {
        // 输入
        String s = "leetcode";
        // 输出
        ReverseVowels solution = new ReverseVowels();
        String result = solution.reverseVowels02(s);
        // 判断
        assertEquals(result, "leotcede");
        System.out.println(result);
    }

    @Test
    public void testReverseVowels03() {
        // 输入
        String s = "leetcode";
        // 输出
        ReverseVowels solution = new ReverseVowels();
        String result = solution.reverseVowels03(s);
        // 判断
        assertEquals(result, "leotcede");
        System.out.println(result);
    }

    @Test
    public void testValidPalindrome() {
        // 输入
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        // 输出
        ValidPalindrome solution = new ValidPalindrome();
        boolean result = solution.validPalindrome(s);
        // 检验
        assertEquals(true, result);
        System.out.println(result);
    }

    @Test
    public void testMerge() {
        // 输入
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        // 输出
        Merge solution = new Merge();
        solution.merge(nums1, m, nums2, n);
        // 检验
        System.out.println(Arrays.toString(nums1));

    }
}
