package com.apollo.isSubsequence;

/**
 * 392.判断子序列
 */
public class IsSubsequence {
    // 1.双指针
    // 时间复杂度: O(max(s, t))
    // 空间复杂度: O(1)
    public boolean isSubsequence(String s, String t) {
        // 0.过滤
        if (t == null || s == null) {
            return false;
        }
        // 1.初始化双指针
        int sIndex = 0;
        int tIndex = 0;
        // 2.迭代
        while (sIndex < s.length() && tIndex < t.length()) {
            // a.如果当前坐标匹配
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                // b.如果当前坐标不匹配
                tIndex++;
            }
        }

        // 3.返回结果
        return sIndex == s.length();
    }

    // 2.双指针优化
    // a.字符串 => 字符数组
    // b.String API indexOf(char c, int index)  => 字符串的index位置(包括)后, 由于c匹配返回新的位置, 没有返回-1
    // 注意: index需要+1, 匹配完了字符, 不能继续使用
    // 时间复杂度: O(max(s, t))
    // 空间复杂度: O(1)
    public boolean isSubsequence02(String s, String t) {
        // 0.过滤
        if (t == null || s == null) {
            return false;
        }
        // 1.变量初始化
        int index = -1;
        // 2.遍历
        for (char c : s.toCharArray()) {
            if ((index = t.indexOf(c, index + 1)) == -1) {
                return false;
            }
        }
        return true;
    }

    // 3.如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，
    // 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
    // 假如长字符串的长度为n，建立一个n * 26 大小的矩阵，表示每个位置上26个字符[下一次]出现的位置。
    // aba 0位置的下一个a位置是2, 除去自己
    // 对于大量数据, 建立了数据字典, 分析了要匹配的t
    public boolean isSubsequence03(String s, String t) {

        // 考虑到  对第一个字符的处理 ，在t 之前一个空字符
        // 对字符串第一个元素处理
        t = ' ' + t;

        //对t长字符串 做预处理
        int[][] dp = new int[t.length()][26];//存储每一个位置上  a--z的下一个字符出现的位置
        for (char c = 'a'; c <= 'z'; c++) {//依次对每个字符作处理
            int nextPos = -1;//表示接下来不会在出现该字符

            for (int i = t.length() - 1; i >= 0; i--) {//从最后一位开始处理
                dp[i][c - 'a'] = nextPos;//dp[i][c-'a']  加上外层循环  就是对每一个位置的a---z字符的处理了
                if (t.charAt(i) == c) {//表示当前位置有该字符  那么指向下一个该字符出现的位置就要被更新  为i
                    nextPos = i;
                }
            }
        }

        //数据的利用 ，开始匹配
        int index = 0;
        for (char c : s.toCharArray()) {
            index = dp[index][c - 'a'];//因为加了' '，所以之后在处理第一个字符的时候  如果是在第一行，就会去第一行，不影响之后字符的判断
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

}
