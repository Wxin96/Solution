package com.apollo.fibonacci.climbStairs;

/**
 *  70. 爬楼梯
 */
public class ClimbStairs {
    // 1.动态规划
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 状态转移方程: f(n) = f(n-1) + f(n-2)
    // Base Case: f(1) = 1, f(2) = 2
    public int climbStairs(int n) {
        // 0.过滤
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        // 1.初始化数据
        int pre = 1, cur = 2;
        // 2.迭代
        for (int i = 3; i <= n; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }

        return cur;
    }
}
