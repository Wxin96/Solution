package com.apollo.stringEditing.minDistance;

/**
 *  583. 两个字符串的删除操作
 */
public class MinDistance {
    // 1.动态规划
    public int minDistance(String word1, String word2) {
        // 0.预处理
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word2 == null) {
            return (word1 == null) ? word2.length() : word1.length();
        }
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return (len1 == 0) ? len2 : len1;
        }
        // 1.初始化dp数组
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 2.动态规划
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // a.dp[i][j]初始值
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j]++;
                }
            }
        }

        return dp[len1][len2];
    }

    // 2.动态规划(转化为最长公共子序列问题)
    // m+n-2*lcs
    // 时间复杂度: O(mn)
    // 空间复杂度: O(mn)
    public int minDistance02(String word1, String word2) {
        // 0.预处理
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word2 == null) {
            return (word1 == null) ? word2.length() : word1.length();
        }
        // 1.初始化dp数组
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 2.动态规划
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // a.word1[i-1]和word2[j-1]是否相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return len1 + len2 - 2 * dp[len1][len2];
    }
}
