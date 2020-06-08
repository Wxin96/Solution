package com.apollo;

import com.apollo.arrayNesting.ArrayNesting;
import com.apollo.maxChunksToSorted.MaxChunksToSorted;
import com.apollo.constructArray.ConstructArray;
import com.apollo.findDuplicate.FindDuplicate;
import com.apollo.findErrorNums.FindErrorNums;
import com.apollo.findMaxConsecutiveOnes.FindMaxConsecutiveOnes;
import com.apollo.findShortestSubArray.FindShortestSubArray;
import com.apollo.isToeplitzMatrix.IsToeplitzMatrix;
import com.apollo.kthSmallest.KthSmallest;
import com.apollo.matrixReshape.MatrixReshape;
import com.apollo.moveZeroes.MoveZeroes;
import com.apollo.searchMatrix.SearchMatrix;
import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {

    @Test
    public void testMoveZeroes() {
        // 输入
        int[] nums = new int[]{1, 2, 3, 0, 4, 5, 6};
        // 输出
        MoveZeroes solution = new MoveZeroes();
        solution.moveZeroes02(nums);
        // 验证
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testMatrixReshape() {
        // 输入
        int[][] nums = new int[][]{{1, 2,}, {3, 4}};
        // 输出
        MatrixReshape solution = new MatrixReshape();
        int[][] result = solution.matrixReshape(nums, 1, 4);
        // 验证
        for (int[] num : result) {
            System.out.println(Arrays.toString(num));
        }
    }

    @Test
    public void testFindMaxConsecutiveOnes() {
        // 输入
        int[] nums = new int[]{1, 0, 1, 1, 0, 1};
        // 输出
        FindMaxConsecutiveOnes solution = new FindMaxConsecutiveOnes();
        int maxConsecutiveOnes = solution.findMaxConsecutiveOnes(nums);
        // 验证
        System.out.println(maxConsecutiveOnes);

    }

    @Test
    public void testSearchMatrix() {
        // 输入
        int[][] nums = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        // 输出
        SearchMatrix solution = new SearchMatrix();
        boolean flag = solution.searchMatrix(nums, 100);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testKthSmallest() {
        // 输入
        int[][] nums = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        // 输出
        KthSmallest solution = new KthSmallest();
        int kthSmallest = solution.kthSmallest03(nums, 8);
        // 验证
        System.out.println(kthSmallest);
    }

    @Test
    public void testFindErrorNums() {
        // 输入
        int[] nums = new int[]{2, 3, 2};
        // 输出
        FindErrorNums solution = new FindErrorNums();
        int[] errorNums = solution.findErrorNums(nums);
        // 验证
        System.out.println(Arrays.toString(errorNums));
    }

    @Test
    public void testFindDuplicate() {
        // 输入
        int[] nums = new int[]{1,3,4,2,2};
        // 输出
        FindDuplicate solution = new FindDuplicate();
        int duplicate = solution.findDuplicate02(nums);
        // 验证
        System.out.println(duplicate);
    }

    @Test
    public void testConstructArray() {
        // 输入
        int n = 10, k = 2;
        // 输出
        ConstructArray solution = new ConstructArray();
        int[] nums = solution.constructArray02(n, k);
        // 验证
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testFindShortestSubArray() {
        // 输入
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        // 输出
        FindShortestSubArray solution = new FindShortestSubArray();
        int shortestSubArray = solution.findShortestSubArray(nums);
        // 验证
        System.out.println(shortestSubArray);

    }

    @Test
    public void testIsToeplitzMatrix() {
        // 输入
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        // 输出
        IsToeplitzMatrix solution = new IsToeplitzMatrix();
        boolean toeplitzMatrix = solution.isToeplitzMatrix02(nums);
        // 验证
        System.out.println(toeplitzMatrix);
    }

    @Test
    public void testArrayNesting() {
        // 输入
        int[] nums = new int[]{5, 4, 0, 3, 1, 6, 2};
        // 输出
        ArrayNesting solution = new ArrayNesting();
        int cnt = solution.arrayNesting(nums);
        // 验证
        System.out.println(cnt);
    }

    @Test
    public void testMaxChunksToSorted() {
        // 输入
        int[] nums = new int[]{4, 3, 2, 1, 0};
        // 输出
        MaxChunksToSorted solution = new MaxChunksToSorted();
        int cnt = solution.maxChunksToSorted(nums);
        // 验证
        System.out.println(cnt);
    }


}
