package com.apollo.sort;

/**
 * 快排, 第二种写法
 */
public class QuickSort02 {

    public void quickSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.递归
        quickSort(arr, 0, arr.length - 1);

    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);

        }
    }


    private int partition(int[] arr, int left, int right) {
        // 1.初始化
        int pivot = arr[(left + right) / 2];
        // 2.迭代
        while (left <= right) {
            // a.寻找大于等于pivot的数
            while (arr[left] < pivot) {
                left++;
            }
            // b.寻找大于等于pivot的数
            while (arr[right] > pivot) {
                right--;
            }
            // c.排序完成
            if (left >= right) {
                break;
            }
            // d.交换
            swap(arr, left, right);
            // e.解决死循环问题
            if (arr[left] == pivot && arr[right] == pivot) {
                left++;
            }
        }
        // 3.返回中间索引
        return left;

    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
