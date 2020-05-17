### [144\. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/)

Difficulty: **中等**


给定一个二叉树，返回它的 _前序 _遍历。

 **示例:**

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
```

**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？


#### Solution

Language: **Java**

```
1. DFS迭代算法
   时间复杂度: O(n)  n:节点个数
   空间复杂度: O(n)  n:节点个数 list和stack
2. Morris解法
​
```
### [145\. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

Difficulty: **困难**


给定一个二叉树，返回它的 _后序 _遍历。

**示例:**

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
```

**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？


#### Solution

Language: **Java**

```
1.迭代法
    时间复杂度: O(n)  n:树的节点个数
    空间复杂度: O(n)  n:树的节点个数 list和stack
    后序遍历: 左 -> 右 -> 根
    改造前序: 根 -> 右 -> 左
    ​
```