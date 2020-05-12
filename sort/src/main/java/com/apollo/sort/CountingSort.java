package com.apollo.sort;

/**
 * 计数排序
 *  时间复杂度: 当输入的元素是 n 个 0 到 k 之间的整数时，它的运行时间是 Θ(n + k)。
 *  空间复杂度: O(nMax - nMin)
 */
public class CountingSort {

    public void countingSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.初始化
        int maxValue = getMaxValue(arr);
        int[] bucket = new int[maxValue + 1];

        // 2.迭代, 进桶
        for (int num : arr) {
            bucket[num]++;
        }

        // 3.出桶
        int sortedIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            // a.遍历每个桶
            while (bucket[i] > 0) {
                arr[sortedIndex++] = i;
                bucket[i]--;
            }

        }

    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int num : arr) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }


}
