package com.ll.lintcode.basic.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选数字的集合 candidates 和一个目标值 target. 找到 candidates 中所有的和为 target 的组合.
 *
 * 在同一个组合中, candidates 中的某个数字不限次数地出现.
 *
 * 样例
 * 样例 1:
 *
 * 输入: candidates = [2, 3, 6, 7], target = 7
 * 输出: [[7], [2, 2, 3]]
 * 样例 2:
 *
 * 输入: candidates = [1], target = 3
 * 输出: [[1, 1, 1]]
 * 注意事项
 * 所有数值 (包括 target ) 都是正整数.
 * 返回的每一个组合内的数字必须是非降序的.
 * 返回的所有组合之间可以是任意顺序.
 * 解集不能包含重复的组合.
 */
public class CombinationSum_135 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null) {
            return result;
        }

        Arrays.sort(candidates);

        List<Integer> curList = new ArrayList<>();
        recursion(candidates, 0, target, curList, result);
        return result;
    }

    //1. 递归的定义
    //找到所有以combination开头的那些和为target的集合
    //并丢到result结果集合中，其中剩余的需要加入combination里的数的和为remindTarget
    //并且下一个可以加入combination中的数至少从candidate的startIdx开始
    private void recursion(int[] candidates,
                           int startIdx,
                           int remindTarget,
                           List<Integer> curList,
                           List<List<Integer>> result) {

        //3. 递归出口之一
        if (remindTarget == 0) {
            result.add(new ArrayList<>(curList));
            return;
        }

        //2. 递归的拆解
        for (int i = startIdx; i < candidates.length; i++) {

            //3. 递归出口之二
            if (remindTarget < candidates[i]) {
                break;
            }

            //过滤重复
            //[2, 2, 3, 3, 6, 7]
            //    ^
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            curList.add(candidates[i]);
            recursion(candidates, i, remindTarget - candidates[i], curList, result);
            curList.remove(curList.size() - 1);
        }
    }


}
