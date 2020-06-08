package com.apollo.searchMatrix;

/**
 *  240. 搜索二维矩阵 II
 */
public class SearchMatrix {
    // 1.从右上角开始查找(左下也可以, 能减小搜索区域)
    // 左上和右下是不行的, 这两个角无法减少搜索区域
    // 时间复杂度: O(m+n) m n: 数组的宽和高
    // 空间复杂度: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        // 0.过滤
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        // 1.初始化坐标
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1;
        // 2.遍历查找
        while (r < row && c >= 0) {
            // a.找到了
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            }
        }
        // 3.没找到
        return false;
    }

    // 2.每一行进行二分搜索
    // 时间复杂度的话，如果是 m 行 n 列，就是 O(m*log2(n))。

    // 3.暴力法
    // 时间复杂度: O(m*n)
    // 空间复杂度: O(1)
}

