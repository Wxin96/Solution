package com.apollo.constructArray;

/**
 *  667.优美的排列 II
 *      一个找规律题目,
 */
public class ConstructArray {
    // 1.找规律
    // 时间复杂度: O(n)  n: 数组元素数目
    // 空间复杂度: O(n)
    // 规律太粗糙
    public int[] constructArray(int n, int k) {
        // 0.过滤
        if (k < 1 || k > n) {
            return null;
        }
        // 1.初始化数据
        int[] nums = new int[n];
        // k范围
        int kStart = k + 1;
        int kEnd = k + 1 - k / 2 + (k / 2 != 0 ? 1 : 0);
        int len = Math.max(2, k - (k & 1));
        // 起始
        int num1 = 1;
        int num2 = kStart;
        // 2.前部分遍历
        for (int i = 0; i < len; i++) {
            nums[i] = i % 2 == 0 ? num1++ : num2--;
        }
        // 3.后部分遍历
        kStart = k+1;
        while (len < n) {

            while (num1 >= kEnd && num1 <= kStart) {
                num1++;
            }
            nums[len++] = num1++;

        }

        return nums;
    }

    // 2.更好的规律(CyC2018)
    // 时间复杂度: O(n)  n: 数组元素数目
    // 空间复杂度: O(n)
    // 把数组分为三部分
    // 第一部分: 1            [1]
    // 第二部分: k+1 2 ...    [k个, 间隔--]
    // 第三部分: k+2...n      [n-k-1]
    public int[] constructArray02(int n, int k) {
        // 0.过滤
        if (k < 1 || k > n) {
            return null;
        }
        // 1.初始化
        int[] nums = new int[n];
        nums[0] = 1;    // 雷打不动
        // 2.第一次遍历
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            // 奇偶不同值
            nums[i] = i % 2 == 1 ? nums[i-1] + interval : nums[i-1] - interval ;
        }
        // 3.第二次遍历
        for (int i = k+1; i < n; i++) {
            nums[i] = i+1;
        }
        return nums;
    }

    // 3.反转法
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public int[] constructArray03(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = i + 1;  //产生1~n个数
        if(k == 1) return res;  //k==1直接返回
        //k != 1就要翻转k - 1次，每次翻转保留前m个数
        for(int m = 1; m < k; m++)
            reverse(res, m, n - 1);
        return res;
    }
    //翻转数组[i,j]之间的数
    void reverse(int[] res, int i, int j){
        while(i < j){
            int t = res[i];
            res[i] = res[j];
            res[j] = t;
            i++;
            j--;
        }
    }
}
