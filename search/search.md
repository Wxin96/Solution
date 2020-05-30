### [69\. x 的平方根](https://leetcode-cn.com/problems/sqrtx/description/)

Difficulty: **简单**


实现 `int sqrt(int x)` 函数。

计算并返回 _x_ 的平方根，其中 _x_ 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

**示例 1:**

```
输入: 4
输出: 2
```

**示例 2:**

```
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
```


#### Solution

Language: **Java**

```
1.改造二分查找
    时间复杂度: O(log(x))
    空间复杂度: O(1)
思考:
    1. 二分法的细节要仔细研究, 对应题目的二分, 用实例具体分析
    2. 此处, 有int溢出问题
    3. 采用除法, 循环条件left<=right, 结束循环right值小, 满足条件
    4. long保存溢出的乘积, 循环条件left<=right, 结束循环right值小, 满足条件
```
### [744\. 寻找比目标字母大的最小字母](https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/description/)

Difficulty: **简单**


给你一个排序后的字符列表 `letters` ，列表中只包含小写英文字母。另给出一个目标字母 `target`，请你寻找在这一有序列表里比目标字母大的最小字母。

在比较时，字母是依序循环出现的。举个例子：

*   如果目标字母 `target = 'z'` 并且字符列表为 `letters = ['a', 'b']`，则答案返回 `'a'`

**示例：**

```
输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "c"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "d"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "g"
输出: "j"

输入:
letters = ["c", "f", "j"]
target = "j"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "k"
输出: "c"
```

**提示：**

1.  `letters`长度范围在`[2, 10000]`区间内。
2.  `letters` 仅由小写字母组成，最少包含两个不同的字母。
3.  目标字母`target` 是一个小写字母。


#### Solution

Language: **Java**

```
1.二分法
    时间复杂度: O(log2(n))    n:为letters的数目
    空间复杂度的: O(1)
分析: 此处二分查找比target大的元素, 即使等于target也不能停留
核心判断:
if (letters[mid] <= target) {
    left = mid + 1;
}
​二分法搭配
    1. left<=right left=mid+1 right=mid-1
    2. left<right left=mid+1 right = mid (有left=right会进入死循环)
```
### [540\. 有序数组中的单一元素](https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/)

Difficulty: **中等**


给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

**示例 1:**

```
输入: [1,1,2,3,3,4,4,8,8]
输出: 2
```

**示例 2:**

```
输入: [3,3,7,7,10,11,11]
输出: 10
```

**注意:** 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。


#### Solution

Language: **Java**

```
1.二分查找
    时间复杂度: O(log2(n))
    空间复杂度: O(1)
核心: 单数在中间一对的奇数一边, 或者中间数就是单数
思想: 成对出现是偶数, 加一个单数, 为奇数;二分法分为左右: 偶奇偶;根据中间值划分区间, 奇数一侧存在单数;特殊情况是中间数就是单数.
2.更优雅的二分算法
    仅对偶数索引进行二分搜索
    时间复杂度: O(log2(n))
    空间复杂度: O(1)
核心思想:
    利用奇偶性值, 确定独数的位置, 直至找到;
    偶数索引值 = 偶数索引+1的值 => 单数在mid+1后
    偶数索引值 != 偶数索引+1的值 => 单数为mid或者单数在mid前
​3. 遍历法
    时间复杂度: O(n)
    空间复杂度: O(1)
```
### [278\. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)

Difficulty: **简单**


你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 `n` 个版本 `[1, 2, ..., n]`，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 `bool isBadVersion(version)` 接口来判断版本号 `version` 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

**示例:**

```
给定 n = 5，并且 version = 4 是第一个错误的版本。

调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true

所以，4 是第一个错误的版本。 
```


#### Solution

Language: **Java**

```
### [278\. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)

Difficulty: **简单**


你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 `n` 个版本 `[1, 2, ..., n]`，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 `bool isBadVersion(version)` 接口来判断版本号 `version` 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

**示例:**

```
给定 n = 5，并且 version = 4 是第一个错误的版本。

调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true

所以，4 是第一个错误的版本。 
```


#### Solution

Language: **Java**

```
1.二分查找
时间复杂度: O(n)
空间复杂度: O(1)
返回相同元素的最左边​
```
### [153\. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/)

Difficulty: **中等**


假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

**示例 1:**

```
输入: [3,4,5,1,2]
输出: 1
```

**示例 2:**

```
输入: [4,5,6,7,0,1,2]
输出: 0
```


#### Solution

Language: **Java**

```
1.二分查找
    时间复杂度: O(log2(N))
    空间复杂度: O(1)
思想: 
    1. 二分法:二分区间, 舍弃一半, 目标在另一半
    2. right位置元素和mid元素大小关系, 寻找最小值
​2.遍历法
    时间复杂度: O(n)
    空间复杂度都: O(1)
```
### [34\. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Difficulty: **中等**


给定一个按照升序排列的整数数组 `nums`，和一个目标值 `target`。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 _O_(log _n_) 级别。

如果数组中不存在目标值，返回 `[-1, -1]`。

**示例 1:**

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
```

**示例 2:**

```
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
```


#### Solution

Language: **Java**

```
​1. 二分查找
    时间复杂度: O(n) 最差情况 数组的n个元素都相同
    空间复杂度: O(1)
思想：
    1. 查找最左边元素
    2. 判断查找出来的元素等不等于数组中的元素
    3. 不等于，系统中没有该元素
    4. 等于，遍历该元素，找到末尾所以(此处可能增加时间复杂度)
2. 二分查找
    时间复杂度: O(log2(n))
    空间复杂度: O(1)
思想：
    1. 查找该元素和元素+1的最左边索引
    2. 此处，二分法才有左闭右开的方式，区别大于右端点的特殊情况
    3. 细节情况要仔细分析
        - 只有一个对应元素
        - 元素不存在，大于右端点
        - 元素不存在，小于左端点
        - 元素不存在, 位于区间中
    4. 两次二分查找, 总时间复杂度:O(log2(n))
```