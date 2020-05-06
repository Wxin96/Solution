package com.apollo.addTwoNumbers;

import com.apollo.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1.使用栈
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        // 2.存储节点
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.add(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.add(l2);
                l2 = l2.next;
            }
        }
        // 3.相加初始化
        ListNode dummy = new ListNode(-1);
        int carry = 0, a = 0, b = 0;
        // 4.执行相加过程
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry==1) {
            // a.初始化加数
            a = (stack1.isEmpty()) ? 0 : stack1.pop().val;
            b = (stack2.isEmpty()) ? 0 : stack2.pop().val;
            // b.相加
            ListNode sum = new ListNode((a+b+carry)%10);
            carry = (a+b+carry)/10;
            // c. 头插法
            sum.next = dummy.next;
            dummy.next = sum;
        }

        return dummy.next;
    }
}
