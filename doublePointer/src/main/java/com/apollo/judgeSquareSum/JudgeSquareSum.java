package com.apollo.judgeSquareSum;

public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        // 1. 求根号下c
        int intege_sqrt_C = (int) Math.sqrt(c);
        // 2. 左右节点
        int left = 0;
        int right = intege_sqrt_C;
        while (left <= right) {
            int squareSum = left * left + right * right;
            if (squareSum == c){
                return true;
            } else if (squareSum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

}
