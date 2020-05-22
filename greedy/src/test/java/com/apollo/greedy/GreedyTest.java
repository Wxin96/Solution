package com.apollo.greedy;

import com.apollo.canPlaceFlowers.CanPlaceFlowers;
import com.apollo.checkPossibility.CheckPossibility;
import com.apollo.eraseOverlapIntervals.EraseOverlapIntervals;
import com.apollo.findContentChildren.FindContentChildren;
import com.apollo.isSubsequence.IsSubsequence;
import com.apollo.maxProfit.MaxProfit;
import com.apollo.maxProfit02.MaxProfit02;
import com.apollo.maxSubArray.MaxSubArray;
import com.apollo.partitionLabels.PartitionLabels;
import com.apollo.reconstructQueue.ReconstructQueue;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GreedyTest {

    @Test
    public void testFindContentChildren() {
        // 输入
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        // 输出
        FindContentChildren solution = new FindContentChildren();
        int contentChildren = solution.findContentChildren(g, s);
        // 验证
        System.out.println(contentChildren);
    }

    @Test
    public void testEraseOverlapIntervals() {
        // 输入
        int[][] intervals = new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        // 输出
        EraseOverlapIntervals solution = new EraseOverlapIntervals();
        int count = solution.eraseOverlapIntervals(intervals);
        // 验证
        System.out.println(count);
    }

    @Test
    public void testReconstructQueue() {
        // 输入
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        // 输出
        ReconstructQueue solution = new ReconstructQueue();
        int[][] result = solution.reconstructQueue(people);
        // 验证
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }

    @Test
    public void testMaxProfit() {
        // 输入
        int[] prices = new int[]{7, 1, 5, 3, 6};
        // 输出
        MaxProfit solution = new MaxProfit();
        int maxProfit = solution.maxProfit(prices);
        // 验证
        System.out.println(maxProfit);
    }

    @Test
    public void testMaxProfit02() {
        // 输入
        int[] prices = new int[]{7, 1, 5, 3, 6};
        // 输出
        MaxProfit02 solution = new MaxProfit02();
        int maxProfit = solution.maxProfit(prices);
        // 验证
        System.out.println(maxProfit);
    }

    @Test
    public void testCanPlaceFlowers() {
        // 输入
        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int n = 1;
        // 输出
        CanPlaceFlowers solution = new CanPlaceFlowers();
        boolean canPlaceFlowers = solution.canPlaceFlowers03(flowerbed, n);
        // 验证
        System.out.println(canPlaceFlowers);
    }

    @Test
    public void testIsSubsequence() {
        // 输入
        String s = "abc";
        String t = "ahbgdc";
        // 输出
        IsSubsequence solution = new IsSubsequence();
        boolean subsequence = solution.isSubsequence03(s, t);
        // 验证
        System.out.println(subsequence);
    }

    @Test
    public void testCheckPossibility() {
        // 输入
        int[] nums = new int[]{-1, 4, 2, 3};
        // 输出
        CheckPossibility solution = new CheckPossibility();
        boolean possibility = solution.checkPossibility(nums);
        // 验证
        System.out.println(possibility);
    }

    @Test
    public void testMaxSubArray() {
        // 输入
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // 输出
        MaxSubArray solution = new MaxSubArray();
        int maxSubArray = solution.maxSubArray03(nums);
        // 验证
        System.out.println(maxSubArray);
    }

    @Test
    public void testPartitionLabels() {
        // 输入
        // ababcbacadefegdehijhklij
        // 012345678901234567890123
        String s = "caedbdedda";
        // 输出
        PartitionLabels solution = new PartitionLabels();
        List<Integer> list = solution.partitionLabels02(s);
        // 验证
        System.out.println(list);
    }
}
