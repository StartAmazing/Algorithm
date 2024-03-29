package com.ll.nine_chapter.base.d_depth_first_search;

import com.sun.scenario.effect.impl.state.AccessHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CombinationDfs {

    /**
     * @link https://www.lintcode.com/problem/135/
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     *          we will sort your return value in output
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        candidateDfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void candidateDfs(int[] candidates,
                              int remind,
                              int startIndex,
                              List<Integer> subList,
                              List<List<Integer>> res) {
        if (remind == 0) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (remind < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            subList.add(candidates[i]);
            candidateDfs(candidates, remind - candidates[i], i, subList, res);
            subList.remove(subList.size() - 1);
        }
    }


    /**
     * @link https://www.lintcode.com/problem/153/
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     *          we will sort your return value in output
     */
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        candidate2Dfs(num, 0, target, new ArrayList<>(), res);
        return res;
    }

    private static void candidate2Dfs(int[] nums,
                               int startIdx,
                               int remind,
                               List<Integer> subList,
                               List<List<Integer>> res) {
        if (remind == 0) {
            res.add(new ArrayList<>(subList));
        }
        if (remind < 0) {
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]) {
//            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            subList.add(nums[i]);
            candidate2Dfs(nums, i + 1, remind - nums[i], subList, res);
            subList.remove(subList.size() - 1);
        }
    }

    /*
     * @link https://www.lintcode.com/problem/136/
     * @param s: A string
     * @return: A list of lists of string
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        partitionHelper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void partitionHelper(String s,
                               int startIdx,
                               List<String> partition,
                               List<List<String>> res) {
        if (startIdx == s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            String subStr = s.substring(startIdx, i + 1);
            if (!checkOk(subStr)) {
                continue;
            }
            partition.add(subStr);
            partitionHelper(s, i + 1, partition, res);
            partition.remove(partition.size() - 1);
        }
    }

    private static boolean checkOk(String substring) {
        if (substring.length() <= 1) {
            return true;
        }
        char[] chars = substring.toCharArray();
        int left = 0, right = substring.length() - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    private boolean[][] palindromeArray;
    private void getPalindromeArray(String s) {
        int n = s.length();
        palindromeArray = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            palindromeArray[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            palindromeArray[i][i+1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                palindromeArray[i][j] = palindromeArray[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }

    /**
     * @link https://leetcode.cn/problems/longest-palindromic-substring/
     * @param s a string
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] palindromeArray = new boolean[n][n];
        String res = "";
        for (int i = 0; i < n; i++) {
            palindromeArray[i][i] = true;
            res = String.valueOf(chars[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            palindromeArray[i][i + 1] = chars[i] == chars[i + 1];
            if (palindromeArray[i][i + 1]) {
                res = s.substring(i, i + 2);
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = i - 2; j >= 0; j--) {
                System.out.println("i: " + i + ", j: " + j);
                palindromeArray[j][i] = palindromeArray[j + 1][i - 1] && chars[i] == chars[j];
                if (palindromeArray[j][i] && i - j + 1 > res.length()) {
                        res = s.substring(j, i + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] candidates = new int[]{7,1,2,5,1,6,10};
//        int target = 8;
//        List<List<Integer>> lists = combinationSum(candidates, target);
//        System.out.println(lists);
//
//        List<List<Integer>> lists1 = combinationSum2(candidates, target);
//        System.out.println(lists1);

        String partitionData = "abcd";
        System.out.println(partition(partitionData));
        String data = "aaaaa";
        System.out.println(data.substring(1, 4));
        System.out.println(longestPalindrome(data));
    }
}
