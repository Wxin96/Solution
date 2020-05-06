package com.apollo.hasCycle;

import com.apollo.ListNode;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        // 0.过滤
        if (head == null) {
            return false;
        }
        // 1.初始化
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        // 2.遍历
        while (fastNode != slowNode) {
            if (fastNode!= null && fastNode.next != null) {
                fastNode = fastNode.next.next;
            } else {
                fastNode = null;
            }
            slowNode = slowNode.next;
        }

        return fastNode!=null;
    }

}
