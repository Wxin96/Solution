package com.apollo.recursion.pathSum;

import com.apollo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum {

    // 1.双递归
    // 递归每个节点, 每个节点作为根节点
    // 时间复杂度: O(nlog(n))
    // 空间复杂度: O()
    // n树的节点数目
    public int pathSum(TreeNode root, int sum) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.递归终止条件
        return rootPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // 一个根节点, 返回从根节点出发形成链的个数
    private int rootPathSum(TreeNode root, int sum) {
        // 0.递归终止
        if (root == null) {
            return 0;
        }
        // 1.检查是否形成链
        int result = (root.val == sum) ? 1 : 0;

        // 2.递归返回
        return result + rootPathSum(root.left, sum - root.val) + rootPathSum(root.right, sum-root.val);
    }

    // 2.单递归
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    // n:节点个数
    public int pathSum02(TreeNode root, int sum) {
        // 0.过滤
        if (root == null) {
            return 0;
        }
        // 1.初始化
        Map<Integer, Integer> map = new HashMap<>();
        // 放入(0, 1), 初始节点
        map.put(0, 1);

        return pathSumIteration(root, sum, 0, map);
    }

    private int pathSumIteration(TreeNode root, int targetSum, int pathSum, Map<Integer, Integer> map) {
        // 0.递归终点
        if (root == null) {
            return 0;
        }
        // 1.计算总和
        int curPathSum = pathSum + root.val;

        // 2.找到和相差sum的路径
        int res = map.getOrDefault(curPathSum-targetSum,0);

        // 3.当前值存入map
        map.put(curPathSum, map.getOrDefault(curPathSum, 0)+1);

        // 4.开始下一层递归, 汇总结果
        res += pathSumIteration(root.left, targetSum, curPathSum, map)
                + pathSumIteration(root.right, targetSum, curPathSum, map);

        // 5.递归回来时,修改map,map保持当前路径
        map.put(curPathSum, map.get(curPathSum)-1);
        return res;
    }


}
