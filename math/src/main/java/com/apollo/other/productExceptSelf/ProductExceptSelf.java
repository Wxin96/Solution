package com.apollo.other.productExceptSelf;

import java.util.Arrays;

/**
 *  238. 除自身以外数组的乘积
 *  思考:
 *      1.最直接的方式, 创建一个长度等于nums的数组, 用nums数组的各个元素相乘填充, 遍历除以每个索引对应的值
 *      2.题目中, 不允许使用除法
 *          - 左右两个数组, 一个是从左到右乘, 一个从右到左乘, 两个对应元素互乘
 *          - 不使用两个数组, 使用中间变量累乘, 再与数组对应元素相乘 [空间复杂度:1]
 *  体会:
 *      重复利用之前已经做过的工作, 减去重复工作
 */
public class ProductExceptSelf {
    // 1.左右
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int[] productExceptSelf(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return null;
        }
        // 1.初始化数据
        int left = 1, right =1;
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        // 2.一次遍历
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
