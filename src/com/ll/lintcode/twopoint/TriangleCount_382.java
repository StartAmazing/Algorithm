package com.ll.lintcode.twopoint;

import java.util.Arrays;

/**
 * 给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？
 *
 * 样例
 * 样例 1:
 *
 * 输入: [3, 4, 6, 7]
 * 输出: 3
 * 解释:
 * 可以组成的是 (3, 4, 6),
 *            (3, 6, 7),
 *            (4, 6, 7)
 * 样例 2:
 *
 * 输入: [4, 4, 4, 4]
 * 输出: 4
 * 解释:
 * 任何三个数都可以构成三角形
 * 所以答案为 C(3, 4) = 4
 */
public class TriangleCount_382 {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        if(S == null || S.length < 3){
            return 0;
        }
        Arrays.sort(S);
        int count = 0;
        for(int i = 0 ;i < S.length; ++ i){
            int l = 0;
            int r = i - 1;
            while(l < r){
                if(S[l] + S[r] > S[i]){
                    count += r - l;
                    r --;
                }else{
                    l ++;
                }
            }
        }
        return count;
    }


}
