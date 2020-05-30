package com.apollo.bst.sortedListToBST;

import com.apollo.ListNode;
import com.apollo.TreeNode;

/**
 *  109. 有序链表转换二叉搜索树
 */
public class SortedListToBST {
    // 1.递归
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度:
    public TreeNode sortedListToBST(ListNode head) {
        // 1.递归终止
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 2.寻找中间前节点
        ListNode preMid = findPreMid(head);
        // 3.中间节点
        ListNode mid = preMid.next;
        preMid.next = null;
        // 4.树节点
        TreeNode curNode = new TreeNode(mid.val);
        // 5.树的左右节点
        curNode.left = sortedListToBST(head);
        curNode.right = sortedListToBST(mid.next);
        return curNode;
    }

    // 链表中, 找mid位置的前一位置
    private ListNode findPreMid(ListNode head) {
        // 0.特殊情况
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 1.初始化快慢指针和慢指针前一位置
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        // 2.遍历
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2.返回中节点的前一位置
        return pre;
    }

    // 2.递归+转化为数组

    // 3.中序遍历模拟
}
