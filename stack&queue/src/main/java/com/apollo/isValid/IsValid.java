package com.apollo.isValid;

import java.util.Stack;

public class IsValid {
    // 优化,
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
