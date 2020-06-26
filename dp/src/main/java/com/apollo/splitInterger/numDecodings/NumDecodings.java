package com.apollo.splitInterger.numDecodings;

/**
 *  91. 解码方法
 */
public class NumDecodings {
    // 1.动态规划
    // 没有考虑0的问题, 错误
    // 整个字符要合法
    // 00, 30, 40, .., 90不合法
    public int numDecodings(String s) {
        // 0.过滤
        if (s == null || s.length() < 1) {
            return 0;
        }
        // 1.dp数组 其他数据
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len + 1];
        // 2.BASE CASE
        dp[0] = 1;
        dp[1] = 1;
        // 3.动态规划
        for (int i = 1; i < len; i++) {
            if (helper(chars[i - 1], chars[i])) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[len];
    }

    /**
     *  ab组成的数小于27返回true
     * @param a 十位
     * @param b 个位
     * @return 小于27返回true,否则返回false
     */
    private boolean helper(char a, char b) {
        switch (a) {
            case '0':{
                if (b == '0') {
                    return false;
                }
            }
            case '1':
                return true;
            case '2': {
                if (b <= '6') {
                    return true;
                }
            }
            default:
                return false;
        }
    }


    // 2.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int numDecodings02(String s) {
        // 0.过滤
        if (s == null || s.length() < 1) {
            return 0;
        }
        // 1.动态规划数组
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        // 2.BASE CASE
        dp[0] = 1;
        dp[1] = (chars[0] == '0') ? 0 : 1;
        // 3.动态规划
        // dp的i对应数组的i-1
        for (int i = 2; i <= chars.length; i++) {
            // a.chars[i-1]是否等于0
            if (chars[i - 1] == '0') {
                // A. dp[i] = dp[i-2], 因为0的关系, 10和20变成一个数
                if (chars[i - 2] == '1' || chars[i - 2] == '2') {
                    // 状态转移方程错误
                    dp[i] += dp[i - 2];
                } else {
                    // B.编码错误
                    return 0;
                }
            } else {
                // C.dp[i] = dp[i-1], 当前数不为0
                dp[i] += dp[i - 1];
                // D.(i-2)(i-1)也可以解码, dp[i] = dp[i-1] + dp[i-2]
                // b.chars[i-2]和chars[i-1]能否解码
                if (chars[i - 2] == '1' || chars[i - 2] == '2' && chars[i - 1] <= '6') {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[chars.length];
    }

    // 3.动态规划(压缩)

}
