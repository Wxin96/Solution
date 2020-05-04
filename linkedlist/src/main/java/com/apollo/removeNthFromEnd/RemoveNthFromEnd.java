package com.apollo.removeNthFromEnd;

import com.apollo.ListNode;

public class RemoveNthFromEnd {
    // 方法一： 双指针
    // Maintain two pointers and update one with a delay of n steps.提示
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 0. 过滤
        if (head == null || n < 0) {
            return head;
        }
        // 1.双指针初始化
        ListNode slowPointer = head;
        // 找到要删除的节点的前一个节点
        ListNode fastPointer = head;
        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
        }
        // 要删除第一个节点
        if (fastPointer == null) {
            return head.next;
        }
        // 2.遍历
        while(fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        // 3.删除对应节点
        slowPointer.next = slowPointer.next.next;

        return head;
    }

    // 两次遍历， 第一次目的是算长度
    // 设置dummy节点， 哑节点解决头节点问题

    // 递归， 无法传递n
    public ListNode removeNthFromEnd02(ListNode head, int n) {
        // 0. 过滤
        if (head == null || n < 0) {
            return head;
        }
        // 1.递归开始
        head.next = removeNthFromEnd(head.next, n);
        return null;

    }

}
