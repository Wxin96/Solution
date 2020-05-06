package com.apollo.splitListToParts;

import com.apollo.ListNode;

public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        // 0.过滤

        // 1.计算链表长度
        int nodes = countNodes(root);
        // k 份数
        // 余数(有的会多一个)
        int residue = nodes % k;
        // 商(每份中基础数)
        int quotient = nodes / k;

        // 2.分配
        ListNode curNode = root;
        ListNode[] lists = new ListNode[k];
        int i = 0;
        while (residue > 0 || (quotient > 0 && k > 0)) {
            // a. 容量确定
            int volume = (residue-- > 0) ? quotient + 1 : quotient;
            // b. 添加对应的节点
            ListNode temp = curNode;
            while (--volume > 0) {
                temp = temp.next;
            }
            lists[i++] = curNode;
            curNode = temp.next;
            temp.next = null;
            k--;

        }

        return lists;
    }

    private int countNodes(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
