package com.apollo.lcmAndGcd.lcm;

import com.apollo.lcmAndGcd.gcd.GreatestCommonDivisor;

/**
 *  2.2 最小公倍数
 */
public class LeastCommonMultiple {
    // 利用公式法, lcm = a*b/gcd
    public int lcm(int a, int b) {
        return a * b / (new GreatestCommonDivisor()).gcd(a, b);
    }

}
