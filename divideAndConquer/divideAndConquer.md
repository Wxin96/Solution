### [241\. 为运算表达式设计优先级](https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/)

Difficulty: **中等**


给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 `+`, `-` 以及 `*` 。

**示例 1:**

```
输入: "2-1-1"
输出: [0, 2]
解释: 
((2-1)-1) = 0 
(2-(1-1)) = 2
```

**示例 2:**

```
输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
```


#### Solution

Language: **Java**

```
1.分治算法
    思想:
         1.分解: 按运算符分成左右两部分, 分别求解
         2.解决: 实现一个递归函数, 输入算式, 返回算式解
         3.合并: 根据运算符合并左右两部分的解, 得出最终解
    时间复杂度: O(4^n/n^{1/2})    卡特兰数
    空间复杂度: O(4^n/n^{1/2})
​2.动态规划
    问题:
        1.字符串长度与数组个数混淆
        2.动态规划中, 链表的值未加入状态转移数组中
        3.索引遍历和长度遍历没有清楚的区分
    思路:
        1.状态转移方程
        2.状态方程初始值
        3.最终返回值
```
### [95\. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/)

Difficulty: **中等**


给定一个整数 _n_，生成所有由 1 ... _n_ 为节点所组成的 **二叉搜索树** 。

**示例：**

```
输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

**提示：**

*   `0 <= n <= 8`


#### Solution

Language: **Java**

```
 1.分治算法
    思想:
      1.分解: 一个元素作为根节点, 作为左右两部分
      2.解决: 实现一个递归函数, 输入树的的范围, 返回所有可能情况
      3.合并: 根节点合并所有左右的树的情况
    时间复杂度: O(4^n/n^{1/2})    卡特兰数
    空间复杂度: O(4^n/n^{1/2})
​2.动态规划
 思想:
  dp[n]: 输入n时, 生成所有可能的二叉树
  dp[i] => dp[i+1], 0-i+1作为顶点生成二叉树, 使用结构同构方法[妙]
  状态方程起始: dp[0] = null
```