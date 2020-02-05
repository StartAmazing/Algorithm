package com.ll.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
