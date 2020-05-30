package com.apollo.nextGreaterElements;

import java.util.Stack;

/**
 * 503. 下一个更大的元素
 */
public class NextGreaterElements {
    // 1.栈
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 思考: 初始想法, 双指针是找后边匹配的数
    // 使用栈结构, 带着数走, 去寻找更大的数, 妙啊
    // 细节处理:
    // 1. 采用循环两次策略
    // 2. 在第二遍遍历时, 不需要在添加元素了, 采用方式 i<len
    public int[] nextGreaterElements(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return null;
        }
        // 1.初始化栈结构
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        int len = nums.length;
        // 2.迭代
        for (int i = 0; i < 2 * len && len >= 1; i++) {
            // a.实际索引
            int index = i % len;
            // b.检查栈中元素
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                result[stack.pop()] = nums[index];
            }
            // c.存栈/初始化数组(第一轮存数据)
            if (i<len) {
                stack.push(index);
                result[index] = -1;
            }
        }

        return result;
    }
}
