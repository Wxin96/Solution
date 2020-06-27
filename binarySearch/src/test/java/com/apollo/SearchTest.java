package com.apollo;

import com.apollo.binarySearch.BinarySearch;
import com.apollo.findMin.FindMin;
import com.apollo.firstBadVersion.FirstBadVersion;
import com.apollo.mySqrt.MySqrt;
import com.apollo.nextGreatestLetter.NextGreatestLetter;
import com.apollo.searchRange.SearchRange;
import com.apollo.singleNonDuplicate.SingleNonDuplicate;
import org.junit.Test;

import java.util.Arrays;

public class SearchTest {


    @Test
    public void testBinarySearch() {
        // 输入
        int[] nums = new int[]{1, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 11, 34, 65, 68, 70, 89, 92, 100, 100};
        int key = 3;
        // 输出
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearch04(nums, 2);
        
        // 验证
        System.out.println(index);
        System.out.println(nums.length);
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
        char res = solution.nextGreatestLetter02(letters, 'a');
        // 验证
        System.out.println(res);
    }

    @Test
    public void testSingleNonDuplicate() {
        // 输入
        int[] nums = new int[]{0, 0, 1, 2, 2};
        // 输出
        SingleNonDuplicate solution = new SingleNonDuplicate();
        int single = solution.singleNonDuplicate02(nums);
        //验证
        System.out.println(single);
    }

    @Test
    public void testFirstBadVersion() {
        // 输入
        int n = 60;
        // 输出
        FirstBadVersion solution = new FirstBadVersion();
        int badVersion = solution.firstBadVersion(n);
        // 验证
        System.out.println(badVersion);
    }

    @Test
    public void testFindMin() {
        // 输入
        int[] nums = new int[] {3,4,5,1,2};
        // 输出
        FindMin solution = new FindMin();
        int min = solution.findMin(nums);
        // 验证
        System.out.println(min);
    }

    @Test
    public void testSearchRange() {
        // 输入
        int[] nums = new int[]{1};
        int target = 1;
        // 输出
        SearchRange solution = new SearchRange();
        int[] range = solution.searchRange02(nums, target);
        // 验证
        System.out.println(Arrays.toString(range));

    }
}