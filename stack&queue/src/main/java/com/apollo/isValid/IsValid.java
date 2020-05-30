package com.apollo.isValid;

import java.util.Stack;

public class IsValid {
    // 1. 栈(结构)
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 题目理解:
    // 栈先入后出特点恰好与本题括号排序特点一致, 即若遇到左括号入栈, 遇到右括号时对应栈顶左括号出栈(此时栈不能为空),
    // 并且遍历完所有括号后, stack为空
    // 优化:
    // 1.字符串长度为偶数(加在循环中)
    // 2.栈中元素, 不能大于栈的一半长度(加在起始位置, 但是判断也耗时)
    public boolean isValid(String s) {
        // 0.过滤
        if (s == null) {
            return true;
        }
        // 1.初始化数据
        Stack<Character> stack = new Stack<>();
        // 2.迭代
        for (char c : s.toCharArray()) {
            // a.左括号
            if (!checkRight(c)) {
                stack.push(c);
                continue;
            }
            // b.右括号
            // i.栈目前位空
            if (stack.isEmpty()) {
                return false;
            }
            // ii.栈不为空
            if (!match(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean checkRight(char c) {
        return c == '}' || c==']' || c==')';
    }

    private boolean match(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }
}
