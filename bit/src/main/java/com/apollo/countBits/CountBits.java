package com.apollo.countBits;

/**
 *  338. 比特位计数
 *      动态规划与位运算的巧妙结合
 */
public class CountBits {
    // 1.遍历+API
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)  数组所占用内存
    public int[] countBits(int num) {
        // 0.过滤
        if (num < 0) {
            return null;
        }
        // 1.初始化数据
        int[] ret = new int[num + 1];
        // 2.遍历
        for (int i = 0; i <= num; i++) {
            ret[i] = Integer.bitCount(i);
        }

        return ret;
    }

    // 2.位操作+动态规划
    // n&(n-1)去除最后的那个1
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int[] countBits02(int num) {
        // 0.过滤
        if (num < 0) {
            return null;
        }
        // 1.初始化数据
        int[] dp = new int[num + 1];
        // 2.遍历
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }

        return dp;
    }

    // 3.奇偶操作 + 动态规划
    // 奇数的比特数 = (i-1)的比特数+1
    // 偶数的比特数 = (i/2)的比特数
    public int[] countBits03(int num) {
        // 0.过滤
        if (num < 0) {
            return null;
        }
        // 1.初始化数据
        int[] dp = new int[num + 1];
        // 2.遍历
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }


}
