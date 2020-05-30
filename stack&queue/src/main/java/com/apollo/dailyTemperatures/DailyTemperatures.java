package com.apollo.dailyTemperatures;

import java.util.Stack;

public class DailyTemperatures {
    // 1.使用栈(吐槽: 这也太巧妙了)
    // 时间复杂度: O(n)  n:数组元素个数
    // 空间复杂度: O(n)  最差情况, 逆序; result返回数组
    public int[] dailyTemperatures(int[] T) {
        // 0.过滤
        if (T == null || T.length < 1) {
            return null;
        }
        // 1.初始化数据
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        // 2.迭代
        for (int i = 0; i < T.length; i++) {
            // a.检查栈是否为空, 不为空, 将栈中的元素和当前元素比较大小
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            // b.将当前索引存入栈, 留作后用
            stack.push(i);
        }
        // 3.返回结果
        return result;
    }
    // 2.暴力匹配(双指针)
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(1)
}
