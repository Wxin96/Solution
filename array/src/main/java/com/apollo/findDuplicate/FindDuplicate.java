package com.apollo.findDuplicate;

/**
 *  287. 寻找重复数
 *     nums的长度为n+1, 元素范围为: 1-n, 已知至少存在一个重复整数
 */
public class FindDuplicate {
    // 1.二分查找
    // 思想: 已知数组的范围, 根据范围二分查找到重复的数. 正常 left-mid范围内有 mid - left +1个数
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(1)
    public int findDuplicate(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.初始化左右指针
        int left = 0, right = nums.length;
        // 2.二分查找
        while (left < right) {
            // a.中间数
            int mid = (left + right) >>> 1;
            // b.查找小于等于mid值的数目
            int count = count(nums, mid);
            // c.二分
            if (mid == count) {
                left = mid +1;
            } else if (mid > count) {
                left = mid + 1;
            } else if (mid < count) {
                right = mid;
            }
        }

        return right;
    }

    // 查找小于等于mid值, 数组nums中的元素数
    private int count(int[] nums, int mid) {
        // 1.初始化变量
        int cnt = 0;
        // 2.遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                cnt++;
            }
        }
        // 3.返回值
        return cnt;
    }

    // 2.双指针(环的入口点)
    // 为什么能形成环, 而且是在开头第一个环中, 首先这个映射关系一定能形成环, 长度为n+1, 数字都在 1-n中
    // 没有0, 由第一个元素形成环无法闭合, 其他闭合是自闭和与0索引元素没有交集. 把0元素改成重复元素, 之前的闭环, 变成-O
    // 数组这种映射关系形成一个链表, 重复元素为进闭环索引, 采用快慢指针寻找此索引
    // 时间复杂度: O(n)  n: 数组元素数目
    // 空间复杂度: O(1)
    public int findDuplicate02(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return -1;
        }
        // 1.快慢指针初始化
        // 起点从0开始
        int slow = nums[0];
        int fast = nums[slow];
        // 2.第一次相遇
        while (fast != slow) {
            // 迭代
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 3.第二次相遇
        fast = 0;
        while (fast != slow) {
            // 迭代
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
