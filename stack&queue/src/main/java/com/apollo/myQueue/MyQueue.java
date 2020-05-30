package com.apollo.myQueue;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *  栈(Stack)    LIFO结构
 *  队列(Queue)   FIFO结构
 *  方法一:
 *      使用两个栈
 *      在需要pop()时, 且outStack栈为空, 将inStack中所有元素倒入outStack中, 实现逆序
 *  方法二:
 *      使用两个栈
 *      inStack不为空, 每push()一个新元素, 把之前元素倒入outStack中, inStack放入新元素, 再把outStack中元素倒进去
 */
public class MyQueue {
    // 1.进栈
    private Stack<Integer> inStack = new Stack<>();
    // 2.出栈
    private Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    // 入队O(1)
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    // 出队 之前有元素O(1), 没有元素O(n) n:为inStack栈中的元素个数
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
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
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
