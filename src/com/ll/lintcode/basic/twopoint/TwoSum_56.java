package com.ll.lintcode.basic.twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 * <p>
 * 样例
 * Example1:
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].
 * Example2:
 * 给出 numbers = [15, 2, 7, 11], target = 9, 返回 [1, 2].
 * 挑战
 * Either of the following solutions are acceptable:
 * <p>
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * 注意事项
 * 你可以假设只有一组答案。
 */
public class TwoSum_56 {

    //version 1 hashMap
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]), i};
            }
            map.put(target - numbers[i], i);
        }
        return null;
    }

    //version 2 sort and 2P
    public int[] twoSum2(int[] numbers, int target) {

        return null;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,0,-1};
        TwoSum_56 dto = new TwoSum_56();
        int[] res = dto.twoSum2(ints, 1);
        if (res != null){
            for (int i : res){
                System.out.print(i + " ");
            }
        }
    }

}
