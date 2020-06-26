package com.apollo.matrixPaths.minPathSum;

/**
 *  64. 最小路径和
 */
public class MinPathSum {
    // 1.暴力解法
    // 矩阵实际最大索引
    // 时间复杂度: O(2^(m+n))
    // 空间复杂度: O(m+n) 递归深度
    private int Row;
    private int Col;
    public int minPathSum(int[][] grid) {
        // 0.过滤
        if (grid == null || grid.length < 1) {
            return -1;
        }
        Row = grid.length -1;
        Col = grid[0].length -1;

        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int row, int col) {
        // 1.递归头
        int curValue = grid[row][col];
        if (row == Row && col == Col) {
            return curValue;
        }
        // 2.三种情况
        if (row < Row && col < Col) {
            int right = minPathSum(grid, row, col + 1);
            int down = minPathSum(grid, row + 1, col);
            return Math.min(right, down) + curValue;
        } else if (row < Row) {
            return minPathSum(grid, row + 1, col) + curValue;
        } else {
            return minPathSum(grid, row, col + 1) + curValue;
        }

    }

    // 2.递归剪掉枝叶, 建立备忘录
    // 时间复杂度: O(m*n)
    // 空间复杂度: O(m*n)
    public int minPathSum02(int[][] grid) {
        // 0.过滤
        if (grid == null || grid.length < 1) {
            return -1;
        }
        Row = grid.length -1;
        Col = grid[0].length -1;
        int[][] dp = new int[Row + 1][Col + 1];

        return minPathSum02(grid, dp, 0, 0);
    }

    private int minPathSum02(int[][] grid, int[][] dp, int row, int col) {
        // 0.判断是否有记录
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        // 1.递归头
        int curValue = grid[row][col];
        if (row == Row && col == Col) {
            dp[row][col] = curValue;
            return curValue;
        }
        // 2.三种情况
        if (row < Row && col < Col) {
            int right = minPathSum02(grid, dp, row, col + 1);
            int down = minPathSum02(grid, dp, row + 1, col);
            dp[row][col] = Math.min(right, down) + curValue;
        } else if (row < Row) {
            dp[row][col] = minPathSum02(grid, dp, row + 1, col) + curValue;
        } else {
            dp[row][col] = minPathSum02(grid, dp, row, col + 1) + curValue;
        }
        return dp[row][col];
    }

    // 3.动态规划
    // 时间复杂度: O(m*n)
    // 空间复杂度: O(m*n)
    public int minPathSum03(int[][] grid) {
        // 0.过滤
        if (grid == null || grid.length < 1) {
            return -1;
        }
        // 1.初始化数据
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        // 2.Base case
        dp[0][0] = grid[0][0];
        // 3.迭代
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 三种情况
                int curValue = grid[i][j];
                // 优化, 节点i==0或者j==0
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + curValue;
                } else if (i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] + curValue;
                } else if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j-1] + curValue;
                }
            }
        }

        return dp[row-1][col-1];
    }

    // 4.动态规划[状态压缩]
    // 时间复杂度: O(m*n)
    // 空间复杂度: O(n)
    public int minPathSum04(int[][] grid) {
        // 0.过滤
        if (grid == null || grid.length < 1) {
            return -1;
        }
        // 1.初始化数据
        int row = grid.length, col = grid[0].length;
        int[] dp = new int[col];
        // 2.Base case => dp[0] = 0;
        // 3.迭代
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 三种情况
                if (j == 0) {   // 从上->下
                    // dp[j] = dp[j];
                } else if (i == 0) { // 左->右
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]); // min{左, 上}
                }

                dp[j] += grid[i][j];
            }
        }

        return dp[col-1];
    }

}
