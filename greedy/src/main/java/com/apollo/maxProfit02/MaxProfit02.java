package com.apollo.maxProfit02;

public class MaxProfit02 {
    // 1.贪心算法
    // 支持多次买卖
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 问题分析:
    // 股票在上升的,我们就买入再卖出.相当于折线图上升钱数汇总
    public int maxProfit(int[] prices) {
        // 0.过滤
        if (prices == null || prices.length < 1) {
            return 0;
        }

        // 1.记录变量
        int curStock = prices[0];
        int maxProfit = 0;

        // 2.迭代
        for (int i = 1; i < prices.length; i++) {
            // a.当前股票价格高于持有股票
            if (prices[i] > curStock) {
                maxProfit += prices[i] - curStock;
                curStock = prices[i];
            } else {
                // b.股票下跌了
                curStock = prices[i];
            }
        }

        return maxProfit;

    }

}
