package com.apollo.sort;

/**
 * 利用递归先拆后合, 合中排序
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.归并排序, 递归排序
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        // 1.中间分割位置
        int mid = (left + right) / 2;
        // 2.满足left<right
        if (left < right) {
            // a.分
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            // b.合
            merge(arr, left, right, temp);
        }
    }

    private void merge(int[] arr, int left, int right, int[] temp) {
        // 1.初始化遍历变量
        int mid = (left + right) / 2;
        int index1 = left, index2 = mid + 1, indexTemp = left;
        // 2.合并排序到temp
        while (index1 <= mid && index2 <= right) {
            if (arr[index1] <= arr[index2]) {
                temp[indexTemp++] = arr[index1++];
            } else {
                temp[indexTemp++] = arr[index2++];
            }
        }
        while (index1 <= mid) {
            temp[indexTemp++] = arr[index1++];
        }
        while (index2 <= right) {
            temp[indexTemp++] = arr[index2++];
        }
        // 3.temp到arr
        indexTemp = left;
        while (indexTemp <= right) {
            arr[indexTemp] = temp[indexTemp];
            indexTemp++;
        }

    }

}
