package com.apollo.sort;

/**
 * 堆排序
 *  选择排序, 通过大顶堆选出最大值,放到最后, 其余的大顶堆...
 */
public class HeapSort {

    public void heapSort(int[] arr) {
        // 0.过滤
        if (arr == null || arr.length < 1) {
            return;
        }
        // 1.初始化
        int temp = 0;

        // 2.大顶堆初始化
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 3.选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            // a.选择出最大值
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[0];
            arr[0] = temp;

            // b.建立新的大顶堆
            adjustHeap(arr, 0, arr.length - i - 1);

        }
    }


    private void adjustHeap(int[] arr, int startNode, int length) {
        // 1.顶堆初始值
        int initValue = arr[startNode];

        // 2.遍历顶堆
        for (int i = 2 * startNode + 1; i < length; i = 2 * i + 1) {
            // a.在左右节点中选取最大值 => i
            if (i + 1 < length && arr[i + 1] > arr[i]) {
                i++;
            }

            // b.判断最大子节点和顶堆初始值关系
            if (arr[i] > initValue) {
                arr[startNode] = arr[i];
                startNode = i;
            }
        }

        // 3.最终顶堆初始值放到该放的位置
        arr[startNode] = initValue;
    }


}
