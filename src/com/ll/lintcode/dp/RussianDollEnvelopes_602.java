package com.ll.lintcode.dp;

import com.ll.muke.queue.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。一个信封的宽高均大于另一个信封时可以放下另一个信封。
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
 */
public class RussianDollEnvelopes_602 {

    //lintcode timeout
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length < 1){
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] < 0 ? -1 : 1;
            }
        });

        int[] f = new int[envelopes.length];
        for (int i = 0; i < f.length; i++){
            f[i] = 1;
        }

        for (int i = 1;  i < envelopes.length; i ++){
            for (int j = 0; j < i; j ++){
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] != envelopes[j][0]){
                    f[i] = Math.max(f[j] + 1, f[i]);
                 }
            }
        }

        int best = 1;
        for (int i = 0; i < f.length; i++){
            best = Math.max(best, f[i]);
        }

        return best;
    }

}
