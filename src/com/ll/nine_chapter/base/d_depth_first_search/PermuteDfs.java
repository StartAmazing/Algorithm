package com.ll.nine_chapter.base.d_depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteDfs {

    /*
     * @link https://www.lintcode.com/problem/15/
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums) {
            return res;
        }

        help(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }

    private static void help(int[] nums,
                      boolean[] visited,
                      List<Integer> oneOf,
                      List<List<Integer>> res){
        if(oneOf.size() == nums.length){
            res.add(new ArrayList<>(oneOf));
        }

        for (int i = 0; i < nums.length ; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            oneOf.add(nums[i]);
            help(nums, visited, oneOf, res);
            visited[i] = false;
            oneOf.remove(oneOf.size() - 1);
        }
    }

    /**
     * @link https://www.lintcode.com/problem/16/
     * @param nums: A list of integers
     * @return: A list of unique permutations
     *          we will sort your return value in output
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        Arrays.sort(nums);
        helpII(nums, new boolean[nums.length], new ArrayList<>(), res);

        return res;
    }

    private static void helpII(int[] nums,
                        boolean[] visited,
                        List<Integer> subSet,
                        List<List<Integer>> res) {
        if (subSet.size() == nums.length) {
            res.add(new ArrayList<>(subSet));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            subSet.add(nums[i]);
            helpII(nums, visited, subSet, res);
            subSet.remove(subSet.size() - 1);
            visited[i] = false;
        }
    }

    /**
     * @link https://www.lintcode.com/problem/33/
     * @param n: The number of queens
     * @return: All distinct solutions
     *          we will sort your return value in output
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        helpForQueen(n, new ArrayList<>(), res);

        return res;
    }

    private static void helpForQueen(Integer n,
                              List<Integer> cols,
                              List<List<String>> res) {
        if (cols.size() == n) {
            res.add(drawBoard(cols));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 递归的时候就能判断是否还要进行（类似拆分字符串的问题），但是一个是排列一个是组合
            if (!isValidForQueue(cols, i)) {
                continue;
            }

            cols.add(i);
            helpForQueen(n, cols, res);
            cols.remove(cols.size() - 1);
        }
    }

    private static List<String> drawBoard(List<Integer> chess) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chess.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chess.size(); j++ ){
                if (chess.get(i) == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }

        return res;
    }

    // 这个里新存在的元素的row只能是最后一行，也就是cols的size层
    private static boolean isValidForQueue(List<Integer> cols, int column) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == column) { // 同一列
                return false;
            }
            if (cols.get(i) + i == column + row) { // 正对角线
                return false;
            }
            if (cols.get(i) - i == column - row) { // 反对角线
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 2, 3});
        System.out.println(res);
        List<List<Integer>> res2 = permuteUnique(new int[]{1, 2, 2, 3});
        System.out.println(res2);
        List<List<String>> res3 = solveNQueens(4);
        for (int i = 0; i < res3.size(); i++) {
            System.out.println(res3.get(i));
        }
    }

}
