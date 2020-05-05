package com.apollo.mergeTwoLists;

import com.apollo.ListNode;

public class MergeTwoLists {
    // 一 初始想法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 0.过滤
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // 1.初始化
        ListNode newList = new ListNode(-1);
        ListNode node1 = l1, node2 = l2, temp = newList;
        // 2.遍历，
        while (node1 != null || node2 != null) {
            while ( node1!=null && (node2==null || node1.val <= node2.val)) {
                temp.next = node1;
                node1 = node1.next;
                temp = temp.next;
            }
            while ( node2 != null && (node1==null || node2.val < node1.val)) {
                temp.next = node2;
                node2 = node2.next;
                temp = temp.next;
            }
        }
        return newList.next;
    }

    // 二 迭代法
    public ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        // 0.过滤
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 1.尾插法
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        // 2.遍历
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;

        return head.next;
    }


    // 三 递归法
    public ListNode mergeTwoLists03(ListNode l1, ListNode l2) {
        // 0.过滤
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 1.递归判断
        if (l1.val  < l2.val) {
            l1.next = mergeTwoLists03(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists03(l1, l2.next);
            return l2;
        }
    }

}
