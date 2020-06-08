package com.apollo.singleNumber02;

/**
 *  260. 只出现一次的数字 III
 *      位运算 细节(优先级)
 *      异或去除相同元素, 再利用异或的性质, 二者不同元素=>1, 找到不同元素. 二次遍历, 以不同元素, 区分两数
 *      上边的操作是利用 掩码的思想
 */
public class SingleNumber02 {
    // 1.位运算
    // a & (-a) 可以获得a最低的非0位(借以区分两个数) [妙]
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int[] singleNumber(int[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return null;
        }
        // 1.第一次遍历
        int ref = 0;
        for (int i = 0; i < nums.length; i++) {
            ref ^= nums[i];
        }
        // 2.寻找二者不同的一位
        ref = ref&(-ref);
        int[] result = new int[2];
        // 3.第二次遍历
        for (int num : nums) {
            // 细节 "=="的优先级高于 "&"
            if ((num & ref) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    // 2.哈希映射
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)

    // 3.排序
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)

}
