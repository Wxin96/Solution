package com.apollo.lcmAndGcd.countPrimes;

import java.util.Arrays;

/**
 *  204. 计数质数
 *  1.一般思路：
 *      遍历2-n，根据质数性质, 判断每个数是不是质数, 累加质数的个数
 *  2.质数的性质反用, 质数的倍数不再是质数
 *  总结:
 *      1.性质的正反利用
 *      2.优化, 是对案例的分析, 推演, 多动笔
 */
public class CountPrimes {
    // 1.质数的性质反用, 标记位+线性扫描判断n内质数的性质
    // 2是质数, 2*2, 2*3, ... 都是合数
    // 问题:
    //  有重复遍历, 比如质数2 2*3 质数3*2
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int countPrimes(int n) {
        // 0.过滤
        if (n <= 2) {
            return 0;
        }
        // 1.初始化数据
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        // 2.第一次循环, 标定素数
        for (int i = 2; i < n; i++) {
            // a.此数不是素数
            if (!isPrimes[i]) {
                continue;
            }
            // b.此数是素数
            for (int j = 2 * i; j < n; j += i) {
                isPrimes[j] = false;
            }
        }
        // 3.二次遍历, 计算素数个数
        int cnt = -2;
        for (boolean isPrime : isPrimes) {
            if (isPrime) {
                cnt++;
            }
        }
        return cnt;
    }

    // 2.对上代码进行优化
    // a.第二次遍历, 可以在第一次遍历中完成
    // b.从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了(去除之前的重复遍历)
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int countPrimes02(int n) {
        // 0.过滤
        if (n <= 2) {
            return 0;
        }
        // 1.初始化数据
        int cnt = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        // 2.第一次循环, 标定素数
        for (int i = 2; i < n; i++) {
            // a.此数不是素数
            if (!isPrimes[i]) {
                continue;
            }
            // b.此数是素数
            cnt++;
            // [从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了]
            // 存在整数溢出问题
            for (long j = (long)i * i; j < n; j += i) {
                isPrimes[(int)j] = false;
            }
        }
        // 3.二次遍历, 计算素数个数
        return cnt;
    }

    // 3.对上代码进一步优化[偶数>2 都是合数, 我们可以不遍历]
    // a.仅对奇数进行判断, 从3开始的奇数判断素数与否
    // b.奇数(2n+1)有n个奇数, 偶数(2n)有n个奇数, 不包括当前数. 将2看作1. 初始个位为n/2个
    // c.i * i = n的性质再次利用, i能处理n中的所有非素数, n=a*b, a!=b, a和b中有一个 < i
    // 时间复杂度: O(n/2) => O(n)
    // 空间复杂度: O(n)
    public int countPrimes03(int n) {
        // 0.过滤
        if (n <= 2) {
            return 0;
        }
        // 1.初始化数据
        // 小于n的奇数数目, 和奇数遍历搭配,
        int cnt = n / 2;
        boolean[] isPrimes = new boolean[n];
        // 2.遍历
        // +=2体现是奇数层遍历
        // i * i < n
        for (int i = 3; i * i < n; i += 2) {
            // a.不是素数 => true
            if (isPrimes[i]) {
                continue;
            }
            // b.是素数
            // += 2 * i奇数层遍历
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isPrimes[j]) {
                    --cnt;
                    isPrimes[j] = true;
                }
            }
        }
        return cnt;
    }
}
