package com.apollo.reverseList;

public class ReverseList {
    // 一 递归思想
    public ListNode reverseList(ListNode head) {
        // 1 筛选加递归终止
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = reverseList(next);
        next.next = head;
        head.next = null;
        return newNode;
    }
}


