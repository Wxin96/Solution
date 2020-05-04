package com.apollo.deleteDuplicates;

import com.apollo.ListNode;

public class DeleteDuplicates {
    // 一 双指针遍历
    // 用单指针可以解决
    public ListNode deleteDuplicates(ListNode head) {
        // 0.过滤
        if (head == null) {
            return null;
        }
        // 1.指针初始化
        ListNode curNode = head, nextNode = head.next;
        // 2.遍历
        while (nextNode != null) {
            // curNode与nextNode不同
            if (curNode.val != nextNode.val) {
                curNode = nextNode;
                nextNode = nextNode.next;
            } else {
                // curNode与nextNode相同
                nextNode = nextNode.next;
                curNode.next = nextNode;
            }
        }

        return head;
    }

    // 二 递归
    public ListNode deleteDuplicates02(ListNode head) {
        // 0.过滤
        if (head == null || head.next == null) {
            return head;
        }
        // 1.递归
        if (head.val == head.next.val) {
            head = deleteDuplicates02(head.next);
        } else {
            head.next = deleteDuplicates02(head.next);
        }
        return head;
    }

    // 三 递归
    // 我的想法是在展开时候消灭重复项
    // 此种方法是栈回归过程合并重复项
    public ListNode deleteDuplicates03(ListNode head) {
        // 0.过滤
        if (head == null || head.next == null) {
            return head;
        }
        // 1.递归
        head.next = deleteDuplicates03(head.next);
        return (head.val == head.next.val) ? head.next : head;
    }

}
