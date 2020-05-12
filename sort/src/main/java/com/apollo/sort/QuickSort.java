package com.apollo.sort;

/**
 * 快排: 分治算法思想, 左右两边  小 |(中间数)| 大
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.递归
        quickSort(arr, 0, arr.length - 1);

    }

    public void quickSort(int[] arr, int left, int right) {
        // 1.初始化
        int l = left, r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];
        // 2.迭代
        while (l < r) {
            // a.找到左边大于等于pivot的数
            while (arr[l] < pivot) {
                l++;
            }
            // b.找到右边小于等于pivot的数
            while (arr[r] > pivot) {
                r--;
            }
            // c.判断r与l关系
            if (l >= r) {
                break;
            }
            // d.交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // e.避免出现死循环
            // if (arr[l] == pivot) {
            //     r--;
            // }
            // if (arr[r] == pivot) {
            //     l++;
            // }
            if (arr[l]==pivot && arr[r]==pivot) {
                l++;
            }
        }
        // 3.pivot已排序完
        if (arr[l] == pivot) {
            l++;
        }
        if (arr[r] == pivot) {
            r--;
        }
        // 4.左右递归
        if (r > left) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }


    }
}
