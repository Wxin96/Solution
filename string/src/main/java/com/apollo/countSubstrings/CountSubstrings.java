package com.apollo.countSubstrings;

/**
 * 647.回文子串
 */
public class CountSubstrings {
    // 1.中心扩展法
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(1)
    // 思想:
    //  1.从字符串中, 中间的位置取两边扩展
    //  2.分为奇偶两种情况, 个人想法只考虑到了奇数, 漏了偶数
    public int countSubstrings(String s) {
        // 0.过滤
        if (s == null) {
            return 0;
        }
        // 1.初始化变量
        int cnt = 0;
        // 1.遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // a.奇对称
            cnt += extendSubstrings(s, i, i);
            // b.偶对称
            cnt += extendSubstrings(s, i, i + 1);
        }

        return cnt;
    }

    // 中心扩展
    private int extendSubstrings(String s, int start, int end) {
        // 0.过滤
        if (start > end) {
            return 0;
        }
        // 1.数据
        int cnt = 0;    // 计数
        // 2.遍历
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            // a.回文串数量+1
            cnt++;
            // b.两边扩展
            start--;
            end++;
        }
        return cnt;
    }

    // 2.动态规划
    // dp[i][j] 代表str[i] - str[j]是否是回文子串
    // 动态规划起始: 考虑单字符和双字符的特殊情况
    // 状态转移方程 dp[i][j] = dp[i+1][j-1] && str[i]==str[j]
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n^2)
    public int countSubstrings02(String s) {
        // 0.过滤
        if (s == null) {
            return 0;
        }
        // 1.初始化动态规划数组
        boolean dp[][] = new boolean[s.length()][s.length()];
        int cnt = 0;
        // 2.遍历
        // 共有C(2, n)种情况
        // 区间[i, j]
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                // 状态转移
                // 此处不能提前中断的原因, 不是中心出发的
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    cnt++;
                }
            }
        }
        // 3.返回
        return cnt;
    }


}
