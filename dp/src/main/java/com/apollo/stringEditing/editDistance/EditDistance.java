package com.apollo.stringEditing.editDistance;

/**
 *  72. 编辑距离
 */
public class EditDistance {
    // 1.动态规划
    // 动态规划, 状态/选择
    // 插入, 删除, 替换三种选择, 怎么作用到状态上
    // 时间复杂度: O(m*n)
    // 空间复杂度: O(m*n)
    public int minDistance(String word1, String word2) {
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
        // 2.BASE CASE
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        // 3.动态规划
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[len1][len2];
    }

}
