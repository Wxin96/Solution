package com.apollo.maxProfit;

/**
 * 121. 买卖股票的最佳时机
 */
public class MaxProfit {

    // 1.贪心算法
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int maxProfit(int[] prices) {
        // 0.过滤
        if (prices == null || prices.length < 1) {
            return 0;
        }

        // 1.当前最低价格
        int curLowest = prices[0];
        int maxProfit = 0;

        // 2.迭代
        for (int i = 1; i < prices.length; i++) {
            // a.如果当前股票比记录的低
            if (prices[i] < curLowest) {
                curLowest = prices[i];
            } else {
                // b.如果当前股票比记录的高
                maxProfit = Math.max(maxProfit, prices[i] - curLowest);
            }

        }

        return maxProfit;
    }



}
