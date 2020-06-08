package com.apollo.matrixReshape;

/**
 *  566.重塑矩阵
 *      考察二维矩阵的线性遍历
 */
public class MatrixReshape {
    // 1.一次遍历
    // 时间复杂度: O(r*c)
    // 空间复杂度: O(r*c)
    // 一维数组到二维数组的映射
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // 0.过滤
        if (nums == null) {
            return null;
        }
        // 1.检查是否对应
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        // 2.初始化变量
        int cnt = 0;
        int[][] result = new int[r][c];
        // 3.遍历
        while (cnt < r * c) {
            result[cnt/c][cnt%c] = nums[cnt/col][cnt%col];
            cnt++;
        }

        return result;
    }

    // 2.使用队列, 两次遍历
    // 时间复杂度: O(r*c)
    // 空间复杂度: O(r*c)
}
