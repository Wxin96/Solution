package com.apollo;

import com.apollo.sort.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    private int[] arr = new int[80000];
    private long time;

    @Before
    public void init() {
        for(int i =0; i < arr.length;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        time = System.currentTimeMillis();
    }

    @After
    public void finish() {
        time = System.currentTimeMillis() - time;
        System.out.println("排序后的时间是=" + (time) + "ms");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
    }

    @Test
    public void testSelectSort() {
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(arr);
    }

    @Test
    public void testInsertSort() {
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(arr);
    }

    @Test
    public void testShellSort() {
        // int[] arr = new int[] {9, 8, 7, 1, 2, 3};
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(arr);
    }

    @Test
    public void testQuickSort() {
        // int[] arr = new int[] {9, 8, 7, 1, 2, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
    }

    @Test
    public void testQuickSort02() {
        // int[] arr = new int[] {9, 8, 7, 1, 2, 3};
        QuickSort02 quickSort = new QuickSort02();
        quickSort.quickSort(arr);
    }

    @Test
    public void testMergeSort() {
        // int[] arr = new int[] {9, 8, 7, 1, 2, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
    }

    @Test
    public void testRadixSort() {
        // int[] arr = new int[] {53, 3, 542, 748, 14, 214};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(arr);
        // System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testHeapSort() {
        // int[] arr = new int[] {4, 6, 8, 5, 9};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        // System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testCountingSort() {
        // 输入

        // 输出
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort(arr);
        // 验证

    }
}
