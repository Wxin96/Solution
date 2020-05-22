package com.apollo.myQueue;

import java.util.Stack;

public class MyQueue {
    // 1.进栈
    private Stack<Integer> inStack = new Stack<>();
    // 2.出栈
    private Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else {
            in2Out();
            return outStack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        } else {
            in2Out();
            return outStack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2Out() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        } else {
            throw new RuntimeException("outStack内有数据, 不能填充!");
        }
    }
}
