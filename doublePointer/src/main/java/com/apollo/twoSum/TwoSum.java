package com.apollo.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // 方式一使用HashMAp
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        // 1.使用HashTab
        Map<Integer, Integer> map = new HashMap<>();
        // 2.遍历
        for (int i = 0; i < numbers.length; i++) {
            // 3. 寻找对应number对应数
            int anotherNum = target - numbers[i];
            // 4.如果存在匹配数
            if (map.containsKey(anotherNum)) {
                return new int[]{map.get(anotherNum), i + 1};
            } else {
                // 如果不存在
                map.put(numbers[i], i + 1);
            }
        }

        return null;
    }


    // 方式二 双指针
    public int[] twoSum02(int[] numbers, int target) {
        if (numbers == null) return null;
        // 0. 指针初始化
        int left = 0;
        int right = numbers.length - 1;
        // 1. 遍历查找
        while (left < right) {
            int res = numbers[left] + numbers[right];
            if (res == target) {
                return new int[]{left + 1, right + 1};
            } else if (res < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }


}
