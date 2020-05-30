### [232\. 用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks/)

Difficulty: **简单**


使用栈实现队列的下列操作：

*   push(x) -- 将一个元素放入队列的尾部。
*   pop() -- 从队列首部移除元素。
*   peek() -- 返回队列首部的元素。
*   empty() -- 返回队列是否为空。

**示例:**

```
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
```

**说明:**

*   你只能使用标准的栈操作 -- 也就是只有 `push to top`, `peek/pop from top`, `size`, 和 `is empty` 操作是合法的。
*   你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
*   假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。


#### Solution

Language: **Java**

```
232. 用栈实现队列
 栈(Stack)    LIFO结构
 队列(Queue)   FIFO结构
 方法一:
     使用两个栈
     在需要pop()时, 且outStack栈为空, 将inStack中所有元素倒入outStack中, 实现逆序
     pop的时间复杂度: O(1) O(n) n:inStack中的元素数目
 方法二:
     使用两个栈
     inStack不为空, 每push()一个新元素, 把之前元素倒入outStack中, inStack放入新元素, 再把outStack中元素倒进去
     push的时间复杂度: O(n) n:除了新元素之外的元素
​
```
### [225\. 用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues/description/)

Difficulty: **简单**


使用队列实现栈的下列操作：

*   push(x) -- 元素 x 入栈
*   pop() -- 移除栈顶元素
*   top() -- 获取栈顶元素
*   empty() -- 返回栈是否为空

**注意:**

*   你只能使用队列的基本操作-- 也就是 `push to back`, `peek/pop from front`, `size`, 和 `is empty` 这些操作是合法的。
*   你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
*   你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。


#### Solution

Language: **Java**

```
225. 用队列实现栈
方法一:
    两个队列(压入-O(1), 弹出-O(n))
    此方法, 队列中由n个元素, 弹出n-1个元素到另外队列, 再弹出第n个元素, 再把n-1个元素还原到原先队列
方法二:
    两个队列(压入-O(n), 弹出-O(1))
    两个队列在压入时, 实现逆序
方法三:
    一个队列(压入-O(n), 弹出-O(1))
    一个队列在压入时,实现逆序
```
### [155\. 最小栈](https://leetcode-cn.com/problems/min-stack/description/)

Difficulty: **简单**


设计一个支持 `push` ，`pop` ，`top` 操作，并能在常数时间内检索到最小元素的栈。

*   `push(x)` —— 将元素 x 推入栈中。
*   `pop()` —— 删除栈顶的元素。
*   `top()` —— 获取栈顶元素。
*   `getMin()` —— 检索栈中的最小元素。

**示例:**

```
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

**提示：**

*   `pop`、`top` 和 `getMin` 操作总是在 **非空栈** 上调用。


#### Solution

Language: **Java**

```
155.最小栈
思路一:
    - 数据栈
    - 辅助栈(保存对应层数的最小值栈)
        - 同步
        - 不同步(节省空间)
思路二:
    构造链表结构, 头插法逆序, 每次存入 当前值和当前最小值
思路三:
    利用同一个栈, 记录最小值.
    - 记录之前最小值
    - 栈记录实质为与当前最小值的差值
进栈 出栈 寻找最小值 时间复杂度: O(1)
```
### [20\. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/description/)

Difficulty: **简单**


给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串，判断字符串是否有效。

有效字符串需满足：

1.  左括号必须用相同类型的右括号闭合。
2.  左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。

**示例 1:**

```
输入: "()"
输出: true
```

**示例 2:**

```
输入: "()[]{}"
输出: true
```

**示例 3:**

```
输入: "(]"
输出: false
```

**示例 4:**

```
输入: "([)]"
输出: false
```

**示例 5:**

```
输入: "{[]}"
输出: true
```


#### Solution

Language: **Java**

```
​1. 栈(结构)
 时间复杂度: O(n)
 空间复杂度: O(n)
 题目理解:
 栈先入后出特点恰好与本题括号排序特点一致, 即若遇到左括号入栈, 遇到右括号时对应栈顶左括号出栈(此时栈不能为空), 
 并且遍历完所有括号后, stack为空
 优化:
    1.字符串长度为偶数(加在循环中)
    2.栈中元素, 不能大于栈的一半长度(加在起始位置, 但是判断也耗时)
```
### [739\. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/description/)

Difficulty: **中等**


根据每日 `气温` 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 `0` 来代替。

例如，给定一个列表 `temperatures = [73, 74, 75, 71, 69, 72, 76, 73]`，你的输出应该是 `[1, 1, 4, 2, 1, 1, 0, 0]`。

**提示：**`气温` 列表长度的范围是 `[1, 30000]`。每个气温的值的均为华氏度，都是在 `[30, 100]` 范围内的整数。


#### Solution

Language: **Java**

```
1.暴力匹配(双指针)
时间复杂度: O(n^2)
空间复杂度: O(1)
思想: 锁定一个元素, 去找这个元素的较大值, 找到了返回索引, 没找到返回0
问题: 存在重复查找的过程
​2.使用栈(吐槽: 这也太巧妙了)
时间复杂度: O(n)  n:数组元素个数
空间复杂度: O(n)  最差情况, 逆序; result返回数组
思考, 使用栈带着[未找到最大值的元素]去寻找最大值
```
### [503\. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii/description/)

Difficulty: **中等**


给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

**示例 1:**

```
输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
```

**注意:** 输入数组的长度不会超过 10000。


#### Solution

Language: **Java**

```
1.栈
    时间复杂度: O(n)
    空间复杂度: O(n)
思考: 
    初始想法, 双指针是找后边匹配的数
    使用栈结构, 带着数走, 去寻找更大的数, 妙啊
细节处理:
    1. 采用循环两次策略
    2. 在第二遍遍历时, 不需要在添加元素了, 采用方式 i<len
```