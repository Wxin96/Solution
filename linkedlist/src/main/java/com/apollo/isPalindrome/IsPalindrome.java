package com.apollo.isPalindrome;

import com.apollo.ListNode;
import com.apollo.utils.ListNodeUtil;

import java.util.Stack;

public class IsPalindrome {

    // 一 使用stack
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    // [经LeetCode官方提示]可以优化, 检查一半即可
    // 比如根据stack大小 设置前后遍历标志
    public boolean isPalindrome(ListNode head) {
        // 0.过滤
        if (head == null) {
            return true;
        }
        // 1.初始化栈
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }

        // 2. 遍历
        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    // 二 快慢指针
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public boolean isPalindrome02(ListNode head) {
        // 0.过滤
        if (head == null) {
            return true;
        }
        // 1. 快慢指针 确定中心
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        slowNode = slowNode.next;
        System.out.println(slowNode);
        // 2. 反转链表
        ListNode reverseList = reverseList(slowNode);
        ListNodeUtil.printListNode(reverseList);
        ListNodeUtil.printListNode(head);
        // 3. 比对
        return match(head, reverseList);

    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        return dummy.next;
    }

    private boolean match(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }


    // 三 递归

    private ListNode preNode;

    public boolean isPalindrome03(ListNode head) {
        // 0.初始化
        preNode = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head != null) {
            if (!check(head.next)) {
                return false;
            }
            if (preNode.val != head.val){
                return false;
            }
            preNode = preNode.next;
        }
        return true;
    }

}
