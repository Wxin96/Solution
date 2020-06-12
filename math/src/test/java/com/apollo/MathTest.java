package com.apollo;

import com.apollo.addAndSub.addBinary.AddBinary;
import com.apollo.addAndSub.addStrings.AddStrings;
import com.apollo.conversion.convertToBase7.ConvertToBase7;
import com.apollo.conversion.convertToTitle.ConvertToTitle;
import com.apollo.conversion.toHex.ToHex;
import com.apollo.factorial.trailingZeroes.TrailingZeroes;
import com.apollo.lcmAndGcd.countPrimes.CountPrimes;
import com.apollo.lcmAndGcd.gcd.GreatestCommonDivisor;
import com.apollo.lcmAndGcd.lcm.LeastCommonMultiple;
import com.apollo.majorityElement.MajorityElement;
import com.apollo.minMoves2.MinMoves2;
import com.apollo.other.isPerfectSquare.IsPerfectSquare;
import com.apollo.other.isPowerOfThree.IsPowerOfThree;
import com.apollo.other.maximumProduct.MaximumProduct;
import org.junit.Test;

public class MathTest {

    @Test
    public void testCountPrimes() {
        // 输入
        int n = 10000;
        // 输出
        CountPrimes solution = new CountPrimes();
        int primes = solution.countPrimes03(n);
        // 验证
        System.out.println(primes);
    }

    @Test
    public void testGreatestCommonDivisor() {
        // 输入
        int a = 14, b = 36;
        // 输出
        GreatestCommonDivisor solution = new GreatestCommonDivisor();
        int gcd = solution.gcd03(a, b);
        // 验证
        System.out.println(gcd);
    }

    @Test
    public void testLeastCommonMultiple() {
        // 输入
        int a = 18, b = 12;
        // 输出
        LeastCommonMultiple solution = new LeastCommonMultiple();
        int lcm = solution.lcm(a, b);
        // 验证
        System.out.println(lcm);
    }

    @Test
    public void testConvertToBase7() {
        // 输入
        int n = -4456;
        // 输出
        ConvertToBase7 solution = new ConvertToBase7();
        String num = solution.convertToBase7o2(n);
        // 验证
        System.out.println(num);
    }

    @Test
    public void testToHex() {
        // 输入
        int n = -1;
        // 输出
        ToHex solution = new ToHex();
        String num = solution.toHex02(n);
        // 验证
        System.out.println(num);
    }

    @Test
    public void testConvertToTitle() {
        // 输入
        int n = 1;
        // 输出
        ConvertToTitle solution = new ConvertToTitle();
        String num = solution.convertToTitle02(n);
        // 验证
        System.out.println(num);
    }

    @Test
    public void testTrailingZeroes() {
        // 输入
        int n = 30;
        // 输出
        TrailingZeroes solution = new TrailingZeroes();
        int num = solution.trailingZeroes02(n);
        // 验证
        System.out.println(num);
    }

    @Test
    public void testAddBinary() {
        // 输入
        String a = "10101", b = "111";
        // 输出
        AddBinary solution = new AddBinary();
        String sum = solution.addBinary02(a, b);
        // 验证
        System.out.println(sum);
    }

    @Test
    public void testAddStrings() {
        // 输入
        String a = "23543546", b = "3445327";
        // 输出
        AddStrings solution = new AddStrings();
        String sum = solution.addStrings(a, b);
        // 验证
        System.out.println(sum);
    }

    @Test
    public void testMinMoves2() {
        // 输入
        int[] nums = {1, 3, 2};
        // 输出
        MinMoves2 solution = new MinMoves2();
        int cnt = solution.minMoves2o2(nums);
        // 验证
        System.out.println(cnt);
    }

    @Test
    public void testMajorityElement() {
        // 输入
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        // 输出
        MajorityElement solution = new MajorityElement();
        int element = solution.majorityElement02(nums);
        // 验证
        System.out.println(element);
    }

    @Test
    public void testIsPerfectSquare() {
        // 输入
        int num = 49;
        // 输出
        IsPerfectSquare solution = new IsPerfectSquare();
        boolean flag = solution.isPerfectSquare03(num);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testisPowerOfThree() {
        // 输入
        int num = 49;
        // 输出
        IsPowerOfThree solution = new IsPowerOfThree();
        boolean flag = solution.isPowerOfThree(num);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testMaximumProduct() {
        // 输入
        int[] nums = {-4, -3, -2, -1, 60};
        // 输出
        MaximumProduct solution = new MaximumProduct();
        int result = solution.maximumProduct03(nums);
        // 验证
        System.out.println(result);
    }
}
