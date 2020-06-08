package com.apollo.arrayNesting;

/**
 *  565. 数组嵌套
 *      数组长度: n
 *      数的范围: 0~(n-1)
 *      长度与数映射
 */
public class ArrayNesting {
    // 1.不使用额外空间, 一次遍历法
    // 时间复杂度: O(n)  n:元素数目
    // 空间复杂度: O(1)
    public int arrayNesting(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.初始化变量
        int curLen = 0;
        int maxLen = 0;
        // 2.遍历
        for (int i = 0; i < nums.length; i++) {
            for (int j = i, t; nums[j] != -1; j = t) {
                t = nums[j];
                nums[j] = -1;
                curLen++;
            }
            maxLen = Math.max(curLen, maxLen);
            curLen = 0;
        }

        return maxLen;
    }

    // 2.使用额外空间, 创建n长度的布尔变量
    // 时间复杂度: O(n)  n:元素数目
    // 空间复杂度: O(n)

    // 3.暴力法
    // 每个元素都进行循环, 测长度
    // 时间复杂度: O(n^2)  n:元素数目
    // 最差情况: [1, 2, 3, 4, 5, 0]
    // 空间复杂度: O(1)
}
