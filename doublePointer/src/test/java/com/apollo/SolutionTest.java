package com.apollo;

import com.apollo.judgeSquareSum.JudgeSquareSum;
import com.apollo.reverseVowels.ReverseVowels;
import com.apollo.twoSum.TwoSum;
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

}
