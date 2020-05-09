package com.apollo.sort;

/**
 * 希尔排序: 进阶插入排序
 * 有序数组:无序数组
 */
public class ShellSort {


    public void shellSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.初始化
        int insertIndex = 0;
        int curValue = 0;
        // 2.遍历
        // a.步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // b.插入排序
            for (int i = step; i < arr.length; i++) {
                insertIndex = i - step;
                curValue = arr[i];
                // c.移动法
                while (insertIndex >= 0 && curValue < arr[insertIndex]) {
                    arr[insertIndex + step] = arr[insertIndex];
                    insertIndex -= step;
                }
                // d.判断是否需要插入
                if (insertIndex != i - step) {
                    arr[insertIndex + step] = curValue;
                }

            }
        }

    }

}
