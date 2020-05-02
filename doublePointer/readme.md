### [167\. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

Difficulty: **简单**


给定一个已按照 **_升序排列_ ** 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值index1 和 index2，其中 index1 必须小于 index2_。_

**说明:**

*   返回的下标值（index1 和 index2）不是从零开始的。
*   你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

**示例:**

```
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
```


#### Solution

1. 这里是有序数组;
2. 双指针操作, 思维不要只是从头开始;

### [633\. 平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers/)

Difficulty: **简单**


给定一个非负整数 `c` ，你要判断是否存在两个整数 `a` 和 `b`，使得 a<sup>2</sup> + b<sup>2</sup> = c。

**示例1:**

```
输入: 5
输出: True
解释: 1 * 1 + 2 * 2 = 5
```

**示例2:**

```
输入: 3
输出: False
```


#### Solution
1. 问题转化为在 [0, (int)sqrt(c)] 寻找两个数平方和为c;
2. 既然是寻找问题, 而且是 **有序数组**
    - 双指针
    - 二分查找
3. 数学方式, 费马平方和定理

### [345\. 反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string/)

Difficulty: **简单**


编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

**示例 1:**

```
输入: "hello"
输出: "holle"
```

**示例 2:**

```
输入: "leetcode"
输出: "leotcede"
```

**说明:**  
元音字母不包含字母"y"。


#### Solution

1. 双指针,两种方式, 初始化有数/无数
2. 判断是不是原因两种方式, 查表, 方法判断(快)
3. 指针的位置,两个都在头,一头一尾,两尾

### [680\. 验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/)

Difficulty: **简单**


给定一个非空字符串 `s`，**最多**删除一个字符。判断是否能成为回文字符串。

**示例 1:**

```
输入: "aba"
输出: True
```

**示例 2:**

```
输入: "abca"
输出: True
解释: 你可以删除c字符。
```

**注意:**

1.  字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。


#### Solution

Language: **Java**

```java
​
```