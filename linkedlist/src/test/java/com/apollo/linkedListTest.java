package com.apollo;

import com.apollo.addTwoNumbers.AddTwoNumbers;
import com.apollo.deleteDuplicates.DeleteDuplicates;
import com.apollo.isPalindrome.IsPalindrome;
import com.apollo.mergeTwoLists.MergeTwoLists;
import com.apollo.oddEvenList.OddEvenList;
import com.apollo.removeNthFromEnd.RemoveNthFromEnd;
import com.apollo.reverseList.ReverseList;
import com.apollo.splitListToParts.SplitListToParts;
import com.apollo.swapPairs.SwapPairs;
import com.apollo.utils.ListNodeUtil;
import org.junit.Test;

public class linkedListTest {

    @Test
    public void testReverseList() {
        // 输入
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 输出
        ReverseList solution = new ReverseList();
        ListNode result = solution.reverseList(head);
        // 验证
        ListNode temp = result;
        do {
            System.out.println(temp.val);
        } while ((temp = temp.next) != null);

    }

    @Test
    public void testReverseList02() {
        // 输入
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 输出
        ReverseList solution = new ReverseList();
        ListNode result = solution.reverseList02(head);
        // 验证
        ListNode temp = result;
        do {
            System.out.println(temp.val);
        } while ((temp = temp.next) != null);
    }

    @Test
    public void testReverseList03() {
        // 输入
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 输出
        ReverseList solution = new ReverseList();
        ListNode result = solution.reverseList03(head);
        // 验证
        ListNode temp = result;
        do {
            System.out.println(temp.val);
        } while ((temp = temp.next) != null);
    }

    @Test
    public void testMergeTwoLists() {
        // 输入
        ListNode listNode1 = ListNodeUtil.getListNode(new int[]{1, 2, 4});
        ListNode listNode2 = ListNodeUtil.getListNode(new int[]{1, 3, 4});
        // 输出
        MergeTwoLists solution = new MergeTwoLists();
        ListNode result = solution.mergeTwoLists03(listNode1, listNode2);

        // 验证
        ListNodeUtil.printListNode(result);

    }

    @Test
    public void testDeleteDuplicates() {
        // 输入
        ListNode head = ListNodeUtil.getListNode(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 5});
        // 输出
        DeleteDuplicates solution = new DeleteDuplicates();
        ListNode listNode = solution.deleteDuplicates03(head);

        // 验证
        ListNodeUtil.printListNode(listNode);
    }

    @Test
    public void testRemoveNthFromEnd() {
        // 输入
        ListNode head = ListNodeUtil.getListNode(new int[]{1, 2, 3, 4, 5});
        // 输出
        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode listNode = solution.removeNthFromEnd(head, 5);

        // 验证
        ListNodeUtil.printListNode(listNode);
    }

    @Test
    public void testSwapPairs() {
        // 输入
        ListNode head = ListNodeUtil.getListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        // 输出
        SwapPairs solution = new SwapPairs();
        ListNode listNode = solution.swapPairs03(head);

        // 验证
        ListNodeUtil.printListNode(listNode);

    }


    @Test
    public void testAddTwoNumbers() {
        // 输入
        ListNode list1 = ListNodeUtil.getListNode(new int[]{7, 2, 4, 3});
        ListNode list2 = ListNodeUtil.getListNode(new int[]{5, 6, 4});
        // 输出
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode listNode = solution.addTwoNumbers(list1, list2);

        // 验证
        ListNodeUtil.printListNode(listNode);

    }

    @Test
    public void testIsPalindrome() {
        // 输入
        ListNode head = ListNodeUtil.getListNode(new int[]{1, 2, 3, 2, 1});
        // 输出
        IsPalindrome solution = new IsPalindrome();
        boolean result = solution.isPalindrome03(head);

        // 验证
        System.out.println(result);

    }

    @Test
    public void testSplitListToParts() {
        // 输入
        ListNode head = ListNodeUtil.getListNode(new int[]{});
        // 输出
        SplitListToParts solution = new SplitListToParts();
        ListNode[] listNodes = solution.splitListToParts(head, 3);

        // 验证
        for (ListNode listNode : listNodes) {
            ListNodeUtil.printListNode(listNode);
            System.out.println();
        }
    }

    @Test
    public void testOddEvenList() {
        // 输入
        ListNode head = ListNodeUtil.getListNode(new int[]{1, 2, 3, 4, 5, 6});
        // 输出
        OddEvenList solution = new OddEvenList();
        ListNode result = solution.oddEvenList(head);

        // 验证
        ListNodeUtil.printListNode(result);
    }
}
