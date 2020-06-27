package com.apollo.labuladong;

import com.apollo.arrayInterval.numArray.NumArray;
import com.apollo.arrayInterval.numberOfArithmeticSlices.NumberOfArithmeticSlices;
import com.apollo.knapsack.canPartition.CanPartition;
import com.apollo.knapsack.change.Change;
import com.apollo.knapsack.coinChange.CoinChange02;
import com.apollo.knapsack.combinationSum4.CombinationSum4;
import com.apollo.knapsack.findMaxForm.FindMaxForm;
import com.apollo.knapsack.findTargetSumWays.FindTargetSumWays;
import com.apollo.knapsack.wordBreak.WordBreak;
import com.apollo.labuladong.coinChange.CoinChange;
import com.apollo.labuladong.fibonacci.Fibonacci;
import com.apollo.longestCommonSubsequence.LongestCommonSubsequence;
import com.apollo.longestIncreasingSubsequence.findLongestChain.FindLongestChain;
import com.apollo.longestIncreasingSubsequence.lengthOfLIS.LengthOfLIS;
import com.apollo.longestIncreasingSubsequence.wiggleMaxLength.WiggleMaxLength;
import com.apollo.matrixPaths.uniquePaths.UniquePaths;
import com.apollo.splitInterger.integerBreak.IntegerBreak;
import com.apollo.splitInterger.numDecodings.NumDecodings;
import com.apollo.splitInterger.numSquares.NumSquares;
import com.apollo.stockTrading.maxProfit.MaxProfit;
import com.apollo.stockTrading.maxProfit02.MaxProfit02;
import com.apollo.stockTrading.maxProfit03.MaxProfit03;
import com.apollo.stockTrading.maxProfit04.MaxProfit04;
import com.apollo.stringEditing.editDistance.EditDistance;
import com.apollo.stringEditing.minDistance.MinDistance;
import com.apollo.stringEditing.minSteps.MinSteps;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DPLearnTest {

    @Test
    public void testFibonacci() {
        // 输入
        int n = 20;
        // 输出
        Fibonacci solution = new Fibonacci();
        int fib = solution.fib04(n);
        // 验证
        System.out.println(fib);
    }

    @Test
    public void testCoinChange() {
        // 输入
        int[] coins = {2};
        int n = 3;
        // 输出
        CoinChange solution = new CoinChange();
        int cnt = solution.coinChange(coins, n);
        // 验证
        System.out.println(cnt);
    }

    @Test
    public void testUniquePaths() {
        // 输入
        int m = 4, n = 6;
        // 输出
        UniquePaths solution = new UniquePaths();
        int uniquePaths = solution.uniquePaths03(m, n);
        // 验证
        System.out.println(uniquePaths);
    }

    @Test
    public void testNumArray() {
        // 输入
        int[] nums = {-2, 0, 3, -5, 2, -1};
        // 输出
        NumArray solution = new NumArray(nums);
        int sum = solution.sumRange(2, 5);
        // 验证
        System.out.println(sum);
    }

    @Test
    public void testNumberOfArithmeticSlices() {
        // 输入
        int[] A = {1, 2, 3, 4};
        // 输出
        NumberOfArithmeticSlices solution = new NumberOfArithmeticSlices();
        int numberOfArithmeticSlices = solution.numberOfArithmeticSlices03(A);
        // 验证
        System.out.println(numberOfArithmeticSlices);
    }

    @Test
    public void testIntegerBreak() {
        // 输入
        int n = 2;
        // 输出
        IntegerBreak solution = new IntegerBreak();
        int product = solution.integerBreak02(n);
        // 验证
        System.out.println(product);
    }

    @Test
    public void testNumSquares() {
        // 输入
        int n = 13;
        // 输出
        NumSquares solution = new NumSquares();
        int numSquares = solution.numSquares(n);
        // 验证
        System.out.println(numSquares);
    }

    @Test
    public void testNumDecodings() {
        // 输入
        String s = "12120";
        // 输出
        NumDecodings solution = new NumDecodings();
        int num = solution.numDecodings02(s);
        // 验证
        System.out.println(num);
    }

    @Test
    public void testLengthOfLIS() {
        // 输入
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        // 输出
        LengthOfLIS solution = new LengthOfLIS();
        int lengthOfLIS = solution.lengthOfLIS02(nums);
        // 验证
        System.out.println(lengthOfLIS);
    }

    @Test
    public void testFindLongestChain() {
        // 输入
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        // 输出
        FindLongestChain solution = new FindLongestChain();
        int longestChain = solution.findLongestChain03(pairs);
        // 验证
        System.out.println(longestChain);
    }

    @Test
    public void testWiggleMaxLength() {
        // 输入
        int[] nums = {0, 0};
        // 输出
        WiggleMaxLength solution = new WiggleMaxLength();
        int maxLength = solution.wiggleMaxLength02(nums);
        // 验证
        System.out.println(maxLength);

    }


    @Test
    public void testLongestCommonSubsequence() {
        // 输入
        String text1 = "abcde";
        String text2 = "ace";
        // 输出
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        int lcs = solution.longestCommonSubsequence02(text1, text2);
        // 验证
        System.out.println(lcs);
    }

    @Test
    public void testCanPartition() {
        // 输入
        int[] nums = {23, 13, 11, 7, 6, 5, 5};
        // 输出
        CanPartition solution = new CanPartition();
        boolean canPartition = solution.canPartition04(nums);
        // 验证
        System.out.println(canPartition);
    }

    @Test
    public void testFindTargetSumWays() {
        // 输入
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        // 输出
        FindTargetSumWays solution = new FindTargetSumWays();
        int targetSumWays = solution.findTargetSumWays02(nums, S);
        // 验证
        System.out.println(targetSumWays);
    }

    @Test
    public void testFindMaxForm() {
        // 输入
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        // 输出
        FindMaxForm solution = new FindMaxForm();
        int maxForm = solution.findMaxForm02(strs, m, n);
        // 验证
        System.out.println(maxForm);

    }

    @Test
    public void testCoinChange02() {
        // 输入
        int[] coins = {1};
        int amount = 0;
        // 输出
        CoinChange02 solution = new CoinChange02();
        int coinChange = solution.coinChange(coins, amount);
        // 验证
        System.out.println(coinChange);
    }

    @Test
    public void testChange() {
        // 输入
        int[] coins = {};
        int amount = 0;
        // 输出
        Change solution = new Change();
        int change = solution.change(amount, coins);
        // 验证
        System.out.println(change);
    }

    @Test
    public void testWordBreak() {
        // 输入
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        // 输出
        WordBreak solution = new WordBreak();
        boolean flag = solution.wordBreak(s, wordDict);
        // 验证
        System.out.println(flag);
    }

    @Test
    public void testCombinationSum4() {
        // 输入
        int[] nums = {1, 2, 3};
        int target = 4;
        // 输出
        CombinationSum4 solution = new CombinationSum4();
        int combinationSum4 = solution.combinationSum4(nums, target);
        // 验证
        System.out.println(combinationSum4);
    }

    @Test
    public void testMaxProfit() {
        // 输入
        int[] prices = {1, 2, 3, 0, 2};
        // 输出
        MaxProfit solution = new MaxProfit();
        int maxProfit = solution.maxProfit(prices);
        // 验证
        System.out.println(maxProfit);
    }

    @Test
    public void testMaxProfit02() {
        // 输入
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        // 输出
        MaxProfit02 solution = new MaxProfit02();
        int maxProfit = solution.maxProfit(prices, fee);
        // 验证
        System.out.println(maxProfit);
    }

    @Test
    public void testMaxProfit03() {
        // 输入
        int[] prices = {1};
        // 输出
        MaxProfit03 solution = new MaxProfit03();
        int maxProfit = solution.maxProfit(prices);
        // 验证
        System.out.println(maxProfit);
    }

    @Test
    public void testMaxProfit04() {
        // 输入
        int k = 2;
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        // 输出
        MaxProfit04 solution = new MaxProfit04();
        int maxProfit = solution.maxProfit02(k, prices);
        // 验证
        System.out.println(maxProfit);
    }

    @Test
    public void testMinDistance() {
        // 输入
        String word1 = "b", word2 = "a";
        // 输入
        MinDistance solution = new MinDistance();
        int minDistance = solution.minDistance02(word1, word2);
        // 验证
        System.out.println(minDistance);
    }

    @Test
    public void testEditDistance() {
        // 输入
        String word1 = "horse", word2 = "ros";
        // 输入
        EditDistance solution = new EditDistance();
        int minDistance = solution.minDistance(word1, word2);
        // 验证
        System.out.println(minDistance);
    }

    @Test
    public void testMinSteps() {
        // 输入
        int n = 7;
        // 输入
        MinSteps solution = new MinSteps();
        int minSteps = solution.minSteps02(n);
        // 验证
        System.out.println(minSteps);
    }
}
