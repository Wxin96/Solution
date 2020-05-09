package com.apollo.sort;


public class BubbleSort {
    // 冒泡排序
    public void bubbleSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.初始化
        boolean falg = false;   // 优化标志位
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    falg = true;
                }
            }
            if (!falg) {
                return;
            } else {
                falg = false;
            }
        }

    }
}
