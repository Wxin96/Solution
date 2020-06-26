package com.apollo.longestCommonSubsequence;

/**
 *  1143. 最长公共子序列
 *  两个字符串组成二维dp数组, 选择遍历(0,i)(0,j)组合, 找到对应的状态转移关系
 */
public class LongestCommonSubsequence {
    // 1.递归法(暴力匹配)
    public int longestCommonSubsequence(String text1, String text2) {
        // 0.过滤
        if (text1 == null || text1.length() < 1 || text2 == null || text2.length() < 1) {
            return 0;
        }

        return helper(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private int helper(String text1, String text2, int index1, int index2) {
        // 1.递归头
        if (index1 == -1 || index2 == -1) {
            return 0;
        }
        // 2.判断当前字母是否相等
        if (text1.charAt(index1) == text2.charAt(index2)) {
            // 匹配一个LCS中的字符
            return helper(text1, text2, index1 - 1, index2 - 1) + 1;
        } else {
            return Math.max(helper(text1, text2, index1 - 1, index2), helper(text1, text2, index1, index2 - 1));
        }
    }

    // 2.动态规划
    public int longestCommonSubsequence02(String text1, String text2) {
        // 0.过滤
        if (text1 == null || text1.length() < 1 || text2 == null || text2.length() < 1) {
            return 0;
        }
        // 1.初始化动态规划数组
        // i 对应 text1.charAt(i-1), 同理 j => text2.charAt(j-1)
        int m = text1.length(), n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        // 2.BASE CASE
        // dp[x][0] = dp[0][y] =0
        // 3.动态规划
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 判断想不想等
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }


}
