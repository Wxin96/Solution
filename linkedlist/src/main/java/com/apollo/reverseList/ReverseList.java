package com.apollo.reverseList;

import com.apollo.ListNode;

public class ReverseList {
    // 一 递归思想
    // 单链表，链表的当前节点和链表的当前节点下一节点
    public ListNode reverseList(ListNode head) {
        // 1 筛选加递归终止
        if (head == null || head.next == null) {
            return head;
        }
        // 当前节点的下一节点
        ListNode next = head.next;
        // 将下一节点传入stack中
        ListNode newNode = reverseList(next);
        // 当前节点的下一节点的下一节点设置为当前节点
        // 位置绑定，无法通过next索引head但是之前head已存在
        next.next = head;
        // 当前节点后节点设置为空, 避免出现环
        head.next = null;
        // 返回新节点
        return newNode;
    }

    // 二 遍历思想
    // null 也看做链表的一个节点
    public ListNode reverseList02(ListNode head) {
        // 0. 过滤
        if (head == null) {
            return null;
        }
        // 1.初始化
        ListNode preNode = null;
        ListNode curNode = head;
        // 2.遍历
        while (curNode != null) {
            // a. 临时变量
            ListNode temp = curNode.next;
            // b. 变换
            curNode.next = preNode;
            // c. 指向前移
            preNode = curNode;
            curNode = temp;
        }

        return preNode;
    }

    // 三 头插法
    // 建立一条新的链表，每次都是从头节点和此节点之间插入
    // 需要一个链表头
    public ListNode reverseList03(ListNode head) {
        // 0. 过滤
        if (head == null) {
            return null;
        }
        // 1.初始化 头插链表
        ListNode newNode  = new ListNode(-1);

        while(head != null) {
            ListNode temp = head.next;
            head.next = newNode.next;
            newNode.next = head;
            head = temp;
        }

        return newNode.next;
    }


}


