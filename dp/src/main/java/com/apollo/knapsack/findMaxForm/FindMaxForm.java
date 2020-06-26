package com.apollo.knapsack.findMaxForm;

/**
 *  474. 一和零
 */
public class FindMaxForm {
    /**
     *  1.动态规划
     *  时间复杂度: O(m*n*l) l:字符串的个数
     *  空间复杂度: O(m*n)
     * @param strs 字符串数组
     * @param m    0的个数
     * @param n    1的个数
     * @return     最多能组成的字符个数
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // 0.过滤
        if (strs == null || strs.length < 1 || (m < 0 && n < 0)) {
            return 0;
        }
        m = Math.max(m, 0);
        n = Math.max(n, 0);
        // 1.初始化动态数组
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            // 当前0和1的个数
            int[] zeroOne = countZeroOne(str);
            int zero = zeroOne[0], one = zeroOne[1];
            for (int i = m; i >= 0; i--) {
                for (int j=n; j >= 0; j--) {
                    if (i >= zero && j >= one) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     *
     * @param string 待检测字符串
     * @return  res[0] 字符串中0的个数, res[1] 字符串中1的个数
     */
    private int[] countZeroOne(String string) {
        // 0.初始化数据
        int[] res = new int[2];
        // 1.特殊
        if (string == null) {
            return res;
        }
        // 2.遍历
        for (char c : string.toCharArray()) {
            if (c == '0') {
                res[0]++;
            } else if (c == '1') {
                res[1]++;
            }
        }
        return res;
    }

    // 2.动态规划(优化)
    public int findMaxForm02(String[] strs, int m, int n) {
        // 0.过滤
        if (strs == null || strs.length < 1 || (m < 0 && n < 0)) {
            return 0;
        }
        m = Math.max(m, 0);
        n = Math.max(n, 0);
        // 1.初始化动态数组
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            // 当前0和1的个数
            int[] zeroOne = countZeroOne(str);
            int zero = zeroOne[0], one = zeroOne[1];
            // [到zero和one就行了]
            for (int i = m; i >= zero; i--) {
                for (int j=n; j >= one; j--) {
                    if (i >= zero && j >= one) {
                        // 能放下有余量就行
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

}
