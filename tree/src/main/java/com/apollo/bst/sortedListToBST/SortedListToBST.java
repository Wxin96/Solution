package com.apollo.bst.sortedListToBST;

import com.apollo.ListNode;
import com.apollo.TreeNode;

/**
 *  109. 有序链表转换二叉搜索树
 */
public class SortedListToBST {
    // 1.递归
    // 时间复杂度: O(n*log2(n))
    // 空间复杂度: O(long2(n))
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
    // 快慢指针, 查找中间位置时, 要注意快慢指针的起始位置, 快指针的停止
    // 此处由于链表的单指向性质, 返回中间位置的前一位置
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
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // 相比与前者, 空间复杂度升高, 时间复杂度降低
    // 此处使用的数组是 ArrayList, 虽然是链表的实现, 内部实质为接口

    // 3.中序遍历模拟（妙）
    // 时间复杂度: O(n)  n:链表节点数目
    // 空间复杂度: O(log2(n))
    private ListNode head;
    private int lenOfList(ListNode head) {
        // 0.特殊
        if (head == null) {
            return 0;
        }
        // 1.初始化变量
        int len = 0;
        // 2.迭代
        while (head != null) {
            len++;
            head = head.next;
        }
        // 3.返回
        return len;
    }

    private TreeNode constructTree(int left, int right) {
        // 1.递归终止
        if (left > right) {
            return null;
        }
        // 2.初始化中指针
        int mid = (left + right) >>> 1;
        // 3.模拟中序遍历
        // 左
        TreeNode leftTreeNode = constructTree(left, mid - 1);
        // 中
        TreeNode curTreeNoe = new TreeNode(head.val);
        curTreeNoe.left = leftTreeNode;
        head = head.next;   // 下一个
        // 右
        curTreeNoe.right = constructTree(mid + 1, right);
        // 4.递归传递
        return curTreeNoe;
    }

    // 初始化
    public TreeNode sortedListToBST02(ListNode head) {
        // 0.过滤
        if (head == null) {
            return null;
        }
        // 1.测长度
        int size = lenOfList(head);
        // 2.模拟中序遍历
        this.head = head;
        TreeNode root = constructTree(0, size - 1);
        // 3.返回
        return root;
    }

}
