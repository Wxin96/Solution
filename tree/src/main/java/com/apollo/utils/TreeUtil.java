package com.apollo.utils;

import com.apollo.TreeNode;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {
    public static final Logger logger = Logger.getLogger(TreeUtil.class);

    public static TreeNode generateTree(Integer[] nums) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            logger.info("输入有误!");
            return null;
        }
        // 1. 分析树
        // 树有几层
        int piles = (int) (Math.log(nums.length + 1) / Math.log(2)) + 1;
        logger.debug(piles);

        // 2. 根据层数形成树
        List<TreeNode> list = new ArrayList<>();
        for (Integer num : nums) {
            if (num == null) {
                list.add(null);
            } else {
                list.add(new TreeNode(num));
            }
        }
        logger.debug(list);
        // System.out.println(list);

        // 3.根据层数遍历形成树
        for (int i = 0; i < piles - 1; i++) {
            int count = (int) Math.pow(2, i + 1) - 1;
            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i + 1) - 1 && count < nums.length; j++) {
                if (list.get(j) == null) {
                    // null节点下是否有null子节点
                    if (list.get(count) == null){
                        count+=2;
                    }
                    continue;
                }
                list.get(j).left = list.get(count++);
                if (count >= nums.length) {
                    break;
                }
                list.get(j).right = list.get(count++);
            }

        }
        // 4.返回头节点
        return list.get(0);
    }

    public static void printTree(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head);
        printTree(head.left);
        printTree(head.right);
    }

}
