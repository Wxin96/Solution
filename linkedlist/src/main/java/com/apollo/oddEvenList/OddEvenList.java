package com.apollo.oddEvenList;

import com.apollo.ListNode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        // 0.过滤
        if (head == null || head.next==null) {
            return head;
        }
        // 1.初始化
        ListNode evenList = head.next;
        ListNode oddNode = head, evenNode = head.next;
        // 2.迭代
        while (evenNode!=null && evenNode.next!=null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        // 3.嫁接
        oddNode.next = evenList;

        return head;
    }
}
