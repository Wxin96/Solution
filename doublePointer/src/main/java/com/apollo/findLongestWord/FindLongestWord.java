package com.apollo.findLongestWord;

import java.util.List;

public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        // 0.过滤
        if (s == null || s.length()<1 || d == null || d.size()<1) {
            return "";
        }
        // 1.初始化
        String result = "";
        // 2.遍历
        for (String dictionary:d) {
            if(match(s, dictionary) && dictionary.length()>=result.length()) {
                if (dictionary.length()>result.length()) {
                    result = dictionary;
                    continue;
                }
                if (result.compareTo(dictionary)>0) {
                    result = dictionary;
                }
            }
        }

        return result;

    }

    private boolean match(String s, String dictionary) {
        // a.指针初始化
        int pointer1 = 0;
        int pointer2 = 0;
        // b.遍历匹配
        while(pointer1<s.length()&&pointer2<dictionary.length()) {
            if(s.charAt(pointer1++) == dictionary.charAt(pointer2)) {
                pointer2++;
            }
        }
        return pointer2==dictionary.length();
    }
}
