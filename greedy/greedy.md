### [455\. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/)

Difficulty: **简单**


假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 g<sub style="display: inline;">i ，</sub>这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 s<sub style="display: inline;">j </sub>。如果 s<sub style="display: inline;">j</sub> >= g<sub style="display: inline;">i </sub>，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

**注意：**

你可以假设胃口值为正。  
一个小朋友最多只能拥有一块饼干。

**示例 1:**

```
输入: [1,2,3], [1,1]

输出: 1

解释: 
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
```

**示例 2:**

```
输入: [1,2], [1,2,3]

输出: 2

解释: 
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.
```


#### Solution

Language: **Java**

```
1. 贪心算法
   时间复杂度: O(nlog2(n)) 排序算法  n: max{g, s}
   空间复杂度: O(1)
此处贪心算法策略
   1. 给一个孩子的饼干应当尽量小并且又能满足孩子, 这样大饼干才能拿来满足较大的孩子
   2. 因为满足最小的孩子, 最容易得到满足, 所以先满足满足度最小的孩子
   验证贪心算法能得到最优解
实际操作:
   1.先排序两个数组
   2.最小的饼干, 先给饭量最小的人, 迭代(验证当前饼干能否满足当前孩子, 孩子满足, 孩子+1到下个孩子, 无论孩子满足与否, 饼干都要下一个)
   3.直到饼干没有了或者孩子都满足了
​
```
### [435\. 无重叠区间](https://leetcode-cn.com/problems/non-overlapping-intervals/)

Difficulty: **中等(标记)**


给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

**注意:**

1.  可以认为区间的终点总是大于它的起点。
2.  区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

**示例 1:**

```
输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
```

**示例 2:**

```
输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
```

**示例 3:**

```
输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
```


#### Solution

Language: **Java**

```
1. 贪心算法
    时间复杂度: O(nlog2(n)) n:区间个数(中间使用了排序)
    空间复杂度: O(1)
问题转换: 
    (贪心策略的选择, 时段头, 时段尾, 时段长度, 时段交叉少)
    先计算最多能组成的不重叠区间的个数, 最后利用区间总个数 减去 不重叠区间的个数
    最多能组成的不重叠区间的个数, 在每次选择中, 区间结尾最为重要, 选择区间结尾越小, 留给后边的区间的空间越大. 那么, 后边能够选择的区间个数也就越大
    区间相接, 下一个区间头 大于等于 当前的区间尾
2. 暴力方法: 尝试不同的组合
    时间复杂度: O(2^n)
    空间复杂度: O(n)
3.动态规划(留作后边练习)
​
```
### [452\. 用最少数量的箭引爆气球](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/)

Difficulty: **中等**


在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在10<sup>4</sup>个气球。

一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 x<sub style="display: inline;">start，</sub>x<sub style="display: inline;">end，</sub> 且满足  x<sub style="display: inline;">start</sub> ≤ x ≤ x<sub style="display: inline;">end，</sub>则该气球会被引爆<sub style="display: inline;">。</sub>可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

**Example:**

```
输入:
[[10,16], [2,8], [1,6], [7,12]]

输出:
2

解释:
对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
```


#### Solution

Language: **Java**

```
1. 贪心算法
    上一题题目的具体应用, 不同之处: 相等算相交
​
```
### [406\. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/)

Difficulty: **中等**


假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对`(h, k)`表示，其中`h`是这个人的身高，`k`是排在这个人前面且身高大于或等于`h`的人数。 编写一个算法来重建这个队列。

**注意：**  
总人数少于1100人。

**示例**

```
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```


#### Solution

Language: **Java**

```
1.贪心算法
    时间复杂度:   O(n^2)
        排序: O(nlog2(n))
        插入队列: O(k) k:当前队列元素书, k从1到n, 插入n此(查找+插入)
    空间复杂度: O(1)
思路核心: 个子矮的人相对于个子高的人是看不见的(抓住问题实质, 问题转换)
    按照身高 降序, k升序排列
    先排高的, 再排矮的, 矮的人不影响高的人的排序
```
### [121\. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/)

Difficulty: **简单**


给定一个数组，它的第 _i_ 个元素是一支给定股票第 _i_ 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

**示例 1:**

```
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
```

**示例 2:**

```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```


#### Solution

Language: **Java**

```
1.贪心算法
    时间复杂度: O(n)
    空间复杂度: O(1)
个人分析:
    1. 把股票价格数组分成 组内第一个元素是最小值 的区间(具体区间个数由数组决定)
        [7,1,5,3,6,4] => [7|1,5,3,6,4]
        [7,6,4,3,1] => [7| 6 | 4 | 3 | 1]
    2. 每个区间中计算获利, 保存最大利润
个人体会:
    数据可视化, 画图分析数据看, 本题目中可以画折线图
2. 暴力法
    时间复杂度: O(n^2)
    空间复杂度: O(1)
```
### [122\. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

Difficulty: **简单(收藏,有一个动态规划解法)**


给定一个数组，它的第 _i_ 个元素是一支给定股票第 _i_ 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

**注意：**你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

**示例 1:**

```
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
```

**示例 2:**

```
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
```

**示例 3:**

```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

**提示：**

*   `1 <= prices.length <= 3 * 10 ^ 4`
*   `0 <= prices[i] <= 10 ^ 4`


#### Solution

Language: **Java**

```
1. 暴力法(看别人怎么写的)
2. 贪心算法
    一策略: 谷底 - 峰值
    二策略: 分析以后, 涨钱就买入卖出.
时间复杂度: O(n)
空间复杂度: O(1)
​
```
### [605\. 种花问题](https://leetcode-cn.com/problems/can-place-flowers/)

Difficulty: **简单**


假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 **n **。能否在不打破种植规则的情况下种入 **n **朵花？能则返回True，不能则返回False。

**示例 1:**

```
输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
```

**示例 2:**

```
输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
```

**注意:**

1.  数组内已种好的花不会违反种植规则。
2.  输入的数组长度范围为 [1, 20000]。
3.  **n** 是非负整数，且不会超过输入数组的大小。


#### Solution

Language: **Java**

```
种花问题(代码可用(不够优雅) => 学习别人代码, 细节处理)
1.贪心算法
    问题转化为最多能种多少花, 然后与n比较(进步)
    代码存在的问题:
    数组左右边界处理的有问题,
    这里我用的是一个变量, 最后一个数组单独处理方式;感觉有些混乱
    时间复杂度: O(n)  n: 数组的元素书 => 可以进一步优化, 达到了要求种植数目
    空间复杂度: O(1)
    思考: 若是不改变原数组结构, 可以使用boolean preFlower变量
2. 优秀题解:
    三元运算符, 处理边界问题
```
### [392\. 判断子序列](https://leetcode-cn.com/problems/is-subsequence/)

Difficulty: **简单**


给定字符串 **s** 和 **t** ，判断 **s** 是否为 **t** 的子序列。

你可以认为 **s** 和 **t** 中仅包含英文小写字母。字符串 **t** 可能会很长（长度 ~= 500,000），而 **s** 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，`"ace"`是`"abcde"`的一个子序列，而`"aec"`不是）。

**示例 1:**  
**s** = `"abc"`, **t** = `"ahbgdc"`

返回 `true`.

**示例 2:**  
**s** = `"axc"`, **t** = `"ahbgdc"`

返回 `false`.

**后续挑战** **:**

如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

**致谢:**

特别感谢添加此问题并且创建所有测试用例。


#### Solution

Language: **Java**

```
1.双指针
    时间复杂度: O(t) t:字符串t的长度
    空间复杂度: O(1)
2.双指针优化
    a.字符串 => 字符数组
    b.String API indexOf(char c, int index)  => 字符串的index位置(包括)后, 由于c匹配返回新的位置, 没有返回-1
注意: index需要+1, 匹配完了字符, 不能继续使用
    时间复杂度: O(t) t:字符串t的长度
    空间复杂度: O(1)
3.如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，
你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
    假如长字符串的长度为n，建立一个n * 26 大小的矩阵，表示每个位置上26个字符[下一次]出现的位置。
    aba 0位置的下一个a位置是2, 除去自己
    对于大量数据, 建立了数据字典, 分析了要匹配的t
时间复杂度: O(s) s:字符串s的长度
空间复杂度: O(t) t:字符串t的长度
```
### [665\. 非递减数列](https://leetcode-cn.com/problems/non-decreasing-array/)

Difficulty: **简单**


给你一个长度为 `n` 的整数数组，请你判断在 **最多** 改变 `1` 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 `i` (1 <= i < n)，总满足 `array[i] <= array[i + 1]`。

**示例 1:**

```
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
```

**示例 2:**

```
输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
```

**说明：**

*   `1 <= n <= 10 ^ 4`
*   `- 10 ^ 5 <= nums[i] <= 10 ^ 5`


#### Solution

Language: **Java**

```
1.贪心算法
    时间复杂度: O(n)  n:数组元素个数
    空间复杂度: O(1)
核心思想: 发现逆序[a, b](a>b), 是令a=b还是b=a, 
    c, a, b
        - c a非递减序, 令b=a
        - c b非递减序, 另a=b(可能c不存在, a为边界)
体会: 
    1. 受示例限制, 思考情况不全面, 只是看示例编写方法
    2. 要多考虑情况, 手写例子, 考虑全面
2. 暴力匹配
    时间复杂度: O(n^2)
    空间复杂度: O(1)
​
```
### [53\. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

Difficulty: **简单**


给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

**示例:**

```
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

**进阶:**

如果你已经实现复杂度为 O(_n_) 的解法，尝试使用更为精妙的分治法求解。


#### Solution

Language: **Java**

```
1. 暴力法
    时间复杂度: O(n^2)
    空间复杂度: O(1)
2. 动态规划
   时间复杂度: O(n)
   空间复杂度: O(n)
思想: 当前节点dp[i]时当前数字, 要么是与前面的最大子序列和, 要么是当前节点
   dp[i]表示nums中nums[i]结尾的最大子序列和
   dp[i] = max(dp[i-1]+nums[i], nums[i])
3. 贪心算法
    时间复杂度: O(n)
    空间复杂度: O(1)
个人解题思路:
    想到了是前n项和, 但是不知道怎么处理, 怎么保证最大序列.
    从索引0开始累加序列, 当累加<0时, 重新选择新的序列; 迭代中记录序列累加最大值
动态规划->贪心算法
    挖掘问题的实质, 能贪一点是一点
4.分治算法
    取数组中心点为中心
    最大子序要么全在中心左边
    要么在右边,
    要么跨中心
    分三种情况进行考虑
    时间复杂度: O(nlog2(n))
    空间复杂度: O(log2(n))

```
### [763\. 划分字母区间](https://leetcode-cn.com/problems/partition-labels/)

Difficulty: **中等**


字符串 `S` 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

**示例 1:**

```
输入: S = "ababcbacadefegdehijhklij"
输出: [9,7,8]
解释:
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
```

**注意:**

1.  `S`的长度在`[1, 500]`之间。
2.  `S`只包含小写字母`'a'`到`'z'`。


#### Solution

Language: **Java**

```
1.贪心算法
问题关键信息: 字母的开始位置(遍历时, 自然会找到), 字母的结束位置(一次遍历形成数组)
终止条件: 在二次遍历中, 遍历值=end
   时间复杂度: O(n)  n:字符串s长度
   空间复杂度: O(n)  chars数组
​体会: 自己根据以前题目, 想出解法, 但要根据具体题目进一步优化.(具体问题, 具体分析, 不能盲目照搬)
```