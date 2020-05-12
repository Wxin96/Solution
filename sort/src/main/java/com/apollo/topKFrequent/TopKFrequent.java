package com.apollo.topKFrequent;

import java.util.*;

public class TopKFrequent {

    // 1.堆排序法
    // 时间复杂度: O(nlogk)
    // 空间复杂度: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // 0.过滤 (只有一个元素?)
        if (nums == null || nums.length < 1) {
            return null;
        }
        // 1.初始化
        // 空间复杂度: O(n)
        Map<Integer, Integer> map = new HashMap<>();

        // 2.遍历
        // 时间复杂度: O(n)
        // API:map.getOrDefault(key, defaultValue)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // System.out.println(map);

        // 3.小顶堆
        // 空间复杂度: O(k)
        // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

        // 4.迭代
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(key);
            } else if (map.get(priorityQueue.peek()) < map.get(key)) {
                priorityQueue.poll();
                priorityQueue.offer(key);
            }
        }

        // 5.把结果存储到数组中
        int[] target = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            target[i] = priorityQueue.poll();
        }

        return target;
    }

    // 2.桶排序法
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int[] topKFrequent02(int[] nums, int k) {
        // 0.过滤 (只有一个元素?)
        if (nums == null || nums.length < 1) {
            return null;
        }
        // 1.初始化
        // 空间复杂度: O(n)
        Map<Integer, Integer> map = new HashMap<>();

        // 2.遍历
        // 时间复杂度: O(n)
        // API:map.getOrDefault(key, defaultValue)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 3.桶排序
        // 空间复杂度: O(n)
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        // 4.装桶
        // 时间复杂度: <O(n)
        for (Integer key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new ArrayList<>();
            }
            bucket[map.get(key)].add(key);
        }

        // 5.把结果存储到数组中
        // 时间复杂度: O(k)
        int[] result = new int[k];
        int count = 0;
        for (int i = nums.length; i > 0 && count < k; i--) {
            if (bucket[i] == null) {
                continue;
            }
            // 遍历
            for (int j = 0; j < bucket[i].size() && count < k; j++) {
                result[count++] = bucket[i].get(j);
            }
        }

        return result;
    }


}
