package com.apollo.eraseOverlapIntervals;

import java.util.Arrays;

public class EraseOverlapIntervals {
    // 1.贪心算法
    // 时间复杂度: O(nlog2(n)) n:区间个数
    // 空间复杂度: O(1)
    // 问题转换: 先计算最多能组成的不重叠区间的个数, 最后利用区间总个数 减去 不重叠区间的个数
    // 最多能组成的不重叠区间的个数, 在每次选择中, 区间结尾最为重要, 选择区间结尾越小, 留给后边的区间的空间越大. 那么, 后边能够选择的区间个数也就越大
    // 区间相接, 下一个区间头 大于等于 当前的区间尾
    public int eraseOverlapIntervals(int[][] intervals) {
        // 0.过滤
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 1.排序
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);

        // 2.数据初始化
        int end = intervals[0][1];
        int count = 1;  // 初始值为1

        // 3.迭代
        for (int i = 0; i < intervals.length; i++) {
            // a.判断当前区间起始点与连接区间后端点的关系
            if (intervals[i][0] < end) {
                // 存在重叠, 跳到下一个区间
                continue;
            }
            // b.找到新的区间
            end = intervals[i][1];
            count++;
        }

        return intervals.length - count;
    }

}
