package com.apollo;

import com.apollo.countBits.CountBits;
import com.apollo.findComplement.FindComplement;
import com.apollo.getSum.GetSum;
import com.apollo.hammingDistance.HammingDistance;
import com.apollo.hasAlternatingBits.HasAlternatingBits;
import com.apollo.isPowerOfFour.IsPowerOfFour;
import com.apollo.isPowerOfTwo.IsPowerOfTwo;
import com.apollo.maxProduct.MaxProduct;
import com.apollo.missingNumber.MissingNumber;
import com.apollo.reverseBits.ReverseBits;
import com.apollo.singleNumber.SingleNumber;
import com.apollo.singleNumber02.SingleNumber02;
import org.junit.Test;

import java.util.Arrays;

public class BitTest {
    @Test
    public void testHammingDistance() {
        // 输入
        int x = 1, y = 4;
        // 输出
        HammingDistance solution = new HammingDistance();
        int hammingDistance = solution.hammingDistance03(x, y);
        // 验证
        System.out.println(hammingDistance);
    }

    @Test
    public void testSingleNumber() {
        // 输入
        int[] nums = new int[]{2, 2, 1};
        // 输出
        SingleNumber solution = new SingleNumber();
        int singleNumber = solution.singleNumber02(nums);
        // 验证
        System.out.println(singleNumber);
    }

    @Test
    public void testMissingNumber() {
        // 输入
        int[] nums = new int[]{3,0,1};
        // 输出
        MissingNumber solution = new MissingNumber();
        int missingNumber = solution.missingNumber02(nums);
        // 验证
        System.out.println(missingNumber);
    }

    @Test
    public void testSingleNumber02() {
        // 输入
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        // 输出
        SingleNumber02 solution = new SingleNumber02();
        int[] result = solution.singleNumber(nums);
        // 验证
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testReverseBits() {
        // 输入
        int n = 2;
        // 输出
        ReverseBits solution = new ReverseBits();
        int reverseBits = solution.reverseBits04(n);
        // 验证
        System.out.println(Integer.toBinaryString(reverseBits));
    }

    @Test
    public void testIsPowerOfTwo() {
        // 输入
        int n = 16;
        // 输出
        IsPowerOfTwo solution = new IsPowerOfTwo();
        boolean flag = solution.isPowerOfTwo03(n);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testIsPowerOfFour() {
        // 输入
        int n = 1;
        // 输出
        IsPowerOfFour solution = new IsPowerOfFour();
        boolean flag = solution.isPowerOfFour03(n);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testHasAlternatingBits() {
        // 输入
        int n = 4;
        // 输出
        HasAlternatingBits solution = new HasAlternatingBits();
        boolean flag = solution.hasAlternatingBits02(n);
        // 验证
        System.out.println(flag);
    }


    @Test
    public void testFindComplement() {
        // 输入
        int n = 5;
        // 输出
        FindComplement solution = new FindComplement();
        int complement = solution.findComplement03(n);
        // 验证
        System.out.println(complement);
    }

    @Test
    public void testGetSum() {
        // 输入
        int a = 5, b = 7;
        // 输出
        GetSum solution = new GetSum();
        int sum = solution.getSum(a, b);
        // 验证
        System.out.println(sum);
    }

    @Test
    public void testMaxProduct() {
        // 输入
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        // 输出
        MaxProduct solution = new MaxProduct();
        int result = solution.maxProduct(words);
        // 验证
        System.out.println(result);
    }

    @Test
    public void testCountBits() {
        // 输入
        int num = 5;
        // 输出
        CountBits solution = new CountBits();
        int[] countBits = solution.countBits03(num);
        // 验证
        System.out.println(Arrays.toString(countBits));
    }


}
