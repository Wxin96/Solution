package com.apollo.minStack;

import java.util.Stack;

/**
 *  155.最小栈
 *  思路一:
 *      - 数据栈
 *      - 辅助栈(保存对应层数的最小值栈)
 *          - 同步
 *          - 不同步(节省空间)
 *  思路二:
 *      构造链表结构, 头插法逆序, 每次存入 当前值和当前最小值
 *  思路三:
 *      利用同一个栈, 记录最小值.
 *      - 记录之前最小值
 *      - 栈记录实质为与当前最小值的差值
 */
public class MinStack {
    // 数据栈
    Stack<Integer> dataStack;
    // 对应层数最小值栈
    Stack<Integer> minStack;
    // 最小值
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        // 数据进栈
        dataStack.push(x);
        // 最小值进栈
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        dataStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return min;
    }
}
