package com.apollo;

import com.apollo.findKthLargest.FindKthLargest;
import com.apollo.frequencySort.FrequencySort;
import com.apollo.sortColors.SortColors;
import com.apollo.topKFrequent.TopKFrequent;
import org.junit.Test;

import java.util.Arrays;

public class LeetCodeSortTest {

    @Test
    public void testFindKthLargest() {
        // 输入
        int[] arr = new int[]{1, 2, 4, 7, 3, 1};
        // 输出
        FindKthLargest solution = new FindKthLargest();
        int result = solution.findKthLargest05(arr, 2);

        // 验证
        System.out.println(result);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testTopKFrequent() {
        // 输入
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        // 输出
        TopKFrequent solution = new TopKFrequent();
        int[] result = solution.topKFrequent02(nums, 2);
        // 验证
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testFrequencySort() {
        // 输入
        String str = "Aabb";
        int k = 2;
        // 输出
        FrequencySort solution = new FrequencySort();
        String result = solution.frequencySort(str);
        // 验证
        System.out.println(result);
    }

    @Test
    public void testSortColor() {
        // 输入
        int[] arr = new int[]{1, 2, 0};
        // 输入
        SortColors solution = new SortColors();
        solution.sortColors(arr);
        // 验证
        System.out.println(Arrays.toString(arr));

    }
}
