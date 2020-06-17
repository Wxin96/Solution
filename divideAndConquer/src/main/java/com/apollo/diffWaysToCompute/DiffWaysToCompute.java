package com.apollo.diffWaysToCompute;

import java.util.ArrayList;
import java.util.List;

/**
 *  241. 为运算表达式设计优先级
 */
public class DiffWaysToCompute {
    // 1.分治算法
    // 思想:
    //      1.分解: 按运算符分成左右两部分, 分别求解
    //      2.解决: 实现一个递归函数, 输入算式, 返回算式解
    //      3.合并: 根据运算符合并左右两部分的解, 得出最终解
    // 时间复杂度: O(4^n/n^{1/2})    卡特兰数
    // 空间复杂度: O(4^n/n^{1/2})
    public List<Integer> diffWaysToCompute(String input) {
        // 0.过滤
        if (input == null) {
            return null;
        }
        // 1.初始化数据
        List<Integer> list = new ArrayList<>();

        // 2.迭代
        for (int i = 0; i < input.length(); i++) {
            char operation = input.charAt(i);
            if (operation == '+' || operation == '-' || operation == '*') {
                // a.左面数
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                // b.右面数
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                // c.不同情况组合
                for (Integer leftNum : left) {
                    for (Integer rightNum : right) {
                        if (operation == '+') {
                            list.add(leftNum + rightNum);
                        } else if (operation == '-') {
                            list.add(leftNum - rightNum);
                        } else {
                            list.add(leftNum * rightNum);
                        }
                    }
                }

            }
        }

        // 3.递归终止
        if (list.size() == 0) {
            list.add(Integer.parseInt(input));
            return list;
        }

        return list;
    }

    // 2.动态规划
    // 问题:
    //  1.字符串长度与数组个数混淆
    //  2.动态规划中, 链表的值未加入状态转移数组中
    //  3.索引遍历和长度遍历没有清楚的区分
    // 思路:
    //  1.状态转移方程
    //  2.状态方程初始值
    //  3.最终返回值
    public List<Integer> diffWaysToCompute02(String input) {
        // 0.过滤
        if (input == null) {
            return null;
        }
        // 1.初始化数据
        // a.声明
        // int len = input.length();
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        // b.数字数组和字符数组的初始化
        int num = 0, k = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                opList.add(input.charAt(i));
                numList.add(Integer.parseInt(input.substring(k, i)));
                k = i + 1;
            }
        }
        numList.add(Integer.parseInt(input.substring(k)));
        // c.状态转移矩阵初始化
        int len = numList.size();
        List<Integer>[][] dp = new List[len][len];
        for (int i = 0; i < len; i++) {
            List<Integer> record = new ArrayList<>();
            record.add(numList.get(i));
            dp[i][i] = record;
        }
        // 2.遍历, dp状态转移开始
        // 从长度2开始
        for (int n = 2; n <= len; n++) {
            // dp[i][j]
            for (int i = 0; i < len; i++) {
                // a.初始化数据
                int j = i + n - 1;
                if (j >= len) {
                    break;
                }
                List<Integer> res = new ArrayList<>();

                // b.组合
                for (int l = i; l < j; l++) {
                    for (Integer a : dp[i][l]) {
                        for (Integer b : dp[l + 1][j]) {
                            res.add(calculate(a, b, opList.get(l)));
                        }
                    }
                }
                dp[i][j] = res;
            }

        }

        return dp[0][len-1];
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    private int calculate(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return -1;
        }
    }

}
