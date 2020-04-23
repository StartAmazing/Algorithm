package com.ll.lintcode.dp.chapter3;

import com.ll.muke.queue.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。一
 * 个信封的宽高均大于另一个信封时可以放下另一个信封。
 * 求最大的信封嵌套层数。
 *
 * 样例
 * 样例 1:
 *
 * 输入：[[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：
 * 最大的信封嵌套层数是 3 ([2,3] => [5,4] => [6,7])。
 * 样例 2:
 *
 * 输入：[[4,5],[4,6],[6,7],[2,3],[1,1]]
 * 输出：4
 * 解释：
 * 最大的信封嵌套层数是 4 ([1,1] => [2,3] => [4,5] / [4,6] => [6,7])。
 *
 * 最长序列型动态规划
 *
 * 1. 将所有信封按照长度一维进行排序： E0, E1, E2, ... , E(n-1)
 *    这样，如果信封Ej能够放入信封Ei里，那么一定有j < i
 *    排序后，如果一个信封Ei是最外层的信封，那么它里面的第一层信封Ej一定满足 j < i
 *
 *
 */
public class RussianDollEnvelopes_602 {


    //O(nlog n + n^2)
    public int russianDollEnvelopes(int[][] envelopes){
        if (null == envelopes || envelopes.length < 1){
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i ++){
            dp[i] = 1;
            for (int j = 0; j < i; j ++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(dp[i], res);
        }

        return res;
    }

    //O(nlog n)  loading ...
}
