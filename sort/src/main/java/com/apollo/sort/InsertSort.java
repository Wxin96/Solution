package com.apollo.sort;

/**
 * 插入排序
 * 分为:
 * 有序数组 | 无序数组
 * 一步一步将无序数组插入到有序数组
 */
public class InsertSort {
    // 从
    public void insertSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.初始化
        int insertIndex = 0;
        int curValue = 0;
        // 2.开始迭代
        for (int i = 0; i < arr.length - 1; i++) {
            insertIndex = i;
            curValue = arr[i + 1];
            // a.执行插入过程
            while (insertIndex >= 0 && curValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i) {
                arr[++insertIndex] = curValue;
            }

        }


    }
}
