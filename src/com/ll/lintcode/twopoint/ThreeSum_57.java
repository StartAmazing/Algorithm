package com.ll.lintcode.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * <p>
 * 样例
 * 例1:
 * <p>
 * 输入:[2,7,11,15]
 * 输出:[]
 * 例2:
 * <p>
 * 输入:[-1,0,1,2,-1,-4]
 * 输出:[[-1, 0, 1],[-1, -1, 2]]
 * 注意事项
 * 在三元组(a, b, c)，要求a <= b <= c。
 * <p>
 * 结果不能包含重复的三元组。
 */
public class ThreeSum_57 {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<>();
        if(numbers == null || numbers.length < 3) {
            return res;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i ++){
            if(i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            int j = i + 1, k = numbers.length - 1;
            while (j < k){
                if(numbers[i] + numbers[j] +numbers[k] == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(numbers[i]);
                    tmp.add(numbers[j]);
                    tmp.add(numbers[k]);
                    res.add(tmp);
                    j ++;
                    k --;
                    while (j < k && numbers[j] == numbers[j - 1]){
                        j ++;
                    }
                    while (j < k && numbers[k] == numbers[k + 1]){
                        k --;
                    }
                }else if(numbers[i] + numbers[j] + numbers[k] > 0){
                    k --;
                }else{
                    j ++;
                }
            }
        }

        return res;
    }
}
