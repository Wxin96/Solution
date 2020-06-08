package com.apollo.moveZeroes;

/**
 *  283.移动零
 *  输入: [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    // 1.遍历
    // 思路: 非零元素往前排, 剩余元素设置为0
    // 上思路有雏形, 但不知道具体代码怎么写
    // 时间复杂度: O(n)
    // 空间负载的: O(1)
    public void moveZeroes(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return;
        }
        // 1.初始化变量
        int pointer = 0;
        // 2.遍历
        // 遍历元素, 通过指针将非零元素往前排
        // 由于有0只会向前排, 所以不会冲突
        // 非零前排
        for (int num : nums) {
            if (num != 0) {
                nums[pointer++] = num;
            }
        }
        // 3.末尾填零
        while (pointer < nums.length) {
            nums[pointer++] = 0;
        }
    }

    // 2.类似快排
    // 这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
    // 这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
    // 这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // 过程复盘, 起始i和pivot是同步的, 直到遇到0,二者岔开
    public void moveZeroes02(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return;
        }
        // 1.指针
        int pivot = 0;
        // 2.遍历
        for (int i = 0; i < nums.length; i++) {
            // i位置的值不等于0
            if (nums[i] != 0) {
                // i索引大于pivot
                if (i > pivot) {
                    nums[pivot] = nums[i];
                    nums[i] = 0;
                }
                pivot++;
            }
        }
    }


}
