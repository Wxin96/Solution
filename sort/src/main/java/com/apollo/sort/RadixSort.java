package com.apollo.sort;

/**
 * 基数排序
 *  进桶出桶, 高低位数之间已排好序
 */
public class RadixSort {

    public void radixSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.基数排序,变量初始化
        int[][] bucket = new int[10][arr.length];   // 10个桶
        int[] bucketNum = new int[10];      // 10个桶中的数据量
        int digitNums = 0;  // 最大数的位数
        int maxNum = 0;     // 最大数


        // 2.求最大数位数(循环次数) digitNums
        for (int num : arr) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        digitNums = (maxNum + "").length();

        // System.out.println(digitNums);
        // 3.迭代
        for (int i = 0, n = 1; i < digitNums; i++, n *= 10) {
            // a.数据进桶
            int curDigit = 0;   // 当前位 值
            for (int value : arr) {
                curDigit = value / n % 10;
                bucket[curDigit][bucketNum[curDigit]] = value;
                bucketNum[curDigit]++;
            }

            // b.数据出桶
            int copyIndex = 0;  // 复制索引
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bucketNum[j]; k++) {
                    arr[copyIndex++] = bucket[j][k];
                }
                bucketNum[j] = 0;
            }
        }


    }

}
