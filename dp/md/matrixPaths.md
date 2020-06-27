### [64\. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/description/)

Difficulty: **中等**


给定一个包含非负整数的 _m_ x _n_ 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

**说明：**每次只能向下或者向右移动一步。

**示例:**

```
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
```


#### Solution

Language: **Java**

```
64. 最小路径和
状态转移方程:
    dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + grid[i][j]
BASE CASE
    dp[0][0] = grid[0][0]
    dp[0][j] = dp[0][j-1] + grid[0][j]
    dp[i][0] = dp[i-1][0] + grid[i][0]
只用到上和左状态, 可以动态压缩, dp[j] 倒叙遍历, 因为后会用到前, 前不会用到后
```
### [62\. 不同路径](https://leetcode-cn.com/problems/unique-paths/description/)

Difficulty: **中等**


一个机器人位于一个 _m x n_ 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png)

<small style="display: inline;">例如，上图是一个7 x 3 的网格。有多少可能的路径？</small>

**示例 1:**

```
输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1\. 向右 -> 向右 -> 向下
2\. 向右 -> 向下 -> 向右
3\. 向下 -> 向右 -> 向右
```

**示例 2:**

```
输入: m = 7, n = 3
输出: 28
```

**提示：**

*   `1 <= m, n <= 100`
*   题目数据保证答案小于等于 `2 * 10 ^ 9`


#### Solution

Language: **全部题目**

```
62.不同路径
状态转移方程:
    dp[i][j] = dp[i-1][j] + dp[i][j-1]
BASE CASE
    dp[0][0] = 1
    dp[0][j] = dp[0][j-1] = 1
    dp[i][0] = dp[i-1][0] = 1
只用到上和左状态, 可以动态压缩, dp[j] 倒叙遍历, 因为后会用到前, 前不会用到后
​
数学方法: C(n-1)(m+n-2)
```


