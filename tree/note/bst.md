### [669\. 修剪二叉搜索树](https://leetcode-cn.com/problems/trim-a-binary-search-tree/description/)

Difficulty: **简单**


给定一个二叉搜索树，同时给定最小边界`L` 和最大边界 `R`。通过修剪二叉搜索树，使得所有节点的值在`[L, R]`中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。

**示例 1:**

```
输入: 
    1
   / \
  0   2

  L = 1
  R = 2

输出: 
    1
      \
       2
```

**示例 2:**

```
输入: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

输出: 
      3
     / 
   2   
  /
 1
```


#### Solution

Language: **Java**

```
1.递归
时间复杂度: O(n) n:树的节点数目
空间复杂度: O(h) h:树的高度
思想: 
 1.当前节点的值 < L, 去右区间检查是否存在符合条件的节点
 2.当前节点的值 > R, 去左区间检查是否存在符合条件的节点
 3.当前结点的值 在[L, R]闭区间中, 符合条件正常传递
​
递归修建枝叶
思想: 
    1. 符合条件, 父子关系不变
    2. 不符合条件, 递归传递中跳过不符合条件的节点, 返回深层符合条件的节点, 实现BST的修枝剪叶
```
### [230\. 二叉搜索树中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/)

Difficulty: **中等**


给定一个二叉搜索树，编写一个函数 `kthSmallest` 来查找其中第 **k **个最小的元素。

**说明：**  
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

**示例 1:**

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
```

**示例 2:**

```
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
```

**进阶：**  
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 `kthSmallest` 函数？


#### Solution

Language: **Java**

```
1.中序遍历
    时间复杂度: O(n)  n: 树的元素数目
    空间复杂度: O(h)  h: 树的高度
思考: 代码不够优雅
​2.中序遍历解法(Cyc2018)
    时间复杂度: O(n)  n: 树的元素数目
    空间复杂度: O(h)  h: 树的高度
既然上解法已经使用一个成员变量,我们不妨使用两个
3.递归(分治算法)
思想: 我们的目的是找到第k个最小值, 找到了我们就结束递归
    1.对于一颗排序二叉树, 对于根节点第k个最小值, 对于左子树第k个最小元素, 对于右子树第k-1-left个最小值
    2.如何判断是当前节点, k-1等于当前节点的左节点数目,
    3.当前节点的左子节点数目>k-1, 目标节点在左子树
    4.当前节点的左子节点数目<k-1, 目标节点在右子树
    时间复杂度: n*log2(n) n:树的元素树
    空间复杂度: O(h)  h:树的高度
分支算法体会:
    1.当前问题怎么解决, 下一级如何解决;
    2.复杂问题是由简单问题按照规律组成的
4.迭代法 DFS(栈)
    时间复杂度: O(h+k)  h:树的高度,
    空间复杂度: O(h+k)
总结: BST性质, 中序遍历升序遍历, 能解决很多问题
```
### [538\. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/)

Difficulty: **简单**


给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

**例如：**

```
输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
```

**注意：**本题和 1038:  相同


#### Solution

Language: **Java**

```
此题目考察实质为: 树的反中序遍历
1. 右-中-左递归
    时间复杂度: O(n)  n:树的元素数
    空间复杂度: O(h)  h:树的高度
​2.DFS迭代
    时间复杂度: O(n)  n:树的元素数
    空间复杂度: O(h)  h:树的高度
3.Morris遍历
    时间复杂度: O(n)
    空间复杂度: O(1)
```
### [235\. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)

Difficulty: **简单**


给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png)

**示例 1:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
```

**示例 2:**

```
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
```

**说明:**

*   所有节点的值都是唯一的。
*   p、q 为不同节点且均存在于给定的二叉搜索树中。


#### Solution

Language: **Java**

```
235.二叉搜索树的最近公共祖先
题目给的条件:
    1.树 是 二叉搜索树
    2.题目说明:
        a.所有节点的值都是唯一的
        b.p、q为不同节点且均存在于给定的二叉搜索树中
综上, 此处在考察BST的性质, 左子节点的值小于根节点的值, 右子节点的值大于根节点的值
​1.递归法
 时间复杂度: O(h)  h:树的高度
 空间复杂度: O(h)
2.迭代法
思想: 根据值的关系, 遍历, 无序使用栈和队列(这里我们不需要回溯, 可以一往无前的走[下]去)
    时间复杂度: O(h) h:树的高度
    空间复杂度: O(1)
```
### [236\. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)

Difficulty: **中等**


给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（**一个节点也可以是它自己的祖先**）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png)

**示例 1:**

```
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
```

**示例 2:**

```
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
```

**说明:**

*   所有节点的值都是唯一的。
*   p、q 为不同节点且均存在于给定的二叉树中。


#### Solution

Language: **Java**

```
236. 二叉树的最近公共祖先
    与之间 BST最近公共祖先不同, 普通二叉树没有排序性质
题目条件:
    a.所有节点的值都是唯一的
    b.p、q为不同节点且均存在于给定的二叉搜索树中
个人理解:
    与669修剪二叉搜索树, 有一定的相似性, 在树中寻找我们感兴趣的节点, 并返回;
1.递归法
时间复杂度: O(n)  n:树的节点个数
空间复杂度: O(h)  h:树的深度
思考:
把一颗树, 提取关节信息, 去除我们不要的信息, 再来分析问题, 会找到如何解决该类问题的方法
(1） 如果当前结点 root 等于 NULL，则直接返回 NULL
(2) 如果 root 等于 p 或者 q ，那这棵树一定返回 p 或者 q
(3) 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 left 和 right 表示
(4) 此时若left为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left[此情况包含已经找到最近公共祖先]
(5) 如果 left 和 right 都非空，因为只给了 p 和 q 两个结点，都非空，说明一边一个，因此 root 是他们的最近公共祖先
(6) 如果 left 和 right 都为空，则返回空（其实已经包含在前面的情况中了）
3.存储父节点(HashMap HashSet)
利用Map的映射关系 子=>父
利用HashSet查找最近公共祖先
​
```
### [108\. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/)

Difficulty: **简单**


将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树_每个节点 _的左右两个子树的高度差的绝对值不超过 1。

**示例:**

```
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
```


#### Solution

Language: **Java**

```
二叉搜索树和有序数由天然的对应的关系, 此处要求构建一颗[平衡]二叉搜索树;
所谓平衡二叉树, 是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
进而思考, 每个节点所在二叉树中, 它的值为二叉树的中间值, 故采用平分数组构建二叉树, 直至数组中没有元素;
​1.递归
 时间复杂度: O(n)  n: 数组的元素数目
 空间复杂度: O(h)  h: log2(n)
2.非递归解法
    栈模拟递归
    队列
```
### [109\. 有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/description/)

Difficulty: **中等**


给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树_每个节点 _的左右两个子树的高度差的绝对值不超过 1。

**示例:**

```
给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
```


#### Solution

Language: **Java**

```
考察: 
    中序遍历的理解, 中序遍历和二叉排序树的关系, 数组/链表与树的映射关系, 平衡二叉树的理解, 平衡二叉树对应中位数
1.递归
    时间复杂度: O(n*log2(n))
    空间复杂度: O(long2(n))
采用快慢指针寻找链表中间位置的前一位置
    链表中, 找mid位置的前一位置
    快慢指针, 查找中间位置时, 要注意快慢指针的起始位置, 快指针的停止
    此处由于链表的单指向性质, 返回中间位置的前一位置
​2.递归+转化为数组
    时间复杂度: O(n)
    空间复杂度: O(n)
    相比与前者, 空间复杂度升高, 时间复杂度降低
    此处使用的数组是 ArrayList, 虽然是链表的实现, 内部实质为接口
以上两种算法都是用类似上题目的方法, 在不同的地方做了弥补
3.中序遍历模拟（妙）
    时间复杂度: O(n)  n:链表节点数目
    空间复杂度: O(log2(n))
思想:
    先测得链表长度, 根据长度做中序遍历, 将链表元素一个一个地安排进树, 通过递归连接起来, 妙啊!
```
### [653\. 两数之和 IV - 输入 BST](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/)

Difficulty: **简单**


给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

**案例 1:**

```
输入: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

输出: True
```

**案例 2:**

```
输入: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

输出: False
```


#### Solution

Language: **Java**

```
1.二叉树 (转化)=> 数组(ArrayList) 双指针法
    时间复杂度: O(n)
    空间复杂度: O(n)
2.HashSet方法
思想: 一边遍历, 一边验证/添加, 寻找target-curTreeNode.val
    时间复杂度: O(n)
    空间复杂度: O(n)
​3.BST查找法
    利用BST的性质(遍历一个, 查找需要的另一个)
    时间复杂度: n*log2(n) BST要是退化为链表，时间复杂度就是最糟糕的情况n^2
    空间复杂度: O(1)
    查找函数 + 遍历函数
两树之和, 另一种变形, 第一种方式借助于数组, 第二种方式借助于哈希表, 类似leetcode第一题
第三种方式, 利用BST的的查找性质\
ArrayList, 实现链表接口, 底层数组
```
### [530\. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/)

Difficulty: **简单**


给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

**示例：**

```
输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
```

**提示：**

*   树中至少有 2 个节点。
*   本题与 783 相同


#### Solution

Language: **Java**

```
BST性质: 二叉搜索树与中序遍历
​530. 二叉搜索树的最小绝对差
    通过中序遍历二叉搜索树得到的关键码序列是一个递增序列.
    这是二叉树搜索树的一个重要性质, 巧妙利用这一性质可以解决一系列二叉搜索树问题.
1.递归(中序遍历)
    时间复杂度: O(n)  n: 树的节点个数
    空间复杂度: O(h)  h: 树的高度
2.DFS遍历(栈)
    时间复杂度: O(n)  n: 树的节点个数
    空间复杂度: O(h)  h: 树的高度
```
### [501\. 二叉搜索树中的众数](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)

Difficulty: **简单**


给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

*   结点左子树中所含结点的值小于等于当前结点的值
*   结点右子树中所含结点的值大于等于当前结点的值
*   左子树和右子树都是二叉搜索树

例如：  
给定 BST `[1,null,2,2]`,

```
   1
    \
     2
    /
   2
```

`返回[2]`.

**提示**：如果众数超过1个，不需考虑输出顺序

**进阶：**你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）


#### Solution

Language: **Java**

```
BST性质: 二叉搜索树与中序遍历
1.DFS迭代
    时间复杂度: O(n)  n: 树的节点数目
    空间复杂度: O(n)  n是最差情况, DFS遍历: h:树的高度 List存储众数
2.递归

细节:
    1.众数怎么寻找
    2.中间处理
    3.最后一个数处理
```















