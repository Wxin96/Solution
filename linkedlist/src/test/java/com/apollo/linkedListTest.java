package com.apollo;

import com.apollo.reverseList.ListNode;
import com.apollo.reverseList.ReverseList;
import org.junit.Test;

public class linkedListTest {

    @Test
    public void testReverseList() {
        // 输入
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 输出
        ReverseList solution = new ReverseList();
        ListNode result = solution.reverseList(head);
        // 验证
        ListNode temp = result;
        do {
            System.out.println(temp.val);
        } while ((temp = temp.next) != null);

    }
}
