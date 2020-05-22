package com.apollo.checkPossibility;

public class CheckPossibility {
    // 1.贪心算法
    // 时间复杂度: O(n)  n:数组元素个数
    // 空间复杂度: O(1)
    public boolean checkPossibility(int[] nums) {
        // 0. 过滤
        if (nums == null) {
            return false;
        }
        // 1.变量初始化
        int illegalCnt = 0;
        // 2.迭代
        for (int i = 0; i < nums.length - 1 && illegalCnt < 2; i++) {
            // a.如果当前值 > 下一个值
            if (nums[i] > nums[i + 1]) {
                illegalCnt++;
                // i.(i+1)值, 前边有两数(i, i+1)都比它大
                // (i+1)值 => i的值 看看后序列
                // 也就是说(i+1)为特殊值
                // 8 |9| 7 10
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    // ii. (i+1)为索引第2个数, 或者(i-1)的值 <= (i+1)的值
                    // 也就是说i为特殊值
                    // |9| 7 8
                    // 7 |9| 8 10
                    nums[i] = nums[i+1];
                }
            }
        }
        return illegalCnt < 2;
    }
}
