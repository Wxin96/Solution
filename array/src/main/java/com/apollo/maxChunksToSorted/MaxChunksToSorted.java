package com.apollo.maxChunksToSorted;

/**
 *  769. 最多能完成排序的块
 *      考察问题转化
 */
public class MaxChunksToSorted {
    // 1.区域内最大索引 = 最大值
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int maxChunksToSorted(int[] arr) {
        // 0.过滤
        if (arr == null) {
            return 0;
        }
        // 1.初始化变量
        int maxIndexOfArea = 0;
        int cnt = 0;
        // 2.遍历
        for (int i = 0; i < arr.length; i++) {
            // a.区域内最大索引更新
            maxIndexOfArea = Math.max(maxIndexOfArea, arr[i]);
            // b.是否达到最大索引位置
            if (i == maxIndexOfArea) {
                cnt++;
            }
        }

        return cnt;
    }

}
