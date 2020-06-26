package com.apollo.matrixPaths;

import com.apollo.matrixPaths.minPathSum.MinPathSum;
import org.junit.Test;

public class MatrixPathsTest {

    @Test
    public void testMinPathSum() {
        // 输入
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        // 输出
        MinPathSum solution = new MinPathSum();
        int pathSum = solution.minPathSum04(grid);
        // 验证
        System.out.println(pathSum);
    }
}
