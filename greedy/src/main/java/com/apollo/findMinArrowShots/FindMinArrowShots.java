package com.apollo.findMinArrowShots;

import java.util.Arrays;

public class FindMinArrowShots {
    // 1.贪心算法
    // 435. 无重叠区间变型
    // 思考:
    // 贪心算法求解在问题的转化, 如何贪心等效
    public int findMinArrowShots(int[][] points) {
        // 0.过滤
        if (points == null || points.length == 0) {
            return 0;
        }
        // 1.排序
        Arrays.sort(points, (x, y) -> x[1] - y[1]);
        // 2.数据初始化
        int end = points[0][1];
        int count = 1;  // 初始值为1
        // 3.迭代
        for (int i = 0; i < points.length; i++) {
            // a.判断当前区间起始点与连接区间后端点的关系
            if (points[i][0] <= end) {
                // 存在重叠, 跳到下一个区间
                continue;
            }
            // b.找到新的区间
            end = points[i][1];
            count++;
        }
        return count;
    }
}
