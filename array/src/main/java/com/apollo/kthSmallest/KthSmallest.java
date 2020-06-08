package com.apollo.kthSmallest;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 */
public class KthSmallest {
    // 1.使用小顶堆数据结构
    // 问题: 并没有利用矩阵行升序和列升序的性质
    // 时间复杂度: O(n) n: 矩阵元素数目 [缺失堆的时间复杂度]
    // 空间复杂度: O(n)
    public int kthSmallest(int[][] matrix, int k) {
        // 0.过滤
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return -1;
        }
        int n = matrix.length;
        if (n != matrix[0].length || k < 0 || k > n * n) {
            return -1;
        }
        // 1.初始化数据
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cnt = 0;
        // 2.遍历数组
        while (cnt < n * n) {
            heap.add(matrix[cnt / n][cnt % n]);
            cnt++;
        }
        // 3.排除前k-1个数
        while (k-- > 1) {
            heap.poll();
        }

        return heap.poll();
    }

    // 2.二分查找
    // 思想: 此处二分查找的不再是元素, 而是矩阵元素的数值范围
    // 提示: 思维不能局限, 学习的很多算法, 要会变换应用
    // 时间复杂度: O(n*log2(n)) n: 矩阵种元素的数值范围
    // 空间复杂度: O(1)
    public int kthSmallest02(int[][] matrix, int k) {
        // 0.过滤
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return -1;
        }
        // 1.矩阵大小 | 最大最小值
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1];
        // 2.二分查找
        while (left < right) {
            // a.中间值
            int mid = (left + right) >>> 1;
            // b.mid所在位置
            int count = count(matrix, mid);
            // c.二分
            if (count < k) {
                left = mid + 1;
            } else if (count == k) {
                right = mid;
            } else if (count > k) {
                right = mid;
            }
        }

        return right;
    }

    // 查找小于等于mid值, 矩阵matrix中的元素数
    private int count(int[][] matrix, int mid) {
        // 1.矩阵的大小
        int row = matrix.length, col = matrix[0].length;
        int i = 0;
        int cnt = 0;
        // 2.遍历矩阵
        while (i < row * col) {
            if (matrix[i / col][i % col] <= mid) {
                cnt++;
            }
            i++;
        }
        // 3.返回值
        return cnt;
    }

    // 3.堆解法2
    // 利用了矩阵行升序和列升序的性质
    // 思想: 现存第一行数据, 利用矩阵的行升序和列升序的性质, 去除(k-1)小顶堆中最小值, 并找它所在列下一个元素进队列(如果有下一个元素的话)
    // 此种方法去除了矩阵中的k-1个最小值, 此时第k个最小值在小顶堆根节点
    // 时间复杂度: O(n+k)    n:矩阵列数
    // 空间复杂度: O(n)
    public int kthSmallest03(int[][] matrix, int k) {
        // 0.过滤
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return -1;
        }
        // 1.初始化数据
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        // 2.初始化队列, 导入一行元素
        for (int i = 0; i < matrix[0].length; i++) {
            queue.offer(new Tuple(0, i, matrix[0][i]));
        }
        // 3.填加新的元素, 去除前k-1个小元素
        for (int i = 0; i < k - 1; i++) {
            // a.去除当前最小值
            Tuple curMin = queue.poll();
            // b.添加当前元素, 列中下一个值, 如果它有的话
            if (curMin.row == matrix.length - 1) {
                continue;
            }
            queue.offer(new Tuple(curMin.row + 1, curMin.col, matrix[curMin.row + 1][curMin.col]));
        }
        return queue.poll().val;
    }



}

// 自定义(row, col, value)的数据结构
class Tuple implements Comparable<Tuple> {
    int row;
    int col;
    int val;

    public Tuple(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple another) {
        return this.val - another.val;
    }
}
