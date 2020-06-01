package com.apollo;

import com.apollo.countBinarySubstrings.CountBinarySubstrings;
import com.apollo.countSubstrings.CountSubstrings;
import com.apollo.isAnagram.IsAnagram;
import com.apollo.isIsomorphic.IsIsomorphic;
import com.apollo.isPalindrome.IsPalindrome;
import com.apollo.longestPalindrome.LongestPalindrome;
import org.junit.Test;

public class StringTest {

    @Test
    public void testIsAnagram() {
        // 输入
        String s = "rat";
        String t = "cat";
        // 输出
        IsAnagram solution = new IsAnagram();
        boolean flag = solution.isAnagram04(s, t);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testLongestPalindrome() {
        // 输入
        String s = "abccccdd";
        // 输出
        LongestPalindrome solution = new LongestPalindrome();
        int longestPalindrome = solution.longestPalindrome(s);
        // 验证
        System.out.println(longestPalindrome);
    }

    @Test
    public void testIsIsomorphic() {
        // 输入
        String s = "aaabbbb";
        String t = "aaabbba";
        // 输出
        IsIsomorphic solution = new IsIsomorphic();
        boolean flag = solution.isIsomorphic02(s, t);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testCountSubstrings() {
        // 输入
        String s = "aba";
        // 输出
        CountSubstrings solution = new CountSubstrings();
        int cnt = solution.countSubstrings02(s);
        // 验证
        System.out.println(cnt);
    }

    @Test
    public void testIsPalindrome() {
        // 输入
        int x = 1000041;
        // 输出
        IsPalindrome solution = new IsPalindrome();
        boolean palindrome = solution.isPalindrome02(x);
        // 验证
        System.out.println(palindrome);
    }

    @Test
    public void testCountBinarySubstrings() {
        // 输入
        String s = "00110011";
        // 输出
        CountBinarySubstrings solution = new CountBinarySubstrings();
        int cnt = solution.countBinarySubstrings02(s);
        // 验证
        System.out.println(cnt);
    }
}
