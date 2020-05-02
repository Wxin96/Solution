package com.apollo.validPalindrome;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        // (条件给定非空)
        // 0. 过滤
        if (s.length() <= 1) {
            return true;
        }
        // 1.初始化左右指针, 余量一位判断
        int left = 0, right = s.length() - 1;
        boolean margin = true;

        // 2.遍历
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (margin) {
                margin = false;
                if (s.charAt(left + 1) == s.charAt(right)
                        && s.charAt(left) == s.charAt(right-1)){
                    return judgePalindrome(s.substring(left+1, right+1))||judgePalindrome(s.substring(left, right));
                }
                if (s.charAt(left + 1) == s.charAt(right)) {
                    left += 2;
                    right--;
                } else if (s.charAt(left) == s.charAt(right-1)){
                    left++;
                    right -= 2;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


    private boolean judgePalindrome(String s) {
        // 初始化左右指针
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
