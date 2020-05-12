package com.apollo.findKthLargest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {

    // 1.调用API排序
    // 时间复杂度为 O(NlogN)，空间复杂度为 O(1)
    public int findKthLargest(int[] nums, int k) {
        // 0. 过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 2. 堆排序法 应用
    public int findKthLargest02(int[] nums, int k) {
        // 0. 过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // if (nums.length == 1) {
        //     return nums[0];
        // }

        // 1. 初始化
        int temp = 0;

        // 2.构造大顶堆
        for (int i = nums.length / 2 + 1; i >= 0 && i < nums.length; i--) {
            buildBigTop(nums, i, nums.length);
        }
        // System.out.println(Arrays.toString(nums));

        // 3.找到第k个最大值
        for (int i = 0; i < k; i++) {
            // a.选择当前最大值到最后
            temp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[0];
            nums[0] = temp;
            // System.out.println(Arrays.toString(nums));
            // b.构造剩余的大顶堆
            buildBigTop(nums, 0, nums.length - i - 1);
            // System.out.println(Arrays.toString(nums));
        }

        // 4.返回
        return nums[nums.length - k];
    }

    private void buildBigTop(int[] arr, int startNode, int length) {
        // 1.初始化
        int initTopValue = arr[startNode];

        // 2.迭代
        for (int i = 2 * startNode + 1; i < length; i = 2 * i + 1) {
            // a.左右节点最大值(右节点要存在)
            if (i + 1 < length && arr[i + 1] > arr[i]) {
                i++;
            }
            // b.比较最大子节点与顶堆头节点的关系
            if (arr[i] > initTopValue) {
                // 原先根节点 = 最大子节点
                arr[startNode] = arr[i];
                // 相当于交换位置
                startNode = i;
            }
        }
        // 3.顶堆初始值到该属于的位置
        arr[startNode] = initTopValue;
    }


    // 3.创建大顶堆, 从小到大排序
    public int findKthLargest03(int[] nums, int k) {
        // 0. 过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        for (int num : nums) {
            queue.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.poll();
    }

    // 4.默认小顶堆, 维持k个小顶堆
    // 时间复杂度O(nlogk)  空间复杂度O(k)
    public int findKthLargest04(int[] nums, int k) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 1.初始化
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 2.遍历+维持k大小的小顶堆
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // 3.返回小顶堆的顶堆头
        return queue.peek();
    }


    // 5.快速选择
    // 时间复杂度 : 平均情况 O(N)，最坏情况 O(N^2)
    // 空间复杂度 : O(1)。
    public int findKthLargest05(int[] nums, int k) {
        // 0.过滤
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // 1.初始化
        k = nums.length - k;    // 在排好序的数组的索引
        int left = 0, right = nums.length - 1;
        // 2.迭代
        while (left <= right) {
            int partition = partition(nums, left, right);
            if (partition == k) {
                break;
            } else if (partition < k) {
                left = partition + 1;
            } else{
                right = partition -1;
            }
        }

        // 3.返回
        return nums[k];

    }

    private int partition(int[] arr, int left, int right) {
        // 1.初始化
        int pivot = arr[(left + right) / 2];
        // 2.迭代
        while (left <= right) {
            // a.寻找大于等于pivot的数
            while (arr[left] < pivot) {
                left++;
            }
            // b.寻找大于等于pivot的数
            while (arr[right] > pivot) {
                right--;
            }
            // c.排序完成
            if (left >= right) {
                break;
            }
            // d.交换
            swap(arr, left, right);
            // e.解决死循环问题
            if (arr[left] == pivot && arr[right] == pivot) {
                left++;
            }
        }
        // 3.返回中间索引
        return left;

    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
