### [160\. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/)

Difficulty: **简单**


编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表**：**
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

在节点 c1 开始相交。

**示例 1：**
![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png)
```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
```

**示例 2：**

![](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)
```
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
```

**示例 3：**
![](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)
```
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。
```

**注意：**

*   如果两个链表没有交点，返回 `null`.
*   在返回结果后，两个链表仍须保持原有的结构。
*   可假定整个链表结构中没有循环。
*   程序尽量满足 O(_n_) 时间复杂度，且仅用 O(_1_) 内存。


#### Solution

Language: **Java**

```
0. 暴力法  O(mn)   O(1)
1. 容器思想(哈希表法)   O(m+n)   O(m)/O(n)
2. 双指针      O(m+n)  O(1)
​
```

### [206\. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/description/)

Difficulty: **简单**


反转一个单链表。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**进阶:**  
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？


#### Solution

Language: **Java**

```
1. 递归
    终止返回 尾节点
    其他: 新的节点
时间复杂度：O(n)O(n)，假设 nn 是列表的长度，那么时间复杂度为 O(n)。
空间复杂度：O(n)O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 nn 层。
2. 迭代
    双指针
时间复杂度：O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)。
空间复杂度：O(1)。
3. 头插法
时间复杂度：O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)。
空间复杂度：O(1)。
注意:
null -> 头节点 -> .. -> 尾节点 -> null
头插法反转链表
哑结点应用 dummy
​
```

### [21\. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/description/)

Difficulty: **简单**


将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**示例：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```


#### Solution

Language: **Java**

```
1. 尾插法
时间复杂度：O(n + m)
空间复杂度：O(1)
2. 递归
时间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），函数 mergeTwoList 至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
空间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+mn+m 次，因此空间复杂度为 O(n+m)。

思考:
    链表是一个个Node连接在一起, 合并的过程就是重塑Node之间的关系, 原先链表一定不存在了
    这个题目中, 没有必要对每个Node进行操作, 如果一个链表遍历完了, 剩下的链表就能接上, 原本就存在连接关系
​
```

### [83\. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/)

Difficulty: **简单**


给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

**示例 1:**

```
输入: 1->1->2
输出: 1->2
```

**示例 2:**

```
输入: 1->1->2->3->3
输出: 1->2->3
```


#### Solution

Language: **Java**

```
1. 双指针遍历 O(n)   O(1)
2. 单指针遍历 O(n)   O(1)
3. 递归      O(n)   O(n)
    展开与合并
​
```

### [19\. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/)

Difficulty: **中等**


给定一个链表，删除链表的倒数第 _n _个节点，并且返回链表的头结点。

**示例：**

```
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```

**说明：**

给定的 _n_ 保证是有效的。

**进阶：**

你能尝试使用一趟扫描实现吗？


#### Solution

Language: **Java**

```
n 是列表长度
1. 两边遍历 先算出长度  O(n) O(1)
2. 双指针, n间距
​
```
### [24\. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

Difficulty: **中等**


给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

**你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。

**示例:**

```
给定 1->2->3->4, 你应该返回 2->1->4->3.
```


#### Solution

Language: **Java**

```
1. 递归
时间复杂度：O(N)，其中 N 指的是链表的节点数量。
空间复杂度：O(N)，递归过程使用的堆栈空间。
2. 迭代
    双指针, 哑节点的使用;
    这里以两个相邻节点为一个单位
时间复杂度：O(N)，其中 N 指的是链表的节点数量。
空间复杂度：O(1)
​
```

### [445\. 两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii/)

Difficulty: **中等**


给你两个 **非空** 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

**进阶：**

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

**示例：**

```
输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
```


#### Solution

Language: **Java**

```
1. 容器思想 栈
注意:
    第一位有进位
2. 链表转化为数, 数转化为链表
​
```
### [234\. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

Difficulty: **简单**


请判断一个链表是否为回文链表。

**示例 1:**

```
输入: 1->2
输出: false
```

**示例 2:**

```
输入: 1->2->2->1
输出: true
```

**进阶：**  
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？


#### Solution

Language: **Java**

```
1. 容器 栈O(n) O(n) 
注意:
    利用回文串的性质可以优化, 一半即可
2. 快慢指针 O(n)    O(1)
    参考答案才想出来, 利用快慢指针找到一般位置, 反转, 比对
    参考别人题解:
        进一步优化:
            一边遍历, 紧接着反转(逐步进行), 后边比较
3. 递归O(n) O(n) 
    利用了外置成员变量, 还真的可以啊
​
```

### [725\. 分隔链表](https://leetcode-cn.com/problems/split-linked-list-in-parts/)

Difficulty: **该题有新题解时你将收到通知**

该题有新题解时你将收到通知

#### Solution

Language: **Java**

```
1. 迭代法 O(n) O(n) 
应该用for循环
​
```

### [328\. 奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)

Difficulty: **中等**


给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

**示例 1:**

```
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
```

**示例 2:**

```
输入: 2->1->3->5->6->4->7->NULL 
输出: 2->3->6->7->1->5->4->NULL
```

**说明:**

*   应当保持奇数节点和偶数节点的相对顺序。
*   链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。


#### Solution

Language: **Java**

```
1.  迭代法 O(n) O(1)
    奇偶交叉迭代
    终止条件的判断, 分奇数结点和偶数节点两种情况
​
```