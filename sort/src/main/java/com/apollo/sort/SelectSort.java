package com.apollo.sort;

// 选择排序
public class SelectSort {

    // 选出小的 交换
    public void selectSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }

        // 1.迭代
        for (int i = 0; i < arr.length - 1; i++) {
            // a.初始值(选择当前最小值)
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[minIndex];
                }
            }
            // b.如需交换则进行交换
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }


    }

}
