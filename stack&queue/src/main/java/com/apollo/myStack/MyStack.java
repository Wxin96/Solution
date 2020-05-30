package com.apollo.myStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  225. 用队列实现栈
 *  方法一:
 *      两个队列(压入-O(1), 弹出-O(n))
 *      此方法, 队列中由n个元素, 弹出n-1个元素到另外队列, 再弹出第n个元素, 再把n-1个元素还原到原先队列
 *  方法二:
 *      两个队列(压入-O(n), 弹出-O(1))
 *      两个队列在压入时, 实现逆序
 *  方法三:
 *      一个队列(压入-O(n), 弹出-O(1))
 *      一个队列在压入时,实现逆序
 */
public class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 1.添加元素
        queue.add(x);
        // 2.其他元素反转
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
