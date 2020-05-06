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
方法: 双指针
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
    - 二分查找      时间复杂度:O($$\sqrt{c}logc$$)
    - 利用sqrt函数
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
-双指针
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

```
- 暴力算法
- 双指针

注意:
    左右都是两种情况, 左右检索 取||值
​
```

### [88\. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/description/)

Difficulty: **简单**


给你两个有序整数数组 _nums1_ 和 _nums2_，请你将 _nums2_ 合并到 _nums1 _中_，_使 _nums1_ 成为一个有序数组。

**说明:**

*   初始化 _nums1_ 和 _nums2_ 的元素数量分别为 _m_ 和 _n_ 。
*   你可以假设 _nums1 _有足够的空间（空间大小大于或等于 _m + n_）来保存 _nums2_ 中的元素。

**示例:**

```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
```


#### Solution

Language: **Java**

```
- 双指针, 尾插法
- 双指针, 头插法(建立新的数组)
- 合并后排序 System.arraycopy() 5个参数
​
```

### [141\. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

Difficulty: **简单**


给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。

**示例 1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

**示例 2：**

```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

**示例 3：**

```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
```

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

**进阶：**

你能用 _O(1)_（即，常量）内存解决此问题吗？


#### Solution

Language: **Java**

```
- 哈希表
- 双指针
快慢指针 一快一慢 null也是指针的一部分
null -> 头指针 -> ... -> 尾指针 -> null
​
```

### [524\. 通过删除字母匹配到字典里最长单词](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/description/)

Difficulty: **中等**


给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

**示例 1:**

```
输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

输出: 
"apple"
```

**示例 2:**

```
输入:
s = "abpcplea", d = ["a","b","c"]

输出: 
"a"
```

**说明:**

1.  所有输入的字符串只包含小写字母。
2.  字典的大小不会超过 1000。
3.  所有输入的字符串长度不会超过 1000。


#### Solution

Language: **Java**

```
- 双指针
1. compareTo()方法
用法: 按字典顺序比较两个字符串。
 - 如果参数字符串等于此字符串，则返回值 0；
 - 如果此字符串小于字符串参数，则返回一个小于 0 的值；
 - 如果此字符串大于字符串参数，则返回一个大于 0 的值。
​
```