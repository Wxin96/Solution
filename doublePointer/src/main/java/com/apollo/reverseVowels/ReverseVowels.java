package com.apollo.reverseVowels;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    private final static Set<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U',
            'a', 'e', 'i', 'o', 'u'));

    public String reverseVowels(String s) {
        // 0.筛选
        if (null == s) {
            return null;
        }
        if (s.length() <= 1){
            return s;
        }
        // 1. 初始化(char数组、左右指针)
        char[] chars = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;

        // 2. 遍历
        while (left <= right) {
            // a. 左边不是元音字母赋值
            if (!set.contains(s.charAt(left))) {
                chars[left] = s.charAt(left);
                left++;
            }
            // b. 右边不是元音字母赋值
            if (!set.contains(s.charAt(right))) {
                chars[right] = s.charAt(right);
                right--;
            }
            // c. left和right都有元音字母
            if (set.contains(s.charAt(left)) && set.contains(s.charAt(right))) {
                // i left和right相等
                if (left == right) {
                    chars[left] = s.charAt(left);
                    break;
                } else {
                    // ii left和right不等
                    chars[left] = s.charAt(right);
                    chars[right] = s.charAt(left);
                    left++;
                    right--;
                }
            }

        }

        return new String(chars);
    }

    public String reverseVowels02(String s) {
        // 0.筛选
        if (null == s) {
            return null;
        }
        if (s.length() <= 1){
            return s;
        }
        // 1. 初始化(char数组、左右指针)
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        // 2. 遍历
        while (left <= right) {
            // a. 左边不是元音字母赋值
            while (left < s.length() &&!set.contains(chars[left])) {
                left++;
            }

            // b. 右边不是元音字母赋值
            while (right >= left && !set.contains(chars[right])) {
                right--;
            }
            // c. left和right都有元音字母
            if (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            } else if (left == right){
                break;
            }
        }

        return new String(chars);
    }

    public String reverseVowels03(String s) {
        // 0.筛选
        if (null == s) {
            return null;
        }
        if (s.length() <= 1){
            return s;
        }
        // 1. 初始化(char数组、左右指针)
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        // 2. 遍历
        while (left <= right) {
            // a. 左边不是元音字母赋值
            while (left < s.length() &&jude(chars[left])) {
                left++;
            }

            // b. 右边不是元音字母赋值
            while (right >= left && jude(chars[right])) {
                right--;
            }
            // c. left和right都有元音字母
            if (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            } else if (left == right){
                break;
            }
        }

        return new String(chars);
    }

    // 速度比查表速度快
    private boolean jude(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }


}
