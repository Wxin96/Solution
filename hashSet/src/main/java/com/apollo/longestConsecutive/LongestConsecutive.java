package com.apollo.longestConsecutive;

import java.util.*;

/**
 * 128. 最长连续序列
 */
public class LongestConsecutive {
    // 1.哈希表和线性空间构造(参考官方回答)
    // 时间复杂度: O(n)  n:数组的元素数目
    // 尽管在 for 循环中嵌套了一个 while 循环，时间复杂度看起来像是二次方级别的。
    // 但其实它是线性的算法。因为只有当 currentNum 遇到了一个序列的开始，
    // while 循环才会被执行（也就是 currentNum-1 不在数组 nums 里），
    // while 循环在整个运行过程中只会被迭代 nn 次。这意味着尽管看起来时间复杂度为 O(n^2) ，
    // 实际这个嵌套循环只会运行O(n+n)=O(n) 次。所有的计算都是线性时间的，所以总的时间复杂度是 O(n) 的。
    // 空间复杂度: O(n)
    public int longestConsecutive(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.初始化数据
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        // 数据进哈希表
        for (int num : nums) {
            set.add(num);
        }
        // 2.迭代
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                // a.初始化变量
                int curLength = 1;  // 此次长度
                int index = num + 1;    // 索引
                // b.遍历拼串
                while (set.contains(index)) {
                    curLength++;
                    index++;
                }
                // c.记录长度
                longest = Math.max(longest, curLength);
            }
        }
        return longest;
    }

    // 2.哈希表, 回溯
    // 时间复杂度: O(n)  n:数组的元素数目
    // 空间复杂度: O(n)
    public int longestConsecutive02(int[] nums) {
        // 0.过滤
        if (nums == null) {
            return 0;
        }
        // 1.初始化数据
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        // 添加数据, 键值初始化为1
        Arrays.stream(nums)
                .forEach(x -> map.put(x, 1));
        // 2.回溯
        for (int num : nums) {
            longest = Math.max(longest, forward(map, num));
        }
        // 3.寻找最大值
        return longest;
    }

    private int forward(Map<Integer, Integer> map, int num) {
        //0.递归终止
        if (!map.containsKey(num)) {
            return 0;
        }
        // 1.初始化变量
        int cnt = map.get(num);
        // 2.判断是否已经遍历过了
        // 很重要, 线性遍历的基础
        if (cnt > 1) {
            return cnt;
        }
        // 2.回溯
        cnt = forward(map, num + 1) + 1;
        // 3.修改map的值
        map.put(num, cnt);
        // 4.返回上一层
        return cnt;
    }
}
