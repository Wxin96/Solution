package com.apollo;

import com.apollo.dailyTemperatures.DailyTemperatures;
import com.apollo.isValid.IsValid;
import com.apollo.minStack.MinStack;
import com.apollo.myQueue.MyQueue;
import com.apollo.myStack.MyStack;
import com.apollo.nextGreaterElements.NextGreaterElements;
import org.junit.Test;

import java.util.Arrays;

public class StackQueueTest {
    @Test
    public void testMyQueue() {
        // 输入
        // 输出
        MyQueue myQueue = new MyQueue();
        // 验证
        // System.out.println(myQueue.empty());
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

    @Test
    public void testMyStack() {
        // 输入

        // 输出
        MyStack myStack = new MyStack();
        // 验证
        System.out.println(myStack.empty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    @Test
    public void testMinStack() {
        // 输入
        // 输出
        MinStack minStack = new MinStack();
        // 验证
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    @Test
    public void testIsValid() {
        // 输入
        String s = "]";
        // 输出
        IsValid solution = new IsValid();
        boolean result = solution.isValid(s);
        // 验证
        System.out.println(result);
    }

    @Test
    public void testDailyTemperatures() {
        // 输入
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        // 输出
        DailyTemperatures solution = new DailyTemperatures();
        int[] res = solution.dailyTemperatures(T);
        // 验证
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void testDailyNextGreaterElements() {
        // 输入
        int[] nums = new int[]{0,-2,-3};
        // 输出
        NextGreaterElements solution = new NextGreaterElements();
        int[] res = solution.nextGreaterElements(nums);
        // 验证
        System.out.println(Arrays.toString(res));
    }
}
