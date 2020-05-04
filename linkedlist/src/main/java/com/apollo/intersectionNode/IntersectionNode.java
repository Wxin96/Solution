package com.apollo.intersectionNode;

import com.apollo.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {
    // 1.容器思想
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 0.过滤
        if (headA == null || headB == null) {
            return null;
        }
        // 初始化容器
        Set<ListNode> set = new HashSet<>();

        // 1.遍历ListA，并存储容器
        do {
            set.add(headA);
        } while ((headA = headA.next) != null);

        // 2.遍历ListB，检验容器中是否有重复元素
        do {
            if (set.contains(headB)) {
                return headB;
            }
        } while ((headB = headB.next) != null);
        return null;
    }

    // 2。双指针方法
    // 利用两次遍历，等长。验证交点
    //  --------****
    //  ****--------
    public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {
        // 0.过滤
        if (headA == null || headB == null) {
            return null;
        }
        // 1.初始化
        ListNode node1 = headA, node2 = headB;

        // 2.遍历
        while (node1 != null || node2 != null) {
            if (node1 == node2) {
                return node1;
            }
            if (node1.next == null && node2.next == null) {
                break;
            }
            if (node1.next == null) {
                node1 = headB;
            } else {
                node1 = node1.next;
            }
            if (node2.next == null) {
                node2 = headA;
            } else {
                node2 = node2.next;
            }
        }
        return null;
    }

    //
    public ListNode getIntersectionNode03(ListNode headA, ListNode headB) {
        // 1.初始化
        ListNode node1 = headA, node2 = headB;

        // 2.遍历
        while (node1 != node2) {
            node1 = (node1 == null) ? headB : node1.next;
            node2 = (node2 == null) ? headA : node2.next;
        }
        return node1;
    }

}
