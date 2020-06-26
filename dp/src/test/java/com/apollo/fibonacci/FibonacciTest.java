package com.apollo.fibonacci;

import com.apollo.fibonacci.climbStairs.ClimbStairs;
import com.apollo.fibonacci.rob.Rob;
import com.apollo.fibonacci.rob2.Rob2;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testClimbStairs() {
        // 输出
        int n = 3;
        // 输出
        ClimbStairs solution = new ClimbStairs();
        int stairs = solution.climbStairs(n);
        // 验证
        System.out.println(stairs);
    }

    @Test
    public void testRob() {
        // 输出
        int[] nums = {2,7,9,3,1};
        // 输出
        Rob solution = new Rob();
        int money = solution.rob(nums);
        // 验证
        System.out.println(money);
    }

    @Test
    public void testRob2() {
        // 输出
        int[] nums = {1, 2, 3, 1};
        // 输出
        Rob2 solution = new Rob2();
        int money = solution.rob(nums);
        // 验证
        System.out.println(money);
    }
}
