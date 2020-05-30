package com.apollo.utils;

import com.apollo.ListNode;

public class ListUtil {

    // 有数组生成链表
    public static ListNode generateList(Integer[] nums) {
        // 0.特殊情况
        if (nums == null || nums.length < 1) {
            return null;
        }
        // 1.链表头
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        // 2.遍历(尾插法)
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        // 3.返回
        return head;
    }

}
