package com.apollo.swapPairs;

import com.apollo.ListNode;

public class SwapPairs {
    // 一 递归
    // 两个看成一个单位
    public ListNode swapPairs(ListNode head) {
        // 0.过滤
        if (head == null || head.next ==null) {
            return head;
        }
        // 1.递归
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        // 2.返回结果
        return temp;
    }

    // 二 遍历法
    public ListNode swapPairs02(ListNode head) {
        // 0.过滤
        if (head == null || head.next ==null) {
            return head;
        }
        // 1.初始化变量
        ListNode curNode = head, preNode=null, result = head.next;

        while (curNode != null && curNode.next !=null) {
            ListNode temp = curNode.next;
            curNode.next = temp.next;
            temp.next = curNode;
            if (preNode != null) {
                preNode.next = temp;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return result;

    }

    // 三 遍历法
    public ListNode swapPairs03(ListNode head) {
        // 0.过滤
        if (head == null || head.next ==null) {
            return head;
        }
        // 1.初始化变量
        // 哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy, curNode = dummy.next;

        while (curNode != null && curNode.next !=null) {
            // a.初始化
            ListNode temp = curNode.next;

            // b.交换
            preNode.next = temp;
            curNode.next = temp.next;
            temp.next = curNode;

            // c.迭代
            preNode = curNode;
            curNode = curNode.next;

        }
        return dummy.next;

    }

}
