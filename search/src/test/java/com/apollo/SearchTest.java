package com.apollo;

import com.apollo.binarySearch.BinarySearch;
import com.apollo.mySqrt.MySqrt;
import com.apollo.nextGreatestLetter.NextGreatestLetter;
import org.junit.Test;

public class SearchTest {


    @Test
    public void testBinarySearch() {
        // 输入
        int[] nums = new int[]{1, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 11, 34, 65, 68, 70, 89, 92, 100};
        int key = 3;
        // 输出
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearch03(nums, 11);
        // 验证
        System.out.println(index);
    }

    @Test
    public void testMySqrt() {
        // 输入

        // 输出
        MySqrt solution = new MySqrt();
        int res = solution.mySqrt04(8);
        // 验证
        System.out.println(res);
    }

    @Test
    public void testNextGreatestLetter() {
        // 输入
        char[] letters = new char[]{'c', 'c', 'c', 'c', 'f', 'j'};
        // 输出
        NextGreatestLetter solution = new NextGreatestLetter();
        char res = solution.nextGreatestLetter(letters, 'a');
        // 验证
        System.out.println(res);
    }
}