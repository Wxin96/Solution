package com.apollo.canPlaceFlowers;

/**
 * 605. 种花问题(代码可用(不够优雅) => 学习别人代码, 细节处理)
 */
public class CanPlaceFlowers {
    // 1.贪心算法
    // 问题转化为最多能种多少花, 然后与n比较
    // 代码存在的问题:
    // 数组左右边界处理的有问题,
    // 这里我用的是一个变量, 最后一个数组单独处理方式;感觉有些混乱
    // 时间复杂度: O(n)  n: 数组的元素书 => 可以进一步优化, 达到了要求种植数目停止
    // 空间复杂度: O(1)
    // 思考: 若是不改变原数组结构, 可以使用boolean preFlower变量
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 0.过滤
        if (flowerbed == null) {
            return false;
        }
        // 1.数据初始化
        int count = 0;
        boolean preFlower = false;  // 前方是否有花
        // 2.遍历(0-length-2节点)
        for (int i = 0; i < flowerbed.length - 1; i++) {
            // a.判断当前节点是否已经中上花了
            if (flowerbed[i] == 1) {
                preFlower = true;
                continue;
            }

            // b.当前节点无花,(已验证)
            // 当前节点前节点无花
            // 并且后一节点也没有花
            if (!preFlower && flowerbed[i + 1] == 0) {
                // i.种花
                flowerbed[i] = 1;
                count++;
                preFlower = true;
            } else {
                preFlower = false;
            }

        }
        // 3.length-1节点
        if (!preFlower && flowerbed[flowerbed.length - 1] == 0) {
            count++;
        }

        return count >= n;
    }

    // 2.Cyc2018
    public boolean canPlaceFlowers02(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int cnt = 0;

        for (int i = 0; i < length && n > cnt; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = (i == 0) ? 0 : flowerbed[i - 1];
            int next = (i == length - 1) ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                flowerbed[i] = 1;
                cnt++;
            }

        }
        return cnt >= n;

    }

    // 3.优秀题解
    public boolean canPlaceFlowers03(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0
                    && (i - 1 == -1 ? 0 : flowerbed[i - 1]) == 0
                    && (i + 1 == flowerbed.length ? 0 : flowerbed[i + 1]) == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;

    }

}
