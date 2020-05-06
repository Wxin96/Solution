package com.apollo.utils;

import com.apollo.ListNode;

import java.util.LinkedList;
import java.util.List;

public class ListNodeUtil {

    // 根据数组生成链表，并返回头节点
    public static ListNode getListNode(int[] nums) {
        // 0. 过滤
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 1.使用容器集合
        List<ListNode> list = new LinkedList<>();
        // 2.遍历生成
        for (int num : nums) {
            list.add(new ListNode(num));
        }
        // 3.遍历安插关系
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        // 4.返回
        return list.get(0);
    }

    // 打印列表
    public static void printListNode(ListNode node) {
        if (node == null) {
            System.out.println("节点为空!");
            return;
        }
        do {
            System.out.println(node.val);
        } while((node = node.next)!=null);

    }


}
