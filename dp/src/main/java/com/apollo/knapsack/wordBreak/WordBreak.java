package com.apollo.knapsack.wordBreak;

import java.util.List;

/**
 *  139. 单词拆分
 *  细节问题: 边界问题
 */
public class WordBreak {
    // 1.动态规划
    // 自左到右
    public boolean wordBreak(String s, List<String> wordDict) {
        // 0.预处理
        if (s == null || wordDict == null) {
            return false;
        }
        // 1.初始化dp数组
        int sLength = s.length();
        boolean[] dp = new boolean[sLength + 1];
        // 2.BASE CASE
        dp[0] = true;
        // 3.动态规划
        // 从i开始到字符串len+i长度位置, 实现两个字符串相互作用
        for (int i = 0; i <= sLength; i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i + wordLen <= sLength && word.equals(s.substring(i, i + wordLen))) {
                    dp[i + wordLen] = dp[i + wordLen] || dp[i];
                }
            }
        }

        return dp[sLength];
    }

    // 2.动态规划
    // 从右向左
    public boolean wordBreak02(String s, List<String> wordDict) {
        // 0.预处理
        if (s == null || wordDict == null) {
            return false;
        }
        // 1.初始化dp数组
        int sLength = s.length();
        boolean[] dp = new boolean[sLength + 1];
        // 2.BASE CASE
        dp[0] = true;
        // 3.动态规划
        // 从字符串len+i长度位置到i, 实现两个字符串相互作用
        for (int i = 1; i <= sLength; i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i >= wordLen && word.equals(s.substring(i - wordLen, i))) {
                    dp[i] = dp[i] || dp[i-wordLen];
                }
            }
        }

        return dp[sLength];
    }
}
