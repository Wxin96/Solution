package com.apollo.isToeplitzMatrix;

/**
 *  766. 托普利茨矩阵
 *
 */
public class IsToeplitzMatrix {
    // 1.对角线回溯
    // 思想:
    // 利用递归判断M+N个对角线是否符合要求
    // 时间复杂度: O(M*N) 即: 矩阵大小
    // 空间复杂度: O(N)  递归深度
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 0.过滤
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        // 1.初始化变量
        int m = matrix.length, n = matrix[0].length;
        // 2.遍历
        // 第一行
        for (int i = 0; i < n; i++) {
            if (!isEqual(matrix, matrix[0][i], 1, i+1)) {
                return false;
            }
        }
        // 第一列
        for (int i = 1; i < m; i++) {
            if (!isEqual(matrix, matrix[i][0], i+1, 1)) {
                return false;
            }
        }
        return true;
    }

    // 采用递归回溯
    // 检验对角线元素是否相等
    private boolean isEqual(int[][] matrix, int ref, int row, int col) {
        // 1.递归终止
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        // 2.判断是否相等
        if (ref != matrix[row][col]) {
            return false;
        }
        // 3.递归传递
        return isEqual(matrix, ref, row + 1, col + 1);
    }

    // 2.检查左上角邻居
    // 时间复杂度: O(M*N) 即: 矩阵大小
    // 空间复杂度: O(1)
    public boolean isToeplitzMatrix02(int[][] matrix) {
        // 0.过滤
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        // 1.遍历
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 判断是不是边界
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    // 3.同一对角线元素, r-c的值相同, 利用HashMap存储
    // 时间复杂度: O(M*N) 即: 矩阵大小
    // 空间复杂度: O(M+N)    对角线元素个数
}
