package com.apollo.other.isPowerOfThree;

/**
 *  326. 3的幂
 *      考察：数学
 *      1.3的幂, 可以一直被三整除, 直至等于1
 *      2.int中, 最大的3的幂是1162261467, 其他3的幂都是它的因式
 */
public class IsPowerOfThree {
    // 1.迭代法
    // 时间复杂度: O(log3(n))
    // 空间复杂度: O(1)
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    // 2.3的幂的性质
    // 时间复杂度: O(1)
    // 空间复杂度: O(1)
    public boolean isPowerOfThree02(int n) {
        return n>0&&1162261467%n==0;
    }
}
